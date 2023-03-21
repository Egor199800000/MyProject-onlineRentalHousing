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
import javax.validation.constraints.*;
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
    @Size(min=2,message = "name must be min 2 symbols")
    private String name;


    @Size(min=2,message = "surname must be min 2 symbols")
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "country is required field")
    @Column(name = "country ")
    private String country;
    @NotBlank(message = "city is required field")
    @Column(name = "city")
    private String city;


    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}",message = "please use pattern YYYY-MM-NN")
    @Column(name = "date_of_birth")
    private String dateOfBirth;


    @CheckEmail
    @Column(name = "email")
    private String email;



    @Column(name = "password_")
    @NotBlank(message = "password is required field")
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


    @OneToMany(cascade = CascadeType.ALL, mappedBy ="tenant",fetch = FetchType.EAGER)
    private List<House> rentedHouses;//id арендованного дома









//------------------------------------------------------------------------------------------------------
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
                ", rentedHouse=" + rentedHouses +
                '}';
    }
}
