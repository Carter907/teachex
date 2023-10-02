package carte.proj.teachexback.service

import carte.proj.teachexback.dto.LoginResponseDTO
import carte.proj.teachexback.model.User
import carte.proj.teachexback.repository.RoleRepository
import carte.proj.teachexback.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class AuthenticationService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val authManager: AuthenticationManager,
    private val tokenService: TokenService
) {

    fun registerUser(username: String, password: String): User {
        val encodedPassword = passwordEncoder.encode(password);
        val userRole = roleRepository.findByAuthority("USER").get();

        val authorities = mutableSetOf(userRole);
        return userRepository.save(
            User(
                username = username,
                password = encodedPassword,
                authorities = authorities
            )
        )

    }

    fun loginUser(username: String, password: String): LoginResponseDTO {

        try {
            val auth = authManager.authenticate(
                UsernamePasswordAuthenticationToken(username, password)

            )
            val token = tokenService.generateJwt(auth)

            return LoginResponseDTO(userRepository.findByUsername(username).get(), token)

        } catch (e: AuthenticationException) {
            return LoginResponseDTO(null, "");
        }
    }


}