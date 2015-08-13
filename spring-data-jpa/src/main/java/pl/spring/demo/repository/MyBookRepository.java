package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.service.impl.BookSearchCryteria;

public interface MyBookRepository {
	public List<BookEntity> findBooksByAllCryteria(BookSearchCryteria bookSearchCryteria);

}
