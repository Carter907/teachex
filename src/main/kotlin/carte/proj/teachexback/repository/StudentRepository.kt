package carte.proj.teachexback.repository

import carte.proj.teachexback.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface StudentRepository : JpaRepository<Student, Long> {
}