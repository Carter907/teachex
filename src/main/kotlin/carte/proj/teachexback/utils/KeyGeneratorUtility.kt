package carte.proj.teachexback.utils

import java.security.KeyPair
import java.security.KeyPairGenerator

class KeyGeneratorUtility {

    companion object {

        fun generateAsRsaKey(): KeyPair {
            val pairGen = KeyPairGenerator.getInstance("RSA")
            pairGen.initialize(2048);
            return pairGen.generateKeyPair();
        }


    }


}