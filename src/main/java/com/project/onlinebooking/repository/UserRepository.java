package com.project.onlinebooking.repository;

import com.project.onlinebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository<User, String> -> <model class, Id type>
//Spring data can automatically implement the CRUD
@Repository //generate spring object
public interface UserRepository extends JpaRepository<User, String> {

}
