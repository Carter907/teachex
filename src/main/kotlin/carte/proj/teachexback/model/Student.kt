package carte.proj.teachexback.model

import carte.proj.teachexback.service.StudentService
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

@Entity
@Table(name = "STUDENTS")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "attended_courses",
        joinColumns = [
            JoinColumn(name = "student_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "course_id")
        ]
    )
    var courses: Set<Course> = HashSet(),

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "students_teachers",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [
            JoinColumn(name = "teacher_id")
        ]
    )
    var teachers: Set<Teacher> = HashSet(),

    var firstName: String,
    var lastName: String,
    var username: String,

    var password: String,

    )