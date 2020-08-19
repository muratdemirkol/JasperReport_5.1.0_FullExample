package tr.com.muratdemirkol.home.service.serviceImpl.jasper;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.service.service.jasper.JasperPathAndLogoPropertiesService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

/**
 * Created By Murat DEMIRKOL 19.08.2020
 **/
@Service
public class JasperPathAndLogoPropertiesServiceImpl implements JasperPathAndLogoPropertiesService {

    private static Logger LOGGER = LoggerFactory.logger(JasperPathAndLogoPropertiesServiceImpl.class);
    public String getJasperSourcePath() {
        String directory = new File("/MyJasperReportProjects/reports/sourceTemplates/").getAbsolutePath() + "/";
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        return directory;
    }

    public String getJasperExportPath() {
        String directory = new File("/MyJasperReportProjects/reports/export/").getAbsolutePath() + "/";
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        return directory;
    }

    public Image getJasperLogoPath() {

        String directory = new File("/MyJasperReportProjects/reports/logo/").getAbsolutePath() + "/";
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }

        InputStream is;
        Image image = null;
        try {
            is = new BufferedInputStream(new FileInputStream(directory + "logo.png"));
            image = ImageIO.read(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.error("Logo Oluşturulurken Hata Meydana Geldi...");
            e.printStackTrace();
        }

        return image;
    }
}
