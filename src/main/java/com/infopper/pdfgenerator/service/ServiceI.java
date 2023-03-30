package com.infopper.pdfgenerator.service;

import com.infopper.pdfgenerator.dto.UserDto;

import java.util.List;

public interface ServiceI {

    // create user

    UserDto createUser(UserDto userDto);


    // Get All user
    List<UserDto> getAllUser();

    // create PDF


}
