package carte.proj.teachexback.controller

import carte.proj.teachexback.model.Course
import carte.proj.teachexback.model.Teacher
import carte.proj.teachexback.service.TeacherService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin("http://localhost:4200")
class TeacherController(
    val service: TeacherService
) {
    @GetMapping("/all")
    fun getAllTeacher() = service.getAllTeachers();

    @ResponseStatus(HttpStatus.OK, reason = "added teacher")
    @PostMapping(consumes = ["application/json"])
    fun addTeacher(@Valid @RequestBody teacher: Teacher) {
        service.addTeacher(teacher);
    }
    @ResponseStatus(HttpStatus.OK, reason = "updated teacher")
    @PutMapping("/{id}")
    fun updateTeacher(@PathVariable id: Long, @Valid @RequestBody teacher: Teacher) {
        service.updateTeacher(id, teacher)
    }
    @ResponseStatus(HttpStatus.OK, reason = "deleted teacher")
    @DeleteMapping("/{id}")
    fun removeTeacher(@PathVariable id: Long) = service.removeTeacher(id);


}