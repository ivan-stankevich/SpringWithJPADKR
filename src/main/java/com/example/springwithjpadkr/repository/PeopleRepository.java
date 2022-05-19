package com.example.springwithjpadkr.repository;

import com.example.springwithjpadkr.entity.People;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends PagingAndSortingRepository<People, Long> {

    People findByFirstName(String name);

    People findPeopleAndPeopleInfoById(Long id);

    People findByPeopleInfoId(Long id);
}
