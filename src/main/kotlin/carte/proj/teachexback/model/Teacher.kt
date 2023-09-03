package carte.proj.teachexback.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email

@Entity
@Table(name = "TEACHERS")
data class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var firstName: String,
    var lastName: String,
    @Email
    var email: String,



) {
}