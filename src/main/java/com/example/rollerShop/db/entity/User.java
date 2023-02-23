package com.example.rollerShop.db.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @org.hibernate.annotations.Type(type = "uuid-char")
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "mail")
    private String mail;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "google_key")
    private String googleKey;

    @Column(name = "phone")
    private String phone;

    @Column(name = "adress")
    private String adress;


}
