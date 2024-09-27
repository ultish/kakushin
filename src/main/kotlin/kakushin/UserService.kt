package kakushin

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    @CacheEvict("app_users", allEntries = true)
    fun createAppUser(appUser: User): User {
        println("Creating new app user...")
        return userRepository.save(appUser)
    }

    @Cacheable("users", key = "#id")
    fun getUserById(id: Long): User? {
        println("Fetching user from database...")
        return userRepository.findById(id).orElse(null)
    }

    @Cacheable("users", key = "'allusers'")
    fun getUsers(): Collection<User>{
        return userRepository.findAll()
    }

}