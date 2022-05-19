package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.Album;
import com.example.springwithjpadkr.mapper.dto.AlbumDto;
import com.example.springwithjpadkr.repository.AlbumRepository;
import com.example.springwithjpadkr.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service("AlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public AlbumDto findFullInfoById(Long id){
        AlbumDto albumDto = new AlbumDto();
        Album album = albumRepository.findById(id).orElseThrow(() -> new NullPointerException("Error"));
        albumDto.setId(album.getId());
        albumDto.setTitle(album.getTitle());
        albumDto.setReleaseDate(album.getReleaseDate());
        albumDto.setSinger(album.getSinger());
        albumDto.setAlbumInfo(album.getAlbumInfo());
        return albumDto;
    }

    public List<Album> findAllWithPrice(){
        return em.createNamedQuery(Album.FIND_ALL_WITH_ORDER, Album.class).getResultList();

    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        albumRepository.deleteAll();
    }
}
