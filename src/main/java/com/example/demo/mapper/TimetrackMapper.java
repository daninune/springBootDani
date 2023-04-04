package com.example.demo.mapper;

import com.example.demo.dto.TimetrackDTO;
import com.example.demo.model.Timetrack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimetrackMapper {

//    TimetrackMapper INSTANCE = Mappers.getMapper(TimetrackMapper.class);

    @Mapping(target = "employee", source = "employee.id")
    @Mapping(target = "project", source = "project.id")
    @Mapping(target = "workplace", source = "workplace")
    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    TimetrackDTO timetrackToTimetrackDto(Timetrack timetrack);

    @Mapping(source = "employee", target = "employee.id")
    @Mapping(source = "project", target = "project.id")
    @Mapping(target = "date", source = "date", dateFormat = "yyyy-MM-dd")
    Timetrack timetrackDtoToTimetrack(TimetrackDTO timetrackDTO);

    List<TimetrackDTO> timetrackTotimetrackDto(List<Timetrack> timetracks);

    List<Timetrack> timetrackDtoTotimetrack (List<TimetrackDTO> timetrackDTO);
}
