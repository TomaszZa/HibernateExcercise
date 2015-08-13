package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.repository.MyBookRepository;
import pl.spring.demo.service.impl.BookSearchCryteria;

public class BookRepositoryImpl implements MyBookRepository {

	@PersistenceContext(name = "hsql")
	private EntityManager entityManager;

	@Override
	public List<BookEntity> findBooksByAllCryteria(BookSearchCryteria bookSearchCryteria) {
		QBookEntity bookEntity = QBookEntity.bookEntity;
		JPQLQuery query = new JPAQuery(entityManager).from(bookEntity);
		return query.from(bookEntity)
				.where(bookEntity.title.eq(bookSearchCryteria.getTitle())
						.or(bookEntity.authors.any().firstName.eq(bookSearchCryteria.getAuthor()))
						.or(bookEntity.authors.any().lastName.eq(bookSearchCryteria.getAuthor()))
						.or(bookEntity.library.name.eq(bookSearchCryteria.getLibraryName())))
				.listResults(bookEntity).getResults();
	}

}
