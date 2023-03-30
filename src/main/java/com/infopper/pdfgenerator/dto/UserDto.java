package com.infopper.pdfgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Integer id;

    private String name ;

    private String address;

    private Integer age;

    private String gender;

    private String mobileNumber;

}
