package carte.proj.teachexback.controller

import carte.proj.teachexback.service.StudentService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class StudentController(
    service: StudentService
) {


}