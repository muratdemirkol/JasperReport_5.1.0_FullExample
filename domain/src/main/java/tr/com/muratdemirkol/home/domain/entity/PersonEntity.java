package tr.com.muratdemirkol.home.domain.entity;

import javax.persistence.*;

/**
 * Created By Murat DEMIRKOL 18.08.2020
 **/

@Entity(name = "PersonEntity")
@Table(name = "person")
public class PersonEntity extends BaseEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

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
