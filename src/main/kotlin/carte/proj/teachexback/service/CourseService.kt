package carte.proj.teachexback.service

import carte.proj.teachexback.model.Course
import carte.proj.teachexback.repository.CourseRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CourseService(
    var repo: CourseRepository
) {
    fun enrollStudent(courseId: Long, studentId: Long) {
        repo.findById(courseId)
    }

    fun dropStudent(courseId: Long, studentId: Long) {

    }

    fun findCourseByName(name: String) = repo.findCourseByName(name);
    fun addCourse(course: Course) {
        if (findCourseByName(course.name).isPresent)
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "course by the same name already exists");

        repo.save(course);

    }

    fun updateCourse(id: Long, course: Course) {
        if (repo.findById(id).isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no course available to update.")
        repo.save(course);

    }

    fun getAllCourses(): MutableList<Course> = repo.findAll();

    fun removeCourse(id: Long): Course {
        val potentialCourse = repo.findById(id);
        if (potentialCourse.isEmpty)
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "no course available to delete")

        repo.delete(potentialCourse.get());
        return potentialCourse.get();
    }

//
//    fun getStudentSorted() {
//
//    }

}