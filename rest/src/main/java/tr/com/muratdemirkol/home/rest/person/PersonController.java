package tr.com.muratdemirkol.home.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.muratdemirkol.home.domain.dto.PersonDto;
import tr.com.muratdemirkol.home.domain.entity.PersonEntity;
import tr.com.muratdemirkol.home.service.service.person.PersonService;


/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public PersonEntity create(@RequestBody PersonDto dto) {
        return personService.create(dto);
    }

}
