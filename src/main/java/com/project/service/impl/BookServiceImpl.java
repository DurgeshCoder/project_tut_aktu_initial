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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        book.setCoverUrl(dto.getCoverUrl());
        book.setDownloadCount(dto.getDownloadCount());
        book.setEdition(dto.getEdition());
        book.setTotalPages(dto.getTotalPages());
        book.setViewCount(dto.getViewCount());
        book.setTitle(dto.getWriter());
        book.setEdition(dto.getEdition());
        Book save = this.bookRepo.save(book);
        return this.mapper.map(save, BookDto.class);
    }

    @Override
    public void delete(int bookId) {
        Book book = this.bookRepo.findById(bookId).orElseThrow(ResourceNotFoundException::new);
        this.bookRepo.delete(book);
    }

    @Override
    public BookDto get(int bookId) {
        Book book = this.bookRepo.findById(bookId).orElseThrow(ResourceNotFoundException::new);
        return this.mapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getBySubjects(int subjectId) {
        Subject subject = this.subjectRepo.findById(subjectId).orElseThrow(ResourceNotFoundException::new);
        List<Book> list = this.bookRepo.findBySubject(subject);
        return list.stream().map(book -> this.mapper.map(book, BookDto.class)).collect(Collectors.toList());
    }
}
