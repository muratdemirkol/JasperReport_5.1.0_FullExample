package tr.com.muratdemirkol.home.service.service.jasper;

import java.util.List;
import java.util.Map;

/**
 * Created By Murat DEMIRKOL 19.08.2020
 **/
public interface JasperExportService {

    byte[] createSingleReport(String reportName, String reportType, Map<String, Object> paramaters, List data);

}
