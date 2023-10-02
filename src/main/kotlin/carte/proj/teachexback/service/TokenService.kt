package carte.proj.teachexback.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtDecoder
import java.time.Instant;
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TokenService(
    private val jwtEncoder: JwtEncoder,
    private val jwtDecoder: JwtDecoder
) {
    fun generateJwt(auth: Authentication): String {

        val nowInstant = Instant.now();

        val scope = auth.authorities.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "))

        val claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(nowInstant)
            .subject(auth.name)
            .claim("roles", scope)
            .build()

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }

}
