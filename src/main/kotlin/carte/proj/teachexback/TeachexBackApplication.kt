package carte.proj.teachexback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan(*["carte.proj.teachexback.configuration.properties"])
class TeachexBackApplication

fun main(args: Array<String>) {
    runApplication<TeachexBackApplication>(*args)


}
