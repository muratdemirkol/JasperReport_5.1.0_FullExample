package tr.com.muratdemirkol.home.domain.converter;

import tr.com.muratdemirkol.home.domain.dto.PersonDto;
import tr.com.muratdemirkol.home.domain.entity.PersonEntity;

import java.util.logging.Logger;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public class PersonConverter {

    Logger logger = Logger.getLogger(PersonConverter.class.getName());

    public PersonDto getConverterEntitytoDto(PersonEntity entity){
        PersonDto dto = new PersonDto();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }
    public PersonEntity getConverterDtoToEntity(PersonDto dto){
        PersonEntity entity = new PersonEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        return entity;
    }
}
