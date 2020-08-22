package tr.com.muratdemirkol.home.service.serviceImpl.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.domain.enums.ReportEnum;
import tr.com.muratdemirkol.home.service.service.jasper.JasperExportService;
import tr.com.muratdemirkol.home.service.service.jasper.JasperPathAndLogoPropertiesService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public byte[] exportSingleReport(String enumKodu, Map<String, Object> parameters) {
        ReportEnum reportEnum = ReportEnum.getByEnum(enumKodu);

        String jasperPath = jasperProperties.getJasperSourcePath() + reportEnum.getReportSourceName();

        String exportReportPath = jasperProperties.getJasperExportPath() + reportEnum.getReportName() + "." + reportEnum.getReportType();

        File file = new File(jasperProperties.getJasperExportPath());
        if (!file.exists()) {
            file.mkdirs();
        }

        parameters.put("genelLogo", jasperProperties.getJasperLogoPath("vbtAnkaraLogo.jpg"));

//        for (Map.Entry<String, Object> map : parameters.entrySet()) {
//            System.out.println(
//                    "<parameter name=" + "\"" + map.getKey() + "\" " + "class=\"" + "java.lang.String\"/>");
//        }

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(new FileInputStream(jasperPath), parameters);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bFile = null;
        byte[] bytes = null;
        try {
            if ("pdf".equals(reportEnum.getReportType())) {
                bytes = JasperExportManager.getInstance(DefaultJasperReportsContext.getInstance())
                        .exportToPdf(jasperPrint);
            }
            if ("xlsx".equals(reportEnum.getReportType())) {
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, exportReportPath);

                exporter.exportReport();

                bytes = Files.readAllBytes(Paths.get(exportReportPath));
            }

            Files.write(Paths.get(exportReportPath), bytes);

            bFile = Files.readAllBytes(Paths.get(exportReportPath));

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bFile;
    }

    public byte[] exportMasterAndDetailReport(String enumKodu, Map<String, Object> parameters, List data) {
        ReportEnum reportEnum = ReportEnum.getByEnum(enumKodu);

        String jasperPath = jasperProperties.getJasperSourcePath() + reportEnum.getReportSourceName();

        String exportReportPath = jasperProperties.getJasperExportPath() + reportEnum.getReportName() + "." + reportEnum.getReportType();

        File file = new File(jasperProperties.getJasperExportPath());
        if (!file.exists()) {
            file.mkdirs();
        }

        parameters.put("genelLogo", jasperProperties.getJasperLogoPath("vbtAnkaraLogo.jpg"));

        JRDataSource dataSource = new JRBeanCollectionDataSource(data);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(new FileInputStream(jasperPath), parameters, dataSource);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bFile = null;
        byte[] bytes = null;
        try {
            if ("pdf".equals(reportEnum.getReportType())) {
                bytes = JasperExportManager.getInstance(DefaultJasperReportsContext.getInstance())
                        .exportToPdf(jasperPrint);
            }
            if ("xlsx".equals(reportEnum.getReportType())) {
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, exportReportPath);

                exporter.exportReport();

                bytes = Files.readAllBytes(Paths.get(exportReportPath));
            }

            Files.write(Paths.get(exportReportPath), bytes);

            bFile = Files.readAllBytes(Paths.get(exportReportPath));

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bFile;
    }

    public byte[] exportMasterDetailAndSubReport(String enumKodu, Map<String, Object> parameters, List data, ArrayList<List> subData) {
        ReportEnum reportEnum = ReportEnum.getByEnum(enumKodu);

        String jasperPath = jasperProperties.getJasperSourcePath() + reportEnum.getReportSourceName();

        String exportReportPath = jasperProperties.getJasperExportPath() + reportEnum.getReportName() + "." + reportEnum.getReportType();

        File file = new File(jasperProperties.getJasperExportPath());
        if (!file.exists()) {
            file.mkdirs();
        }

        parameters.put("genelLogo", jasperProperties.getJasperLogoPath("vbtAnkaraLogo.jpg"));

        String subJasperPath = jasperProperties.getJasperSourcePath();
        parameters.put("subJasperPath", subJasperPath);

        for (int i = 0; i < subData.size(); i++) {
            parameters.put("subData" + i, subData.get(i));
        }

        JRDataSource dataSource = new JRBeanCollectionDataSource(data);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(new FileInputStream(jasperPath), parameters, dataSource);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bFile = null;
        byte[] bytes = null;
        try {
            if ("pdf".equals(reportEnum.getReportType())) {
                bytes = JasperExportManager.getInstance(DefaultJasperReportsContext.getInstance())
                        .exportToPdf(jasperPrint);
            }
            if ("xlsx".equals(reportEnum.getReportType())) {
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, exportReportPath);

                exporter.exportReport();

                bytes = Files.readAllBytes(Paths.get(exportReportPath));
            }

            Files.write(Paths.get(exportReportPath), bytes);

            bFile = Files.readAllBytes(Paths.get(exportReportPath));

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bFile;
    }

}
