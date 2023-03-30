package com.infopper.pdfgenerator.controller;

import com.infopper.pdfgenerator.dto.UserDto;
import com.infopper.pdfgenerator.pdfexporter.UserPdfExporter;
import com.infopper.pdfgenerator.service.ServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ServiceI serviceI;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        logger.info("Initiating service request for create user {}:"+userDto);
         UserDto userDto1 = serviceI.createUser(userDto);
        logger.info("Completed service request for create user {}:"+userDto1);
         return  new ResponseEntity<>(userDto1 , HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser(){
        logger.info("Initiating service request for Get All user {}:");
         List<UserDto> allUser = serviceI.getAllUser();
        logger.info("Completed service request for Get All user {}:");

        return  new ResponseEntity<>(allUser , HttpStatus.FOUND);

    }

    @GetMapping("/pdf")
    public void exportToPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

         List<UserDto> allUser = serviceI.getAllUser();

        UserPdfExporter userPdfExporter=new UserPdfExporter(allUser);

        userPdfExporter.generator(allUser , response);


    }


}
