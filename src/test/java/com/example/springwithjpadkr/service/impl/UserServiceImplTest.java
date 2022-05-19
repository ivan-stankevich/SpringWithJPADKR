package com.example.springwithjpadkr.service.impl;

import com.example.springwithjpadkr.entity.AgeAndCount;
import com.example.springwithjpadkr.entity.People;
import com.example.springwithjpadkr.entity.PeopleInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest
class UserServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Qualifier("UserService")
    @Autowired
    UserServiceImpl peopleService;

    @Test
    void findAll() {
        double begin = System.currentTimeMillis();
        List<People> peopleList = peopleService.findAll();
        double end = System.currentTimeMillis();
        logger.info("findAll() " + "count: " + peopleList.size() + " Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findById() {
        double begin = System.currentTimeMillis();
        People people = peopleService.findById(3001L);
        double end = System.currentTimeMillis();
        logger.info("findByID() ," + " userID " + people.getId()
                + " birthday " + people.getPeopleInfo().getBirthDAte()
                + ", Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findByPeopleInfoId() {
        double begin = System.currentTimeMillis();
        People people = peopleService.findByPeopleInfoId(3001L);
        double end = System.currentTimeMillis();
        logger.info("findByPeopleInfoId() ," + " People Name :" + people.getFirstName()
                + " People Info id :" + people.getPeopleInfo().getId()
                + ", Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findByName() {
        double begin = System.currentTimeMillis();
        People people = peopleService.findByName("firstName1");
        double end = System.currentTimeMillis();
        logger.info("findByName() ," + " People Name :" + people.getFirstName() + ", Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findAllWithPageable() {
        double begin = System.currentTimeMillis();
        Pageable paging = PageRequest.of(2, 5, Sort.by("id"));
        List<People> peopleList = peopleService.findAll(paging);
        double end = System.currentTimeMillis();
        peopleList.forEach(a -> System.out.println(a.getId() + " " + a.getFirstName() + " " + a.getSecondName()));
        logger.info("findAllWithPageable() " + " Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void save() {
        long number = 375291111111L;
        peopleService.deleteAll();
        double begin = System.currentTimeMillis();
        Random random = new Random();
        for (int a = 1; a <= 1000; a++) {
            People people = new People();
            people.setFirstName("firstName" + a);
            people.setSecondName("secondName" + a);
            PeopleInfo peopleInfo = new PeopleInfo();
            peopleInfo.setBirthDAte(new Date(new GregorianCalendar(1997, Calendar.JANUARY, 4).getTime().getTime()));
            peopleInfo.setEmail("testEmail" + a + "@test.com");
            peopleInfo.setPhone(String.valueOf(number));
            peopleInfo.setAge(random.nextInt((30 - 20) + 1) + 20);
            people.setPeopleInfo(peopleInfo);
            peopleInfo.setPeople(people);
            peopleService.save(people);
            number++;
        }
        double end = System.currentTimeMillis();
        logger.info("Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void testWithOrderJPA() {
        double begin = System.currentTimeMillis();
        for (Object[] o : peopleService.jpaOrder()) {
            System.out.println("age - " + o[0] + " count - " + o[1]);
        }
        double end = System.currentTimeMillis();
        logger.info("Time in sec:" + (end - begin) / 1000);
    }

    @Test
    void findAllAndGroup() {
        double begin = System.currentTimeMillis();
        List<People> peopleList = peopleService.findAll();
        HashSet<Integer> ageList = new HashSet<>();
        peopleList.forEach(people -> ageList.add(people.getPeopleInfo().getAge()));

        List<AgeAndCount> ageAndCountList = ageList.stream().map(a -> {
            AgeAndCount ageAndCount = new AgeAndCount();
            ageAndCount.setAge(a);
            long count = peopleList.stream().map(people -> people.getPeopleInfo().getAge())
                    .filter(age -> age.compareTo(a) == 0).count();
            ageAndCount.setCount((int) count);
            return ageAndCount;
        }).collect(Collectors.toList());

        double end = System.currentTimeMillis();
        ageAndCountList.forEach(System.out::println);
        logger.info(" Time in sec:" + (end - begin) / 1000);
    }
}