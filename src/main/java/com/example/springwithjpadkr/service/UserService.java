package com.example.springwithjpadkr.service;

import com.example.springwithjpadkr.entity.People;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<People> findAll(Pageable pageable);

    List<People> findAll();

    People findById(Long id);

    People findByName(String name);

    People findByPeopleInfoId(Long id);

    void save(People user);

    void delete(People user);

    void deleteAll();

}
