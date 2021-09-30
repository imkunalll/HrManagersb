package com.nagarro.mvcspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.mvcspringboot.entities.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

}
