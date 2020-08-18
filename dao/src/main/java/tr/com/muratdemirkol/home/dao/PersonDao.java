package tr.com.muratdemirkol.home.dao;

import org.springframework.stereotype.Repository;
import tr.com.muratdemirkol.home.domain.entity.PersonEntity;

import javax.transaction.Transactional;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/

@Repository
@Transactional
public class PersonDao extends BaseDao<PersonEntity> {

}
