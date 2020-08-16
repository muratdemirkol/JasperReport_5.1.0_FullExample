package tr.com.muratdemirkol.home.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.dao.TestDAO;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 **/
@Service
public class TestService {

    @Autowired
    public TestDAO dao;

    public void testService(){
        System.out.println("Servis Çalıştı.");
        dao.testDao();
    }

}
