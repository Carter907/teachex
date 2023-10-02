package carte.proj.teachexback.controller

import carte.proj.teachexback.dto.LoginDTO
import carte.proj.teachexback.dto.LoginResponseDTO
import carte.proj.teachexback.dto.RegistrationDTO
import carte.proj.teachexback.model.User
import carte.proj.teachexback.service.AuthenticationService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody registration: RegistrationDTO): User {
        return authenticationService.registerUser(registration.username, registration.password)
    }
    @PostMapping("/login")
    fun loginUser(@RequestBody login: LoginDTO): LoginResponseDTO {
        println(login)
        return authenticationService.loginUser(login.username, login.password);
    }
}