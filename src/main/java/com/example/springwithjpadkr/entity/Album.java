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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "album", indexes = @Index(name = "price_index", columnList = "PRICE DESC"))
@Getter
@Setter
@NamedQuery(name = Album.FIND_ALL_WITH_ORDER, query = "select a from Album a where a.price = (select min(b.price) from Album b)")
public class Album implements Serializable {
    public static final String FIND_ALL_WITH_ORDER = "Album.findAlbumsWithPrice";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    private AlbumInfo albumInfo;
}
