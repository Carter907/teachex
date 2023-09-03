package carte.proj.teachexback.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:properties/teachex-ui.properties")
class UIProperties {
    @Value("\${teachex.title}")
    lateinit var title: String;

    @Value("\${teachex.description}")
    lateinit var description: String;

}