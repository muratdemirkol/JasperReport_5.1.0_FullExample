package tr.com.muratdemirkol.home.domain.enums;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public enum ReportEnum {
    PERSONEL_RAPORU("1", "personelRaporu.jasper", "reportName","pdf");

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
