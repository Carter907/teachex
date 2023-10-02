package carte.proj.teachexback.utils

import org.springframework.stereotype.Component
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Component
class RSAKeyProperties {
    lateinit var pubKey: RSAPublicKey;
    lateinit var privateKey: RSAPrivateKey;

    init {
        val pair = KeyGeneratorUtility.generateAsRsaKey();
        pubKey = pair.public as RSAPublicKey;
        privateKey = pair.private as RSAPrivateKey;
    }
}