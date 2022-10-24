package com.example.rollerShop.db.dtoEnity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Data
public class SkateDto {

    @Positive
    @Column(name = "Id")
    private Integer id;

    @NonNull
    @Size(min = 1, max = 30, message
            = "About Me must be between 1 and 30 characters")
    @Column(name = "brand")
    private String brand;

    @NonNull
    @Size(min = 1, max = 30, message
            = "About Me must be between 1 and 30 characters")
    @Column(name = "model")
    private String model;

    @NonNull
    @Size(min = 1, max = 15, message
            = "About Me must be between 1 and 15 characters")
    @Column(name = "discipline")
    private String discipline;

    @NonNull
    @Min(value = 50, message = "Price Should not be less than 50")
    @Max(value = 2500, message = "Price should not be greater than 2500")
    @Column(name = "price")
    private Integer price;

    @NonNull
    @Size(min = 15, max = 500, message
            = "About Me must be between 15 and 500 characters")
    @Column(name = "description")
    private String description;
}
