package kakushin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable

@Entity(name = "TestUser")
class User(
    @Id
    val id: Long,
    val name: String,
    val email: String
) : Serializable