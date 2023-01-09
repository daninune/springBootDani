package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.user.User;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
/*
    @Named("toEmployeeDTO")
    EmployeeDTO toEmployeeDTO(Employee employee);
    @Named("toEmployee")
    Employee toEmployee(EmployeeDTO employeeDTO);

    @Named("toEmployeeDTOList")
    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employees);
    @Name("toEmployeeList")
    List<Employee> toEmployeeList(List<EmployeeDTO> employeesDTO);
    @Named("toUser")
    User userDtoToUser(UserDTO userDto);*/
}