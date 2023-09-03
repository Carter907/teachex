package carte.proj.teachexback.configuration

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DTOConfiguration {

    @Bean
    fun getModelMapper() = ModelMapper();
}