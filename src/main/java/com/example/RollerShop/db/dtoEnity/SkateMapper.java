package com.example.RollerShop.db.dtoEnity;

import com.example.RollerShop.db.entity.Skate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkateMapper {

    @Mapping(target = "userSkate", source = "skate")
    SkateDto toSkateDto(Skate skate);


    List<SkateDto> toSkateDtos(List<Skate> skates);

    @Mapping(target = "skate", source = "userSkate")
    Skate toSkate(SkateDto skateDto);

}
