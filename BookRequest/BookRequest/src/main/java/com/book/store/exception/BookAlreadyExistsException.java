package com.book.store.exception;

public class BookAlreadyExistsException extends RuntimeException {
	public BookAlreadyExistsException(String msg) {
		super(msg);
	}
}
