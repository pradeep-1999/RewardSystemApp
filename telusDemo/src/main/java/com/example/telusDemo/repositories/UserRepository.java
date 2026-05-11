package com.example.telusDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.telusDemo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
