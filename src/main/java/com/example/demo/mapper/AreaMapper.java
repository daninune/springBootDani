package com.example.demo.mapper;

import com.example.demo.dto.AreaDTO;
import com.example.demo.model.Area;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = Area.class)
public interface AreaMapper {

    AreaMapper instance = Mappers.getMapper(AreaMapper.class);

    Area toEntity(AreaDTO area);

    List<AreaDTO> listAreasToDTO(List<Area> areas);

    AreaDTO toDTO(Area a);

}
