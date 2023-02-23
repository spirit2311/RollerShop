package com.example.rollerShop.db.dto;

import com.example.rollerShop.db.entity.Brand;
import com.example.rollerShop.db.entity.Discipline;
import com.example.rollerShop.db.entity.Skate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import com.example.rollerShop.db.mappers.SkateMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T01:08:16+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class SkateMapperImpl implements SkateMapper {

    @Override
    public SkateDto toSkateDto(Skate skate) {
        if ( skate == null ) {
            return null;
        }

        SkateDto skateDto = new SkateDto();

        skateDto.setUuid( skate.getUuid() );
        skateDto.setDiscipline( disciplineToDisciplineDto( skate.getDiscipline() ) );
        skateDto.setBrand( brandToBrandDto( skate.getBrand() ) );
        skateDto.setModel( skate.getModel() );
        skateDto.setYear( skate.getYear() );
        skateDto.setPrice( skate.getPrice() );
        skateDto.setDescription( skate.getDescription() );

        return skateDto;
    }

    @Override
    public List<SkateDto> toSkateDtos(List<Skate> skates) {
        if ( skates == null ) {
            return null;
        }

        List<SkateDto> list = new ArrayList<SkateDto>( skates.size() );
        for ( Skate skate : skates ) {
            list.add( toSkateDto( skate ) );
        }

        return list;
    }

    @Override
    public Skate toSkate(SkateDto skateDto) {
        if ( skateDto == null ) {
            return null;
        }

        Skate.SkateBuilder skate = Skate.builder();

        skate.uuid( skateDto.getUuid() );
        skate.discipline( disciplineDtoToDiscipline( skateDto.getDiscipline() ) );
        skate.brand( brandDtoToBrand( skateDto.getBrand() ) );
        skate.model( skateDto.getModel() );
        skate.year( skateDto.getYear() );
        skate.price( skateDto.getPrice() );
        skate.description( skateDto.getDescription() );

        return skate.build();
    }

    protected DisciplineDto disciplineToDisciplineDto(Discipline discipline) {
        if ( discipline == null ) {
            return null;
        }

        DisciplineDto disciplineDto = new DisciplineDto();

        disciplineDto.setDiscipline( discipline.getDiscipline() );

        return disciplineDto;
    }

    protected BrandDto brandToBrandDto(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setBrand( brand.getBrand() );

        return brandDto;
    }

    protected Discipline disciplineDtoToDiscipline(DisciplineDto disciplineDto) {
        if ( disciplineDto == null ) {
            return null;
        }

        Discipline.DisciplineBuilder discipline = Discipline.builder();

        discipline.discipline( disciplineDto.getDiscipline() );

        return discipline.build();
    }

    protected Brand brandDtoToBrand(BrandDto brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        Brand.BrandBuilder brand = Brand.builder();

        brand.brand( brandDto.getBrand() );

        return brand.build();
    }
}
