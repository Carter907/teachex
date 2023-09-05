package carte.proj.teachexback.repository

import carte.proj.teachexback.model.Course
import carte.proj.teachexback.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CourseRepository : JpaRepository<Course, Long> {

    fun findCourseByName(name: String): Optional<Course>;

    fun findCourseBySubject(subject: Subject): List<Course>;



}