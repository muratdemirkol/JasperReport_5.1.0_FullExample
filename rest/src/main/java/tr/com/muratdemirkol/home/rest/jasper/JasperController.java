package tr.com.muratdemirkol.home.rest.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.muratdemirkol.home.service.service.jasper.JasperService;


/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
@RestController
@RequestMapping(value = "jasper")
public class JasperController {

    @Autowired
    private JasperService jasperService;

    @PostMapping("/singlereport")
    public byte[] createSingleReport(@RequestParam("enumKodu") String enumKodu) {
        return jasperService.createSingleReport(enumKodu);
    }

    @PostMapping("/listreport")
    public byte[] createListReport(@RequestParam("enumKodu") String enumKodu) {
        return jasperService.createListReport(enumKodu);
    }


}
