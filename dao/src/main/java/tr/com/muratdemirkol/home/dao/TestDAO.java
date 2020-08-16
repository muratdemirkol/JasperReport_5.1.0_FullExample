package tr.com.muratdemirkol.home.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tr.com.muratdemirkol.home.domain.test.TestDomain;

import javax.transaction.Transactional;

/**
 * @Author Murat DEMİRKOL
 **/

@Repository
@Transactional
public class TestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void testDao() {
        System.out.println("Dao Çalıştı.");
        TestDomain testDomain = new TestDomain();
        testDomain.testdomain();
    }

}
