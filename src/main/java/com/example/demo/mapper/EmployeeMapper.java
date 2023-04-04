package com.example.demo.mapper;

import com.example.demo.dto.EditProfileDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOtoEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> toEmployeesDTOs(List<Employee> employees);

    List<Employee> toEmployees(List<EmployeeDTO> employeeDTOs);

    @Mapping(target = "fechaNacimiento", dateFormat = "YYYY-MM-dd")
    @Mapping(target = "startdate", dateFormat = "YYYY-MM-dd")
    @Mapping(target = "leavingdate", dateFormat = "YYYY-MM-dd")
    EditProfileDTO toEditProfileDTO(Employee employee);

    @Mapping(target = "fechaNacimiento", expression = "java((editProfileDTO.getFechaNacimiento() == null || editProfileDTO.getFechaNacimiento().isEmpty()) ? null : editProfileDTO.getFechaNacimiento())")
    @Mapping(target = "startdate", expression = "java((editProfileDTO.getStartdate() == null || editProfileDTO.getStartdate().isEmpty()) ? null : editProfileDTO.getStartdate())")
    @Mapping(target = "leavingdate", expression = "java((editProfileDTO.getLeavingdate() == null || editProfileDTO.getLeavingdate().isEmpty()) ? null : editProfileDTO.getLeavingdate())")
    @Mapping(target = "id", source = "employeeId")
    Employee toEntity(EditProfileDTO editProfileDTO, Integer employeeId);

}
