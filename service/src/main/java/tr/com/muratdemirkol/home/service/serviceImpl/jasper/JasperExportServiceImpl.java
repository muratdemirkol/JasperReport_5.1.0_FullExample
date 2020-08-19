package tr.com.muratdemirkol.home.service.serviceImpl.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.service.service.jasper.JasperExportService;
import tr.com.muratdemirkol.home.service.service.jasper.JasperPathAndLogoPropertiesService;

import java.util.List;
import java.util.Map;

/**
 * Created By Murat DEMIRKOL 19.08.2020
 * jasperin ve dataların birleştirilerek raporun oluşturulduğu kısım
 **/
@Service
public class JasperExportServiceImpl implements JasperExportService {

    @Autowired
    private JasperPathAndLogoPropertiesService jasperProperties;

    public byte[] createSingleReport(String reportName, String reportType, Map<String, Object> paramaters, List data) {
        System.out.println("JasperExportServiceImpl Çalıştı.");
        //System.out.println(jasperProperties.getLogoPath());
        return new byte[0];
    }
}
