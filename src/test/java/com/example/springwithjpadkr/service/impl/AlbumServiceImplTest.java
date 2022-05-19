package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.Album;
import com.example.springwithjpadkr.mapper.dto.AlbumDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlbumServiceImplTest {

    @Autowired
    AlbumServiceImpl albumService;

    private static final Logger logger = LoggerFactory.getLogger(AlbumServiceImplTest.class);

    @Test
    void findAllWithPrice() {
        double begin = System.currentTimeMillis();
        List<Album> albums = albumService.findAllWithPrice();
        System.out.println(albums.size());
        double end = System.currentTimeMillis();
        logger.info("Time in msec:" + (end - begin));
    }

    @Test
    void findById() {
        AlbumDto albumDto = albumService.findFullInfoById(1L);
        System.out.println("AlbumId - " + albumDto.getId()
                + " AlbumTitle - " + albumDto.getTitle()
                + " AlbumReleaseDate - " + albumDto.getReleaseDate()
                + "\nSinger Info : singerID - " + albumDto.getSinger().getId()
                + " singerFirstName - " + albumDto.getSinger().getFirstName()
                + " singerSecondName - " + albumDto.getSinger().getLastName()
                + " singerBirthDate - " + albumDto.getSinger().getBirthDAte()
                + "\nAlbumInfo : albumInfoId - " + albumDto.getAlbumInfo().getId()
                + "  AlbumDescription - " + albumDto.getAlbumInfo().getDescription());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}