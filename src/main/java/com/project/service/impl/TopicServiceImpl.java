package com.project.service.impl;

import com.project.entity.Subject;
import com.project.entity.Topic;
import com.project.entity.Unit;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.TopicDto;
import com.project.repository.SubjectRepo;
import com.project.repository.TopicRepo;
import com.project.repository.UnitRepo;
import com.project.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepo topicRepo;
    private SubjectRepo subjectRepo;
    private UnitRepo unitRepo;
    private ModelMapper mapper;

    @Autowired
    public TopicServiceImpl(TopicRepo topicRepo, SubjectRepo subjectRepo, UnitRepo unitRepo, ModelMapper mapper) {
        this.topicRepo = topicRepo;
        this.subjectRepo = subjectRepo;
        this.unitRepo = unitRepo;
        this.mapper = mapper;
    }

    @Override
    public TopicDto create(TopicDto topicDto, int unitId, int subjectId) {

        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        Unit unit = this.unitRepo.findById(unitId).orElseThrow(ResourceNotFoundException::new);
        Topic topic = this.mapper.map(topicDto, Topic.class);
        topic.setSubject(subject);
        topic.setUnit(unit);
        Topic save = this.topicRepo.save(topic);
        return this.mapper.map(save, TopicDto.class);
    }

    @Override
    public TopicDto update(int topicId, TopicDto topicDto) {
        Topic topic = this.topicRepo.findById(topicId).orElseThrow(ResourceNotFoundException::new);
        topic.setContent(topicDto.getContent());
        topic.setTitle(topicDto.getTitle());
        topic.setPageAuthor(topicDto.getPageAuthor());
        topic.setPageKeywords(topicDto.getPageKeywords());
        topic.setPageDescription(topicDto.getPageDescription());
        Topic save = this.topicRepo.save(topic);
        return this.mapper.map(save, TopicDto.class);
    }

    @Override
    public void delete(int topicId) {
        Topic topic = this.topicRepo.findById(topicId).orElseThrow(ResourceNotFoundException::new);
        this.topicRepo.delete(topic);
    }

    @Override
    public TopicDto getById(int topicId) {
        Topic topic = this.topicRepo.findById(topicId).orElseThrow(ResourceNotFoundException::new);
        return this.mapper.map(topic, TopicDto.class);
    }

    @Override
    public List<TopicDto> getTopicsByUnits(int unitId) {
        Unit unit = this.unitRepo.findById(unitId).orElseThrow(ResourceNotFoundException::new);
        List<Topic> topics = this.topicRepo.findByUnit(unit);
        List<TopicDto> collect = topics.stream().map(topic -> this.mapper.map(topic, TopicDto.class)).collect(Collectors.toList());
        return collect;

    }

    @Override
    public List<TopicDto> getTopicsBySubjects(int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        List<Topic> list = this.topicRepo.findBySubject(subject);
        List<TopicDto> collect = list.stream().map(topic -> this.mapper.map(topic, TopicDto.class)).collect(Collectors.toList());
        return collect;
    }
}
