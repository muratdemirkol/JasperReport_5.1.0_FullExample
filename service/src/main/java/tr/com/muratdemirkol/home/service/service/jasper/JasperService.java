package tr.com.muratdemirkol.home.service.service.jasper;

/**
 * Created By Murat DEMIRKOL 19.08.2020
 **/
public interface JasperService {

    byte[] createSingleReport(String enumKodu);

    byte[] createMasterAndDetailReport(String enumKodu);

    byte[] createMasterDetailAndSubReport(String enumKodu);

    byte[] createMultipleCombinationReport(String enumKodu);

    byte[] createCrosstabReport(String enumKodu);

    byte[] createGraphicReport(String enumKodu);

    byte[] createMapReport(String enumKodu);

    byte[] createWidgetReport(String enumKodu);
}
