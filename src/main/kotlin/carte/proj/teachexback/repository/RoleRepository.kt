package carte.proj.teachexback.repository

import carte.proj.teachexback.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByAuthority(authority: String): Optional<Role>;
}
