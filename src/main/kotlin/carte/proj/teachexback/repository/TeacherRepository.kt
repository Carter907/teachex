package carte.proj.teachexback.repository

import carte.proj.teachexback.model.Student
import carte.proj.teachexback.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface TeacherRepository : JpaRepository<Teacher, Long> {
    fun findTeacherByStudentsIn(student: Set<Student>): Teacher;
}