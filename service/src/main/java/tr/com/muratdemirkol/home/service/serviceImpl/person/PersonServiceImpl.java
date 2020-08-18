package tr.com.muratdemirkol.home.service.serviceImpl.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.muratdemirkol.home.dao.PersonDao;
import tr.com.muratdemirkol.home.domain.converter.PersonConverter;
import tr.com.muratdemirkol.home.domain.dto.PersonDto;
import tr.com.muratdemirkol.home.domain.entity.PersonEntity;
import tr.com.muratdemirkol.home.service.service.person.PersonService;

/**
 * Created By Murat DEMIRKOL 16.08.2020
 **/
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    public PersonEntity create(PersonDto dto){
        PersonConverter converter = new PersonConverter();
        PersonEntity personEntity = converter.getConverterDtoToEntity(dto);
        PersonEntity entity = personDao.save(personEntity);
        return entity;
    }

}
