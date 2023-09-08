package carte.proj.teachexback.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "COURSES")
data class Course(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @ManyToMany(cascade = [CascadeType.ALL], mappedBy = "courses")
        var students: Set<Student> = HashSet(),

        @Column(unique = true)
        var name: String,

        var startDate: LocalDate,

        var endDate: LocalDate,

        @Enumerated(EnumType.STRING)
        var subject: Subject,
)