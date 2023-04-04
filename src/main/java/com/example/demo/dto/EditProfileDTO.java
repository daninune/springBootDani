package com.example.demo.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class EditProfileDTO {

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 2, max = 100,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String name;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 2, max = 100,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String lastname;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 9, max = 10,  message = "#{valid.size}")
    @Pattern(regexp = "^(?:(?:(?:X|Y|Z)?\\d{7,8})([A-Z]))$", message = "#{valid.pattern}")
    private String idcard;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 9, max = 10,  message = "#{valid.size}")
    @Pattern(regexp = "^(19|20|21)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "#{valid.pattern}")
    private String fechaNacimiento;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 9, max = 14,  message = "#{valid.size}")
    @Pattern(regexp = "^(\\+\\d{1,3})?\\d{1,14}$", message = "#{valid.pattern}")
    private String tel;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 4, max = 100,  message = "#{valid.size}")
    @Email(message = "#{valid.error}")
    private String email;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 9, max = 12,  message = "#{valid.size}")
    @Pattern(regexp = "^\\d{9,12}$", message = "#{valid.pattern}")
    private String ssnumber;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 15, max = 34,  message = "#{valid.size}")
    @Pattern(regexp = "^[A-Za-z]{2}[0-9]{2}[A-Z0-9]{1,30}$", message = "#{valid.pattern}")
    private String iban;
    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 1, max = 200,  message = "#{valid.size}")
    @Pattern(regexp = "^[A-Za-z0-9\\s,.\\-\\p{L}]*$", message = "#{valid.pattern}")
    private String address;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 1, max = 50,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-]*$" , message = "#{valid.pattern}")
    private String zip;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 1, max = 150,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$" , message = "#{valid.pattern}")
    private String city;

    @NotNull(message = "#{valid.notBlank}")
    @Min(value = 1, message = "#{valid.size}")
    @Max(value = 100, message = "#{valid.size}")
    private Integer idprovince;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 1, max = 150,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$" , message = "#{valid.pattern}")
    private String country;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 1, max = 20,  message = "#{valid.size}")
    @Pattern(regexp = "^[A-Za-z0-9]*$" , message = "#{valid.pattern}")
    private String nip;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 2, max = 100,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String job;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 2, max = 100,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String category;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 2, max = 100,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String area;

    @NotNull(message = "#{valid.notBlank}")
    @Min(value = 1, message = "#{valid.size}")
    @Max(value = 100, message = "#{valid.size}")
    private Integer idoffice;

    @NotNull(message = "#{valid.notBlank}")
    @Min(value = 1, message = "#{valid.size}")
    @Max(value = 100, message = "#{valid.size}")
    private Integer idschedule;

    @NotBlank(message = "#{valid.notBlank}")
    @Size(min = 9, max = 10,  message = "#{valid.size}")
    @Pattern(regexp = "^(19|20|21)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", message = "#{valid.pattern}")
    private String startdate;

    @Nullable
    @Size(min = 0, max = 10,  message = "#{valid.size}")
    @Pattern(regexp = "^((19|20|21)\\\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))?$", message = "#{valid.pattern}")
    private String leavingdate;
}
