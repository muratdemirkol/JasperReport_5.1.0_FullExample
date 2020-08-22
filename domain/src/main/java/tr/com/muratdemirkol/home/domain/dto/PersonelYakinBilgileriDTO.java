package tr.com.muratdemirkol.home.domain.dto;

/**
 * Created By Murat DEMIRKOL 20.08.2020
 **/
public class PersonelYakinBilgileriDTO {

    private String adiSoyadi;
    private String yakinlikDerecesi;
    private String gsm;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getYakinlikDerecesi() {
        return yakinlikDerecesi;
    }

    public void setYakinlikDerecesi(String yakinlikDerecesi) {
        this.yakinlikDerecesi = yakinlikDerecesi;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
}
