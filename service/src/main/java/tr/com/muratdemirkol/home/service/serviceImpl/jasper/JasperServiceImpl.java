package tr.com.muratdemirkol.home.service.serviceImpl.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.domain.enums.ReportEnum;
import tr.com.muratdemirkol.home.service.service.jasper.JasperExportService;
import tr.com.muratdemirkol.home.service.service.jasper.JasperService;

import java.util.logging.Logger;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 * Datanın hazılandığı ve exporta hazırlandığı kısım
 **/
@Service
public class JasperServiceImpl implements JasperService {

    Logger LOGGER = Logger.getLogger(JasperServiceImpl.class.getName());

    @Autowired
    private JasperExportService jasperExportService;

    public byte[] createSingleReport(String enumKodu) {
        ReportEnum reportEnum = ReportEnum.getByEnum(enumKodu);
        System.out.println(reportEnum.getReportSourceName());
        System.out.println(reportEnum.getKod());
        jasperExportService.createSingleReport("","",null, null);
        return new byte[0];
    }

    public byte[] createListReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createMasterAndDetailReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createMasterDetailAndSubReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createMultipleCombinationReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createCrosstabReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createGraphicReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createMapReport(String enumKodu) {
        return new byte[0];
    }

    public byte[] createWidgetReport(String enumKodu) {
        return new byte[0];
    }

//    @Autowired
//    private PersonDao personDao;

}
