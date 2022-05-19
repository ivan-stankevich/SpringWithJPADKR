package com.example.springwithjpadkr.service;

import com.example.springwithjpadkr.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();

    Album findById(Long id);

    void save(Album album);

    void delete(Long id);

    void deleteAll();
}
