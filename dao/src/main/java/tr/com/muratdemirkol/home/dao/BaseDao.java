package tr.com.muratdemirkol.home.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tr.com.muratdemirkol.home.domain.entity.BaseEntity;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/

@Repository
@Transactional
public class BaseDao<T extends BaseEntity> {
    @Autowired
    private SessionFactory sessionFactory;

    public T save(T entity) {
        entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        entity.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        entity.setDeleted(false);
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }
}
