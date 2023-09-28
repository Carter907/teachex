package carte.proj.teachexback.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
class UserController {
    @GetMapping("/")
    fun userAccess(): String {
        return "user access"
    }
}