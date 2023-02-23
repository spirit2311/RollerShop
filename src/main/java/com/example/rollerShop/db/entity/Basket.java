package com.example.rollerShop.db.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @org.hibernate.annotations.Type(type = "uuid-char")
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "items")
    private String items;
}
