package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.Singer;
import com.example.springwithjpadkr.repository.SingerRepository;
import com.example.springwithjpadkr.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("SingerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return (List<Singer>) singerRepository.findAll();
    }

    public Singer findSingerByAlbumsId(Long id){
        return singerRepository.findSingerByAlbumsId(id);
    }

    @Override
    public Singer findById(Long id) {
        return singerRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        singerRepository.deleteAll();
    }

    public List<Singer> test(Long id, Long id2){
       return singerRepository.findAllByAlbumsIdBetween(id, id2);
    }
}
