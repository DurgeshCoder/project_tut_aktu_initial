package com.project.controller;

import com.project.payload.ApiResponse;
import com.project.payload.BookDto;
import com.project.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //create
    @PostMapping("/subjects{subjectId}/books")
    public ResponseEntity<BookDto> create(
            @RequestBody BookDto dto,
            @PathVariable int subjectId
    ) {
        BookDto bookDto = this.bookService.create(dto, subjectId);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }


    //update
    @PostMapping("/books/{bookId}")
    public ResponseEntity<BookDto> update(
            @RequestBody BookDto dto,
            @PathVariable int bookId
    ) {
        BookDto bookDto = this.bookService.update(dto, bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable int bookId
    ) {
        this.bookService.delete(bookId);
        return new ResponseEntity<>(ApiResponse.getDefaultDeleteInstance("Book"), HttpStatus.OK);
    }

    //get
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> get(
            @PathVariable int bookId
    ) {
        BookDto dto = this.bookService.get(bookId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //get all by subjects
    @GetMapping("subjects/{subjectId}/books")
    public ResponseEntity<List<BookDto>> getAllBySubjects(
            @PathVariable int subjectId
    ) {
        List<BookDto> dtos = this.bookService.getBySubjects(subjectId);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
