package com.infopper.pdfgenerator.repository;

import com.infopper.pdfgenerator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
