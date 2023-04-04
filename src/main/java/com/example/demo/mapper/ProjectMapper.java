package com.example.demo.mapper;

import com.example.demo.model.Project;
import org.mapstruct.Mapper;
import com.example.demo.dto.ProjectDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toEntity(ProjectDTO p);
}
