package com.infopper.pdfgenerator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String name ;

    @Column(name = "local_address")
    private String address;

    @Column(name = "user_age")
    private Integer age;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_mobile_number")
    private String mobileNumber;

}
