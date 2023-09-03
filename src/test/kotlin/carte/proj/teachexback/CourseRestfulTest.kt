package carte.proj.teachexback

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseRestfulTest {

    @Autowired
    lateinit var templ: TestRestTemplate;

    @Test
    fun testGetAllCoursesEndpoint() {
        val response = templ.getForEntity<String>("/api/courses/all");

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

}