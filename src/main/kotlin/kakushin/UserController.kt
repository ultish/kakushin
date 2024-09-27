package kakushin

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
    @Operation(summary = "Create a new app user")
    @ApiResponse(responseCode = "201", description = "App user created",
        content = [Content(mediaType = "application/json",
            schema = Schema(implementation = User::class))])
    @PostMapping
    fun createAppUser(@RequestBody appUser: User): ResponseEntity<User> {
        val createdAppUser = userService.createAppUser(appUser)
        return ResponseEntity(createdAppUser, HttpStatus.CREATED)
    }


    @GetMapping
    fun getAllusers(): Collection<User> {
        return userService.getUsers()
    }

    @Operation(summary = "Get an by ID")
    @ApiResponse(responseCode = "200", description = "Found the user",
        content = [Content(mediaType = "application/json",
            schema = Schema(implementation = User::class)
        )])
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): User? {
        return userService.getUserById(id)
    }
}