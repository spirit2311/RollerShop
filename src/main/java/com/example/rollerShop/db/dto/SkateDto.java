package com.example.rollerShop.db.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SkateDto {

//    @Positive
//    private Integer id;

    private UUID uuid = UUID.randomUUID();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "TEST")
    private Integer disciplineId;

    private DisciplineDto discipline;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "TEST")
    private Integer brandId;

    private BrandDto brand;

    @NonNull
    @Size(min = 1, max = 30, message = "About Me must be between 1 and 30 characters")
    private String model;

    @NonNull
    @Min(value = 2000, message = "Year Should not be less than 2000")
    @Max(value = 2023, message = "Year should not be greater than 2023")
    private Integer year;

    @NonNull
    @Min(value = 50, message = "Price Should not be less than 50")
    @Max(value = 2500, message = "Price should not be greater than 2500")
    private Integer price;

    @NonNull
    @Size(min = 1, max = 500, message = "About Me must be between 15 and 500 characters")
    private String description;
}
