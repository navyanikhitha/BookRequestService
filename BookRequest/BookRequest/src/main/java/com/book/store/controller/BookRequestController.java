package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.dto.BasicResponseDTO;
import com.book.store.dtos.UpdateBookReqDTO;
import com.book.store.model.BookRequest;
import com.book.store.service.BookRequestService;

@RestController
@CrossOrigin
@RequestMapping("/api/bookReq")
public class BookRequestController {
	
	
	@Autowired
	private BookRequestService bookService;
	
	 @PostMapping("/create-book-request/{bookId}/{UserId}")
	    public ResponseEntity<BasicResponseDTO<BookRequest>> createBookRequest(@PathVariable("bookId") Long bookId,@PathVariable("UserId") Long UserId){
	        BookRequest bookRequest = bookService.createBookRequest(bookId,UserId);
	        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book request created", bookRequest), HttpStatus.OK);
	    }
	   
	 
	 @PutMapping("/book-request-update")
	    public ResponseEntity<BasicResponseDTO<BookRequest>> updateBookRequest(@RequestBody UpdateBookReqDTO r){
	        BookRequest bookRequest = bookService.updateBookRequest(r);
	        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book request updated", bookRequest), HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/delete-book-request/{bookReqId}")
	    public ResponseEntity<BasicResponseDTO<String>> deleteBookRequest(@PathVariable("bookReqId") Long bookReqId){
	        bookService.deleteBookRequest(bookReqId);
	        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Book request successfully deleted", null), HttpStatus.OK);
	    }
	 
	 @GetMapping("/my-books-requests/{userId}")
	    public ResponseEntity<BasicResponseDTO<List<BookRequest>>> myBookRequests(@PathVariable("userId") Long userId){
	        List<BookRequest> bookRequests = bookService.myBookRequests(userId);
	        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Books request list", bookRequests), HttpStatus.OK);
	    }
	

	 @GetMapping("/book-requests")
	    public ResponseEntity<BasicResponseDTO<List<BookRequest>>> allRequests(){
	        List<BookRequest> bookRequests = bookService.allBookRequests();
	        return new ResponseEntity<>(new BasicResponseDTO<>(true, "Books requests list", bookRequests), HttpStatus.OK);
	    }
}
