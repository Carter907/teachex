package carte.proj.teachexback.service

import carte.proj.teachexback.model.Role
import carte.proj.teachexback.model.User
import carte.proj.teachexback.repository.RoleRepository
import carte.proj.teachexback.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(private val encoder: PasswordEncoder, private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        println("in user details")

        return userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("user not found") };
    }

}