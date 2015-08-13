package pl.spring.demo.service.impl;

public class BookSearchCryteria {
	private String title;
	private String author;
	private String libraryName;

	public BookSearchCryteria(String title, String author, String libraryName) {
		this.title = title;
		this.author = author;
		this.libraryName = libraryName;

	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getLibraryName() {
		return libraryName;
	}
}
