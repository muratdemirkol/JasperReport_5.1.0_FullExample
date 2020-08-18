package tr.com.muratdemirkol.home.rest.jasper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
@RestController
@RequestMapping(value = "jasper")
public class JasperController {

//    @Autowired
//    private PersonService personService;

    @PostMapping("/singlereport")
    public Boolean singlereport() {
        return true;
    }

}
