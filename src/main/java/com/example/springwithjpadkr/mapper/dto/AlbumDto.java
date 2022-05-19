package com.example.springwithjpadkr.mapper.dto;

import com.example.springwithjpadkr.entity.AlbumInfo;
import com.example.springwithjpadkr.entity.Singer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AlbumDto {

    private Long id;

    private String title;

    private Date releaseDate;

    private Singer singer;

    private AlbumInfo albumInfo;
}
