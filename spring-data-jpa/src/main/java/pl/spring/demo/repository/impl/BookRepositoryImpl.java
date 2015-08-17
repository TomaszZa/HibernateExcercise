package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.mysema.query.BooleanBuilder;
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
		BooleanBuilder restrictions = new BooleanBuilder();

		if (!StringUtils.isEmpty(bookSearchCryteria.getAuthor())) {
			restrictions.and(bookEntity.authors.any().firstName.like(bookSearchCryteria.getAuthor() + "%")
					.or(bookEntity.authors.any().lastName.like(bookSearchCryteria.getAuthor() + "%")));
		}

		if (!StringUtils.isEmpty(bookSearchCryteria.getTitle())) {
			restrictions.and(bookEntity.title.like(bookSearchCryteria.getTitle() + "%"));
		}

		if (!StringUtils.isEmpty(bookSearchCryteria.getLibraryName())) {
			restrictions.and(bookEntity.library.name.like(bookSearchCryteria.getLibraryName() + "%"));
		}

		query.where(restrictions);
		return query.listResults(bookEntity).getResults();
	}

}
