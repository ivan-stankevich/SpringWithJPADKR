package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.People;
import com.example.springwithjpadkr.repository.PeopleRepository;
import com.example.springwithjpadkr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    PeopleRepository people;


    @PersistenceContext
    private EntityManager em;

    public List<Object[]> jpaOrder() {
        return em.createNamedQuery(People.FIND_ALL_WITH_ORDER, Object[].class).getResultList();
    }

    @Override
    public List<People> findAll(Pageable pageable) {
        Page<People> page = people.findAll(pageable);
        return page.getContent();
    }

    @Override
    public List<com.example.springwithjpadkr.entity.People> findAll() {
        return (List<com.example.springwithjpadkr.entity.People>) people.findAll();
    }

    @Override
    public com.example.springwithjpadkr.entity.People findById(Long id) {
        return people.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public com.example.springwithjpadkr.entity.People findByName(String name) {
        return people.findByFirstName(name);
    }

    @Override
    public People findByPeopleInfoId(Long id) {
        return people.findByPeopleInfoId(id);
    }

    @Override
    public void save(com.example.springwithjpadkr.entity.People user) {
        people.save(user);
    }

    @Override
    public void delete(com.example.springwithjpadkr.entity.People user) {
        people.delete(user);
    }

    @Override
    public void deleteAll() {
        people.deleteAll();
    }
}
