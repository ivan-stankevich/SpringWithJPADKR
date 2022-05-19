package com.example.springwithjpadkr.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "people")
@NamedQuery(name = People.FIND_ALL_WITH_ORDER, query = "select a.age as age, count(a.people.id) as countPeople" +
        " from PeopleInfo a group by age order by age")
public class People implements Serializable {
    public static final String FIND_ALL_WITH_ORDER = "People.findAllWithGroup";
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "SECOND_NAME")
    String secondName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "people", orphanRemoval = true)
    private PeopleInfo peopleInfo;
}
