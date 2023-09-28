package carte.proj.teachexback.service

import carte.proj.teachexback.model.Role
import carte.proj.teachexback.model.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(var encoder: PasswordEncoder): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        println("in user details")
        if (!username.equals("Carter")) throw RuntimeException("username incorrect");
        val roles = mutableSetOf(Role(1, authority = "USER"))

        return User(1, "Carter", encoder.encode("password"), roles);
    }

}