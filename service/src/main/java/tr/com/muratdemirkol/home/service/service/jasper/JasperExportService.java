package tr.com.muratdemirkol.home.service.service.jasper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created By Murat DEMIRKOL 19.08.2020
 **/
public interface JasperExportService {

    byte[] exportSingleReport(String enumKodu, Map<String, Object> paramaters);

    byte[] exportMasterAndDetailReport(String enumKodu, Map<String, Object> paramaters, List data);

    byte[] exportMasterDetailAndSubReport(String enumKodu, Map<String, Object> paramaters, List data, ArrayList<List> subData);

}
