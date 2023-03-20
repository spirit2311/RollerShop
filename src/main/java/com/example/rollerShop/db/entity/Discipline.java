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
public class Discipline extends BaseEntity{

    @Column(name = "discipline")
    private String discipline;
}
