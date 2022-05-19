package com.example.springwithjpadkr.repository;

import com.example.springwithjpadkr.entity.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
    Singer findSingerByAlbumsId(long id);
    List<Singer> findAllByAlbumsIdBetween(Long id, Long id2);
}
