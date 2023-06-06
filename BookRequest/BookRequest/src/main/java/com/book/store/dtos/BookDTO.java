package com.book.store.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.book.store.enums.BookEditStatusEnum;
import com.book.store.enums.BookStatusEnum;

public class BookDTO {
	private Long id;
//  @OneToOne
//  @JoinColumn(name = "id")
	private Long user;
	private String title;
	private Double price;
	private Integer pages;
	private String description;
	@Column(length = 3000, columnDefinition = "TEXT")
	private String content;
	private BookEditStatusEnum editStatus;
	private BookStatusEnum bookStatus;
	private LocalDateTime createdAt;

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(Long id, Long user, String title, Double price, Integer pages, String description, String content,
			BookEditStatusEnum editStatus, BookStatusEnum bookStatus, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.price = price;
		this.pages = pages;
		this.description = description;
		this.content = content;
		this.editStatus = editStatus;
		this.bookStatus = bookStatus;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BookEditStatusEnum getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(BookEditStatusEnum editStatus) {
		this.editStatus = editStatus;
	}

	public BookStatusEnum getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatusEnum bookStatus) {
		this.bookStatus = bookStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
