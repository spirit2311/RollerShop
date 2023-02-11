package com.example.rollerShop.db.dtoEnity;

import com.example.rollerShop.db.entity.Skate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkateMapper {


    //    @Mappings({
//            @Mapping(target = "disciplineS", source = "skate.disciplineS", qualifiedByName = "TEST")
//    })
    SkateDto toSkateDto(Skate skate);


    List<SkateDto> toSkateDtos(List<Skate> skates);


    Skate toSkate(SkateDto skateDto);

}

