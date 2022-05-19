package com.example.springwithjpadkr.service;

import com.example.springwithjpadkr.entity.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();

    Singer findById(Long id);

    Singer findSingerByAlbumsId(Long id);

    void save(Singer singer);

    void delete(Long id);

    void deleteAll();
}
