import com.sandyspring.config.AppRootConfig
import com.sandyspring.controller.SampleController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.*

import javax.ws.rs.core.Response
import java.util.regex.Pattern;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@ContextConfiguration(classes = AppRootConfig)
class SampleTestSpec extends Specification{

    @Autowired
    SampleController controller

   /* private MockMvc mockMvc;
*/
   /* def setup(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }*/

    def "wire"() {
        expect:
        controller


    }

    def "test sample spring"(){
        when:
        Response response = controller.sayHi("SandySpring")
        then:
        response.getStatus() == 200
        response
    }

    def "sample test"(){
        expect:
        (0..100).step(2).each {
            println(it)
        }
      /*  Pattern pt = Pattern.compile("[\\s]")
        String str = "Hello\nWorld\t!";
        String words = pt.split(str)
        print(words)*/

        //int x = -1
        //x = x << 16
        //println(x)
    }

    /*def "mockMvc test"(){
        expect:
        mockMvc.perform(get("/sampleRest?name=Sandy"))
                .andExpect(status().isOk())
    }*/



}
