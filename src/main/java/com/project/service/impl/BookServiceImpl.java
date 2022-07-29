package com.project.service.impl;

import com.project.entity.Book;
import com.project.entity.Subject;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.BookDto;
import com.project.repository.BookRepo;
import com.project.repository.SubjectRepo;
import com.project.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;
    private SubjectRepo subjectRepo;
    private ModelMapper mapper;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo, SubjectRepo repo, ModelMapper mapper) {
        this.bookRepo = bookRepo;
        this.subjectRepo = repo;
        this.mapper = mapper;
    }

    @Override
    public BookDto create(BookDto dto, int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        Book map = this.mapper.map(dto, Book.class);
        map.setSubject(subject);
        Book save = this.bookRepo.save(map);
        return this.mapper.map(save, BookDto.class);
    }

    @Override
    public BookDto update(BookDto dto, int bookId) {
        Book book = this.bookRepo.findById(bookId).orElseThrow(ResourceNotFoundException::new);
        //update properties
        return null;
    }

    @Override
    public void delete(int bookId) {

    }

    @Override
    public BookDto get(int bookId) {
        return null;
    }

    @Override
    public List<BookDto> getBySubjects(int subjectId) {
        return null;
    }
}
