package com.book.store.daos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.store.model.BookRequest;

import java.util.List;

@Repository
public interface BookRequestDAO extends JpaRepository<BookRequest, Long> {
    //long deleteByBook(Book book);
    List<BookRequest> findByBookUser(Long userId);
}
