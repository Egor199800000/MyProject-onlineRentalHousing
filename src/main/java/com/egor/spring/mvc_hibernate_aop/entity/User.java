package com.egor.spring.mvc_hibernate_aop.entity;

//ФИО,
//город, страна, ник, пароль, дата рождения, email
//рейтинг, который выставляется каждой стороной после завершения
//аренды. Рейтинг варьируется от 1–5 звезд

import com.egor.spring.mvc_hibernate_aop.valiation.CheckEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_")
    //@Size(min=2,message = "name must be min 2 symbols")
    private String name;


    //@NotEmpty(message = "surname is required field")
    //@NotBlank(message = "surname is required field")
    @Column(name = "surname")
    private String surname;

    @Column(name = "country ")
    private String country;

    @Column(name = "city")
    private String city;


    //@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "please use pattern XXXX-XX-XX")
    @Column(name = "date_of_birth")
    private String dateOfBirth;


    //@CheckEmail(value = "@gmail.com",message = "email must ends with @gmail.com")
    @Column(name = "email")
    private String email;


    //@Size(min=2,message = "name must be min 2 symbols")
    @Column(name = "password_")
    private String password;

    @Column(name = "rating")
    private int rating;//рейтинг по звездам, максимум 5

    @Column(name = "is_enable")
    private boolean isEnable=true;//подтвержден ли аккаунт

    @Column(name = "is_deleted")
    boolean isDeleted=false;//когда аккаунт удален

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "is_authorized")
    private boolean isAuthorized;


    @OneToMany(cascade =
            {CascadeType.ALL}, mappedBy ="owner",fetch = FetchType.EAGER)
    private List<House> houses;//дома принадлежащие пользователю
    //---------


    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy ="tenant")
    private House rentedHouse;//id арендованного дома

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                ", isEnable=" + isEnable +
                ", isDeleted=" + isDeleted +
                ", isAuthorized=" + isAuthorized +
                ", houses=" + houses +
                ", rentedHouse=" + rentedHouse +
                '}';
    }
}
