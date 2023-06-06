package com.book.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.store.dtos.UpdateBookReqDTO;
import com.book.store.model.BookRequest;

@Service
public interface BookRequestService {

	 public BookRequest createBookRequest(Long bookId,Long UserId);
	    public void deleteBookRequest(Long bookReqId);
	    public List<BookRequest> allBookRequests();
	    public List<BookRequest> myBookRequests(Long userId);
	    public BookRequest updateBookRequest(UpdateBookReqDTO r);
}
