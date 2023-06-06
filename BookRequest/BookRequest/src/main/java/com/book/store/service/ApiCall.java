package com.book.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.book.store.dtos.BookDTO;
import com.book.store.models.Book;

@Service
public class ApiCall {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Book getBookDetails(Long bookId) {
		Book book=restTemplate.getForObject("http://BOOK-SERVICE/api/admin/book/{bookId}",Book.class,bookId);
		return book;
	}

}
