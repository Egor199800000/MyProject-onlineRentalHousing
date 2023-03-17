package com.egor.spring.mvc_hibernate_aop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "houses")
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private int price;

    @Column(name = "is_rented")
    boolean isRented=false;//арендован или нет

    @Column(name = "is_deleted")
    boolean isDeleted=false;////когда аккаунт владельца удален, вместе с этим блокируются объявления и арендованные дома становятся свободны

    @Column(name = "description_")
    private String description;


    //private byte[] imgPath;//путь к изображениям

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="owner_")
    User owner;//владелец дома

    public User getOwner() {
        return owner;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tenant")
    User tenant;//арендатор дома
}
