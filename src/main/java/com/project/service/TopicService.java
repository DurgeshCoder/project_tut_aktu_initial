package com.project.service;

import com.project.payload.TopicDto;

import java.util.List;

public interface TopicService {


    //create topic
    TopicDto create(TopicDto topicDto,int unitId, int subjectId);

    //update
    TopicDto update(int topicId, TopicDto topicDto);


    //delete

    void delete(int topicId);


    //get topic

    TopicDto getById(int topicId);

    //get topics by unit
    List<TopicDto> getTopicsByUnits(int unitId);

    // get topics by subject
    List<TopicDto> getTopicsBySubjects(int subjectId);
}
