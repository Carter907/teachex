package carte.proj.teachexback.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    private var username: String,
    private var password: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles",
        joinColumns = [ JoinColumn(name = "user_id")],
        inverseJoinColumns = [ JoinColumn(name = "role_id")]
    )
    private var authorities: MutableSet<Role>
) : UserDetails{
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
       return this.authorities;
    }

    override fun getPassword(): String {
        return this.password;
    }

    override fun getUsername(): String {
        return this.username;
    }

    override fun isAccountNonExpired(): Boolean {

        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }
}