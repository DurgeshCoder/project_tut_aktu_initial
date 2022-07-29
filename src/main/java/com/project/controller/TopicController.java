package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.TopicDto;
import com.project.service.TopicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    //create
    @PostMapping("/subjects/{subjectId}/units/{unitId}/topics")
    public ResponseEntity<TopicDto> create(
            @RequestBody TopicDto dto,
            @PathVariable int subjectId,
            @PathVariable int unitId
    ) {

        TopicDto topicDto = this.topicService.create(dto, unitId, subjectId);
        return new ResponseEntity<>(topicDto, HttpStatus.CREATED);


    }

    //update
    @PutMapping("/topics/{topicId}")
    public ResponseEntity<TopicDto> update(
            @RequestBody TopicDto dto,
            @PathVariable int topicId
    ) {
        TopicDto update = this.topicService.update(topicId, dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    //delete

    @DeleteMapping("/topics/{topicId}")
    public ResponseEntity<ApiResponse> update(
            @PathVariable int topicId
    ) {
        this.topicService.delete(topicId);
        return new ResponseEntity<>(ApiResponse.getDefaultDeleteInstance("Topic"), HttpStatus.OK);
    }

    //get
    @GetMapping("/topics/{topicId}")
    public ResponseEntity<TopicDto> get(
            @PathVariable int topicId
    ) {
        TopicDto byId = this.topicService.getById(topicId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    //get by subjects
    @GetMapping("/subjects/{subjectId}/topics")
    public ResponseEntity<List<TopicDto>> getBySubjects(
            @PathVariable int subjectId
    ) {
        List<TopicDto> topicsBySubjects = this.topicService.getTopicsBySubjects(subjectId);
        return new ResponseEntity<>(topicsBySubjects, HttpStatus.OK);
    }

    //get by units
    @GetMapping("/units/{units}/topics")
    public ResponseEntity<List<TopicDto>> getByUnit(
            @PathVariable int unitId
    ) {
        List<TopicDto> topicsBySubjects = this.topicService.getTopicsByUnits(unitId);
        return new ResponseEntity<>(topicsBySubjects, HttpStatus.OK);
    }


}
