package carte.proj.teachexback.controller

import carte.proj.teachexback.model.Course
import carte.proj.teachexback.service.CourseService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("http://localhost:4200")
class CourseController(
    val service: CourseService
) {
    @GetMapping("/all")
    fun getAllCourses() = service.getAllCourses();

    @ResponseStatus(HttpStatus.OK, reason = "added course")
    @PostMapping(consumes = ["application/json"])
    fun addCourse(@Valid @RequestBody course: Course) {
        service.addCourse(course);
    }
    @ResponseStatus(HttpStatus.OK, reason = "updated course")
    @PutMapping("/{id}")
    fun updateCourse(@PathVariable id: Long, @Valid @RequestBody course: Course) {
        service.updateCourse(id, course)
    }
    @ResponseStatus(HttpStatus.OK, reason = "deleted course")
    @DeleteMapping("/{id}")
    fun removeCourse(@PathVariable id: Long) = service.removeCourse(id);



}