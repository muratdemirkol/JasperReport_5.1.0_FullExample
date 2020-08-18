package tr.com.muratdemirkol.home.domain.enums;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public enum ReportEnum {
    PERSONEL_RAPORU("1", "personelRaporu.jasper");

    private final String kod;
    private final String adi;

    ReportEnum(String kod, String adi) {
        this.kod = kod;
        this.adi = adi;
    }


}
