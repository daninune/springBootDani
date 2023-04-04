package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDTO {
    private Integer id;
    private String name;
    private Boolean computable;
}
