package com.example.rollerShop.db.entity;


import lombok.*;
import org.hibernate.annotations.Type;

import jakarta.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "rollerskate")
public class Skate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @Type(type = "uuid-char")
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID();

    //TODO List<Disciplines>
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;


}
