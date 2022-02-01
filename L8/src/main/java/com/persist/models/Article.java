package com.persist.models;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Article {
    private String name;
    private String description;
    private String file;
    private LocalDate date;

}
