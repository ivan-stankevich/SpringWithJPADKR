package com.example.springwithjpadkr.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeAndCount {
    int age;
    int count;

    @Override
    public String toString() {
        return "age - " + age + " count - " + count;
    }
}
