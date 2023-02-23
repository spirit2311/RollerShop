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
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @org.hibernate.annotations.Type(type = "uuid-char")
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "time")
    private String createdDate;

    @Column(name = "items")
    private String items;

    @Column(name = "users")
    private String users;

}
