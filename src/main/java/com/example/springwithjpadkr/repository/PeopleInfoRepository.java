package com.example.springwithjpadkr.repository;

import com.example.springwithjpadkr.entity.PeopleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleInfoRepository extends JpaRepository<PeopleInfo, Long> {
}
