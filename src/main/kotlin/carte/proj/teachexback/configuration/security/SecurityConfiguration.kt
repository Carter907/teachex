package carte.proj.teachexback.configuration.security

import carte.proj.teachexback.utils.RSAKeyProperties
import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration(private val keys: RSAKeyProperties) {


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder();
    }

    @Bean
    fun authManager(udService: UserDetailsService): AuthenticationManager {
        val daoProvider = DaoAuthenticationProvider()
        daoProvider.setUserDetailsService(udService)
        daoProvider.setPasswordEncoder(passwordEncoder())
        return ProviderManager(daoProvider);
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/auth/**").permitAll();
                it.requestMatchers("/admin/**").hasRole("ADMIN");
                it.requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                it.anyRequest().authenticated()
            }
            .oauth2ResourceServer { oAuth2ResourceServerConfigurer ->
                oAuth2ResourceServerConfigurer.jwt { it.jwtAuthenticationConverter(jwtAuthenticationConverter()) }
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .build()
    }

    @Bean
    fun jwtDecoder(): JwtDecoder {
        return NimbusJwtDecoder.withPublicKey(keys.pubKey).build();
    }

    @Bean
    fun jwtEncoder(): JwtEncoder {
        val jwk = RSAKey.Builder(keys.pubKey).privateKey(keys.privateKey).build();
        val source: JWKSource<SecurityContext> = ImmutableJWKSet(JWKSet(jwk))
        return NimbusJwtEncoder(source)
    }

    @Bean
    fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val jwtGrantedAuthsConverter = JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthsConverter.setAuthoritiesClaimName("roles");
        jwtGrantedAuthsConverter.setAuthorityPrefix("ROLE_");
        val jwtAuthConverter = JwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthsConverter);

        return jwtAuthConverter;
    }
}