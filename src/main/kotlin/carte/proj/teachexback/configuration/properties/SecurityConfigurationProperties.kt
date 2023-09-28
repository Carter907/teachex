package carte.proj.teachexback.configuration.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "security")
class SecurityConfigurationProperties {

    lateinit var secretKey: String;
}