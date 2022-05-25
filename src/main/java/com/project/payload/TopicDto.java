package com.project.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class TopicDto {

    private int id;
    private String title;
    private String content;

    private String pageAuthor;
    private String pageKeywords;
    private String pageDescription;

}
