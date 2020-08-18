package tr.com.muratdemirkol.home.domain.dto;

import javax.persistence.Column;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/
public class PersonDto {

    private Integer id;
    private String name;
    private String surname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
