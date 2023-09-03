package carte.proj.teachexback.configuration.error

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource

@PropertySource("classpath:properties/error-handling.properties")
class ErrorMessages {
    @Value("\${not-found-student}")
    lateinit var notFoundStudent: String;

    @Value("\${not-found-course")
    lateinit var notFoundCourse: String;
}