package com.book.store.service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.book.store.dao.BookDAO;
import com.book.store.daos.BookRequestDAO;
import com.book.store.dto.UserDTO;
import com.book.store.dtos.BookDTO;
import com.book.store.dtos.UpdateBookReqDTO;
import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;
import com.book.store.exception.ResourceNotFoundException;
import com.book.store.model.BookRequest;
//import com.book.store.enums.BookEditStatusEnum;
import com.book.store.models.Book;

@Service
public class BookRequestServiceImpl implements BookRequestService{
	
	
	@Autowired 
	private BookRequestDAO bookRequestDAO;
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private ApiCall apiCall;
	
	 @Autowired
	 private RestTemplate restTemplate;
	
	@Override
    @Transactional
    public BookRequest createBookRequest(Long bookId,Long UserId) {
       //Book book = bookDAO.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found."));
		//BookDTO book= restTemplate.getForObject("http://BOOK-SERVICE/api/admin/book/bookId?bookId={bookId}",BookDTO.class,bookId) ;
		Book book= restTemplate.getForObject("http://localhost:8084/api/admin/book/{bookId}", Book.class,bookId);
		book.setId(bookId);
		book.setUser(UserId);
		book.setEditStatus(BookEditStatusEnum.COMPLETED);
		System.out.println(book.getId());
        bookDAO.save(book);
        BookRequest bookRequest = new BookRequest(null, book, LocalDateTime.now(), BookStatusEnum.PENDING, "");
        bookRequestDAO.save(bookRequest);
        return bookRequest;
    }

    @Override
    @Transactional
    public void deleteBookRequest(Long bookReqId) {
        BookRequest bookRequest = bookRequestDAO.findById(bookReqId)
                .orElseThrow(() -> new ResourceNotFoundException("Book request not found"));
        Book book = bookDAO.findById(bookRequest.getBook().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setEditStatus(BookEditStatusEnum.WORKING);
        book.setBookStatus(BookStatusEnum.PENDING);
        bookDAO.save(book);
        bookRequestDAO.deleteById(bookReqId);
    }

    @Override
    public List<BookRequest> allBookRequests() {
        return bookRequestDAO.findAll();
    }

    @Override
    public List<BookRequest> myBookRequests(Long userId) {
        return bookRequestDAO.findByBookUser(userId);
    }

    @Override
    @Transactional
    public BookRequest updateBookRequest(UpdateBookReqDTO r) {
        BookRequest bookRequest = bookRequestDAO.findById(r.getBookIdReq()).orElseThrow(() -> new ResourceNotFoundException("Book request not found."));
        bookRequest.setBookStatus(r.getBookStatus());
        Book book = bookRequest.getBook();
        //book.setBookStatus(r.getBookStatus());
        book.setBookStatus(r.getBookStatus());
        bookDAO.save(book);
        bookRequest.setBook(book);
        bookRequestDAO.save(bookRequest);
        return bookRequest;
    }
}
