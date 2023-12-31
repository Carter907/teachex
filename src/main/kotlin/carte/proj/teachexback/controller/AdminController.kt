package carte.proj.teachexback.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
class AdminController {

    @GetMapping("/")
    fun adminAccess(): String {
        return "admin access"
    }
}