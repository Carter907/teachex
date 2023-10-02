package carte.proj.teachexback

import carte.proj.teachexback.model.Role
import carte.proj.teachexback.model.User
import carte.proj.teachexback.repository.RoleRepository
import carte.proj.teachexback.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication(/*exclude = [SecurityAutoConfiguration::class]*/)
@ConfigurationPropertiesScan("carte.proj.teachexback.configuration.properties")
class TeachexBackApplication {
    @Bean
    fun commandLine(
        roleRepository: RoleRepository,
        userRepository: UserRepository,
        encoder: PasswordEncoder
    ) = CommandLineRunner {

        if (roleRepository.findByAuthority("ADMIN").isPresent)
            return@CommandLineRunner;

        val adminRole: Role = roleRepository.save(Role(authority = "ADMIN"));
        roleRepository.save(Role(authority = "USER"))

        val roles = mutableSetOf<Role>();
        roles.add(adminRole);

        val admin = User(
            username = "admin",
            password = encoder.encode("password"),
            authorities = roles

        );

        userRepository.save(admin);
    };

}

fun main(args: Array<String>) {
    runApplication<TeachexBackApplication>(*args)
}
