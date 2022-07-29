package com.project.service;

import com.project.payload.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDto create(BookDto dto, int subjectId);

    BookDto update(BookDto dto, int bookId);


    void delete(int bookId);

    BookDto get(int bookId);

    List<BookDto> getBySubjects(int subjectId);

}
