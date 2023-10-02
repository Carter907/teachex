package carte.proj.teachexback.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    private var authority: String,
) : GrantedAuthority {


    override fun getAuthority(): String {
        return this.authority;
    }
}