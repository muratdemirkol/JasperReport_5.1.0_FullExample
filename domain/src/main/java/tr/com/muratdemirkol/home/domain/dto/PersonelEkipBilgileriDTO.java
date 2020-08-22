package tr.com.muratdemirkol.home.domain.dto;

/**
 * Created By Murat DEMIRKOL 20.08.2020
 **/
public class PersonelEkipBilgileriDTO {

    private String adiSoyadi;
    private String unvan;
    private String gsm;

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
}
