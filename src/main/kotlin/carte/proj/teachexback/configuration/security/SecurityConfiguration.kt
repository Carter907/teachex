package carte.proj.teachexback.configuration.security

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationEventPublisher
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


//@EnableWebSecurity
//@Configuration
//class SecurityConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean(AuthenticationEventPublisher::class)
//    fun defaultAuthenticationEventPublisher(delegate: ApplicationEventPublisher?): DefaultAuthenticationEventPublisher {
//        return DefaultAuthenticationEventPublisher(delegate)
//    }
//}