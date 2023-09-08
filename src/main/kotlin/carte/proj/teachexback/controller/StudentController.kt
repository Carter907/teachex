package carte.proj.teachexback.controller

import carte.proj.teachexback.model.Course
import carte.proj.teachexback.model.Student
import carte.proj.teachexback.service.StudentService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("http://localhost:4200")
class StudentController(
    val service: StudentService
) {
    @GetMapping("/all")
    fun getAllStudents(auth: Authentication) = service.getAllStudents();

    @ResponseStatus(HttpStatus.OK, reason = "added course")
    @PostMapping(consumes = ["application/json"])
    fun addStudent(@Valid @RequestBody student: Student) {
        service.addStudent(student);
    }
    @ResponseStatus(HttpStatus.OK, reason = "updated course")
    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @Valid @RequestBody student: Student) {
        service.updateStudent(id, student)
    }
    @ResponseStatus(HttpStatus.OK, reason = "deleted course")
    @DeleteMapping("/{id}")
    fun removeStudent(@PathVariable id: Long) = service.removeStudent(id);



}