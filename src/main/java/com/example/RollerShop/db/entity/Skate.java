package com.example.RollerShop.db.entity;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "rollerskate")
public class Skate {

//TODO Add TDO Skate and mapper

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

//    private ENUM type;
}
