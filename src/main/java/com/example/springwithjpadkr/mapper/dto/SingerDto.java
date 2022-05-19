package com.example.springwithjpadkr.mapper.dto;

import com.example.springwithjpadkr.entity.Album;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SingerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDAte;

    private List<Album> albums = new ArrayList<>();
}
