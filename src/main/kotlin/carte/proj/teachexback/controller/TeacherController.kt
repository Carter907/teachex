package carte.proj.teachexback.controller

import carte.proj.teachexback.service.TeacherService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class TeacherController(
    service: TeacherService
) {
}