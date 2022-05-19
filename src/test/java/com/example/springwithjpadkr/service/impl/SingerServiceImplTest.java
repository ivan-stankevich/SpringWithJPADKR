package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.Album;
import com.example.springwithjpadkr.entity.AlbumInfo;
import com.example.springwithjpadkr.entity.Singer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootTest
class SingerServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    SingerServiceImpl singerService;
    @Autowired
    AlbumServiceImpl albumService;

    @Test
    void findAll() {
        double begin = System.currentTimeMillis();
        List<Singer> singerList = singerService.findAll();
        double end = System.currentTimeMillis();
        logger.info("findAll() " + "user count: " + singerList.size()
                + " Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findById() {
        double begin = System.currentTimeMillis();
        Singer singer = singerService.findById(201L);
        double end = System.currentTimeMillis();
        logger.info("findByID() ," + " singerID " + singer.getId() + ", Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findSingerByAlbumsId() {
        double begin = System.currentTimeMillis();
        Singer singer = singerService.findSingerByAlbumsId(201L);
        double end = System.currentTimeMillis();
        logger.info("findSingerByAlbumsId() ," + " singerID " + singer.getId() + ", Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findAllByIds() {
        double begin = System.currentTimeMillis();
        List<Singer> singerList = singerService.test(15L, 2000L);
        double end = System.currentTimeMillis();
        logger.info("findAll() " + "user count: " + singerList.size() + ", albums for each users - " + singerList.stream().findFirst().get().getAlbums().size() + " Time in sec:" + (end - begin) / 1000);
    }



    @Test
    void save() {

        singerService.deleteAll();
        albumService.deleteAll();
        double begin = System.currentTimeMillis();
        for (int i = 1; i <= 502; i++) {
            Singer singer = new Singer();
            singer.setFirstName("ivan" + i);
            singer.setLastName("stankevich" + i);
            singer.setBirthDAte(new Date(new GregorianCalendar(1997, Calendar.JANUARY, 4).getTime().getTime()));
            singer.setAlbums(addAlbums(singer));
            singerService.save(singer);
        }
        double end = System.currentTimeMillis();
        logger.info("Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }

    private List<Album> addAlbums(Singer singer) {
        List<Album> albums = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            Album album = new Album();
            album.setTitle("My Life" + i);
            album.setReleaseDate(new Date(new GregorianCalendar(2015, Calendar.JANUARY, 4).getTime().getTime()));
            album.setPrice((double) (300 + i));
            album.setSinger(singer);
            AlbumInfo albumInfo = new AlbumInfo();
            albumInfo.setDescription("description" + i);
            album.setAlbumInfo(albumInfo);
            albumInfo.setAlbum(album);
            albums.add(album);
        }
        return albums;
    }
}