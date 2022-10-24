package com.example.rollerShop.db.dtoEnity;

import com.example.rollerShop.db.entity.Skate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkateMapper {

    @Mapping(target = "id", source = "skate.id")
    @Mapping(target="model", source="skate.model")
    @Mapping(target="brand", source="skate.brand")
    @Mapping(target="discipline", source="skate.discipline")
    @Mapping(target="price", source="skate.price")
    @Mapping(target="description", source="skate.description")
    SkateDto toSkateDto(Skate skate);


    List<SkateDto> toSkateDtos(List<Skate> skates);

    @Mapping(target = "id", source = "skateDto.id")
    @Mapping(target="model", source="skateDto.model")
    @Mapping(target="brand", source="skateDto.brand")
    @Mapping(target="discipline", source="skateDto.discipline")
    @Mapping(target="price", source="skateDto.price")
    @Mapping(target="description", source="skateDto.description")
    Skate toSkate(SkateDto skateDto);

}

