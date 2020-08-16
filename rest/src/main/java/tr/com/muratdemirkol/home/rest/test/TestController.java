package tr.com.muratdemirkol.home.rest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.muratdemirkol.home.service.test.TestService;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 **/

@RestController
public class TestController {

    @Autowired
    public TestBean testBean;

    @Autowired
    public TestService testService;

    @RequestMapping("/testpage")
    public String index(){
        testService.testService();
        return "Başarılı.";
    }
}
