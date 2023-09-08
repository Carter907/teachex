package carte.proj.teachexback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(/*exclude = [SecurityAutoConfiguration::class]*/)
@ConfigurationPropertiesScan("carte.proj.teachexback.configuration.properties")
class TeachexBackApplication

fun main(args: Array<String>) {
    runApplication<TeachexBackApplication>(*args)
}
