package tr.com.muratdemirkol.home.domain.enums;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public enum ReportEnum {
    PERSONEL_RAPORU_PDF("1", "personelRaporu.jasper", "PersonelRaporu","pdf"),
    PERSONEL_RAPORU_XLSX("2", "personelRaporu.jasper", "PersonelRaporu","xlsx"),
    PERSONEL_RAPORU_LISTE_PDF("3", "personelListeRaporu.jasper", "PersonelListeRaporu","pdf"),
    PERSONEL_RAPORU_LISTE_XLSX("4", "personelListeRaporu.jasper", "PersonelListeRaporu","xlsx"),
    PERSONEL_RAPORU_LISTE_SUBREPORT_PDF("5", "personelAltRaporu.jasper", "personelAltRaporu","pdf")
    ;

    private final String kod;
    private final String reportSourceName;
    private final String reportName;
    private final String reportType;

    ReportEnum(String kod, String reportSourceName, String reportName, String reportType) {
        this.kod = kod;
        this.reportSourceName = reportSourceName;
        this.reportName = reportName;
        this.reportType = reportType;
    }

    public static ReportEnum getByEnum(String kod){
        for (ReportEnum reportEnum : ReportEnum.values()) {
            if(reportEnum.kod.equals(kod)){
                return reportEnum;
            }
        }
        return null;
    }

    public String getKod() {
        return kod;
    }

    public String getReportSourceName() {
        return reportSourceName;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReportName() {
        return reportName;
    }
}
