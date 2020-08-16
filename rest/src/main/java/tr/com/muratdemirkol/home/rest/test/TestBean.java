package tr.com.muratdemirkol.home.rest.test;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 **/
public class TestBean {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void hello() {
        System.out.println("Hello " + test);
    }
}
