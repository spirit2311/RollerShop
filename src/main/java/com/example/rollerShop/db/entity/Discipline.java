package com.example.rollerShop.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "id")
    private Integer id;

//    @Type(type = "uuid-char")
    @Column(name = "UUID")
    private UUID uuid = UUID.randomUUID();

    @Column(name = "discipline")
    private String discipline;
}
