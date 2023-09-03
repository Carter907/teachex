package carte.proj.teachexback.controller

import carte.proj.teachexback.configuration.UIProperties
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class UIController(
    val properties: UIProperties
) {


    @RequestMapping("/title-properties")
    fun titleProperties(): Map<String, String> {
        val map = HashMap<String, String>();

        map["title"] = properties.title;
        map["description"] = properties.description;
        return map;
    }
}