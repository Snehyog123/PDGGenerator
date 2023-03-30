package com.infopper.pdfgenerator.service.Impl;

import com.infopper.pdfgenerator.dto.UserDto;
import com.infopper.pdfgenerator.entity.User;
import com.infopper.pdfgenerator.repository.UserRepository;
import com.infopper.pdfgenerator.service.ServiceI;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements ServiceI {

    private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        logger.info("Initiating Dao request for create User {}:" + userDto);
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        UserDto userDto1 = modelMapper.map(savedUser, UserDto.class);
        logger.info("Completed Dao request for create User {}:" + userDto1);

        return userDto1;
    }

    @Override
    public List<UserDto> getAllUser() {
        logger.info("Initiating Dao request for Get All User {}:");
         List<User> listUser = userRepository.findAll();
         List<UserDto> listUserDtos = listUser.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        logger.info("Completed Dao request for Get All User {}:");
        return listUserDtos;
    }
}
