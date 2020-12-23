package com.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.UserData;


@Repository
public interface UserDAO extends JpaRepository<UserData, String> {

}
