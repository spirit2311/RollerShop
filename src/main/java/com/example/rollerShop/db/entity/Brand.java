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
@Table(name = "brand")
public class Brand extends BaseEntity{

    @Column(name = "brand")
    private String brand;
}
