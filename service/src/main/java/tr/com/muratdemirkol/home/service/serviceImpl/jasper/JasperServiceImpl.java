package tr.com.muratdemirkol.home.service.serviceImpl.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.domain.dto.PersonelEkipBilgileriDTO;
import tr.com.muratdemirkol.home.domain.dto.PersonelYakinBilgileriDTO;
import tr.com.muratdemirkol.home.domain.enums.ReportEnum;
import tr.com.muratdemirkol.home.service.service.jasper.JasperExportService;
import tr.com.muratdemirkol.home.service.service.jasper.JasperPathAndLogoPropertiesService;
import tr.com.muratdemirkol.home.service.service.jasper.JasperService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private JasperPathAndLogoPropertiesService jasperProperties;

    public byte[] createSingleReport(String enumKodu) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("sicilNo", "9141361");
        parameters.put("AdiSoyadi", "Murat DEMİRKOL");
        parameters.put("unvan", "Software Developer");
        parameters.put("gsm", "+90 544 914 13 61");
        parameters.put("email", "murat.demirkol@vbt.com.tr");
        parameters.put("dogumYeri", "Ankara");
        parameters.put("dogumTarihi", "12.12.1988");
        parameters.put("tckn", "18815792720");
        parameters.put("kanGrubu", "A Rh(+)");
        parameters.put("perosnelResmi", jasperProperties.getJasperLogoPath("personelLogo.jpg"));
        parameters.put("background", jasperProperties.getJasperLogoPath("background.jpg"));
        return jasperExportService.exportSingleReport(enumKodu, parameters);
    }

    public byte[] createMasterAndDetailReport(String enumKodu) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("sicilNo", "9141361");
        parameters.put("AdiSoyadi", "Murat DEMİRKOL");
        parameters.put("unvan", "Software Developer");
        parameters.put("gsm", "+90 544 914 13 61");
        parameters.put("email", "murat.demirkol@vbt.com.tr");
        parameters.put("dogumYeri", "Ankara");
        parameters.put("dogumTarihi", "12.12.1988");
        parameters.put("tckn", "18815792720");
        parameters.put("kanGrubu", "A Rh(+)");
        parameters.put("perosnelResmi", jasperProperties.getJasperLogoPath("personelLogo.jpg"));
        parameters.put("background", jasperProperties.getJasperLogoPath("background.jpg"));

        List<PersonelYakinBilgileriDTO> yakinBilgileriDTOS = new ArrayList<PersonelYakinBilgileriDTO>();
        PersonelYakinBilgileriDTO dto1 = new PersonelYakinBilgileriDTO();
        dto1.setAdiSoyadi("Halil DEMİRKOL");
        dto1.setYakinlikDerecesi("Babası");
        dto1.setGsm("+90 545 507 61 89");

        PersonelYakinBilgileriDTO dto2 = new PersonelYakinBilgileriDTO();
        dto2.setAdiSoyadi("Zeliha DEMİRKOL");
        dto2.setYakinlikDerecesi("Annesi");
        dto2.setGsm("+90 545 934 54 61");

        yakinBilgileriDTOS.add(dto1);
        yakinBilgileriDTOS.add(dto2);

        return jasperExportService.exportMasterAndDetailReport(enumKodu, parameters, yakinBilgileriDTOS);
    }

    public byte[] createMasterDetailAndSubReport(String enumKodu) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("sicilNo", "9141361");
        parameters.put("AdiSoyadi", "Murat DEMİRKOL");
        parameters.put("unvan", "Software Developer");
        parameters.put("gsm", "+90 544 914 13 61");
        parameters.put("email", "murat.demirkol@vbt.com.tr");
        parameters.put("dogumYeri", "Ankara");
        parameters.put("dogumTarihi", "12.12.1988");
        parameters.put("tckn", "18815792720");
        parameters.put("kanGrubu", "A Rh(+)");
        parameters.put("perosnelResmi", jasperProperties.getJasperLogoPath("personelLogo.jpg"));
        parameters.put("background", jasperProperties.getJasperLogoPath("background.jpg"));

        List<PersonelYakinBilgileriDTO> yakinBilgileriDTOS = new ArrayList<PersonelYakinBilgileriDTO>();
        PersonelYakinBilgileriDTO dto1 = new PersonelYakinBilgileriDTO();
        dto1.setAdiSoyadi("Halil DEMİRKOL");
        dto1.setYakinlikDerecesi("Babası");
        dto1.setGsm("+90 545 507 61 89");

        PersonelYakinBilgileriDTO dto2 = new PersonelYakinBilgileriDTO();
        dto2.setAdiSoyadi("Zeliha DEMİRKOL");
        dto2.setYakinlikDerecesi("Annesi");
        dto2.setGsm("+90 545 934 54 61");

        yakinBilgileriDTOS.add(dto1);
        yakinBilgileriDTOS.add(dto2);

        ArrayList<List> subData = new ArrayList<>();
        List<PersonelEkipBilgileriDTO> data = new ArrayList<>();
        PersonelEkipBilgileriDTO pdto1 = new PersonelEkipBilgileriDTO();
        pdto1.setAdiSoyadi("Alper ÇEPNİ");
        pdto1.setUnvan("Team Lead");
        pdto1.setGsm("+90 533 512 79 31");
        PersonelEkipBilgileriDTO pdto2 = new PersonelEkipBilgileriDTO();
        pdto2.setAdiSoyadi("Serhat KÖSE");
        pdto2.setUnvan("Software Developer");
        pdto2.setGsm("+90 537 275 78 30");
        PersonelEkipBilgileriDTO pdto3 = new PersonelEkipBilgileriDTO();
        pdto3.setAdiSoyadi("Volkan ERDOĞAN");
        pdto3.setUnvan("Frontend Developer");
        pdto3.setGsm("+90 505 585 04 15");

        data.add(pdto1);
        data.add(pdto2);
        data.add(pdto3);
        subData.add(data);


        return jasperExportService.exportMasterDetailAndSubReport(enumKodu, parameters, yakinBilgileriDTOS, subData);
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
