package tr.com.muratdemirkol.home.service.service.person;

import tr.com.muratdemirkol.home.domain.dto.PersonDto;
import tr.com.muratdemirkol.home.domain.entity.PersonEntity;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public interface PersonService {

    PersonEntity create(PersonDto dto);
}
