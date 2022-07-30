package com.project.repository;

import com.project.entity.Book;
import com.project.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findBySubject(Subject subject);
}
