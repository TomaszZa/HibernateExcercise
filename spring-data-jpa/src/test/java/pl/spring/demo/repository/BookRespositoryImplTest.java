package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.service.impl.BookSearchCryteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryImplTest-context.xml")
public class BookRespositoryImplTest {
	@Autowired
	MyBookRepository bookRepository;

	@Test
	public void testFindBookByOnlyTitle() {
		BookSearchCryteria bookSearchCryteria = new BookSearchCryteria("D", "", "");
		List<BookEntity> books = bookRepository.findBooksByAllCryteria(bookSearchCryteria);
		assertEquals(true, books.size() > 0);
		assertEquals("Druga książka", books.get(0).getTitle());
	}

	@Test
	public void testFindBookByOnlyAuthorFirstName() {
		BookSearchCryteria bookSearchCryteria = new BookSearchCryteria("", "Z", "");
		List<BookEntity> books = bookRepository.findBooksByAllCryteria(bookSearchCryteria);
		assertEquals(true, books.size() > 0);
		assertEquals("Zbigniew", books.get(0).getAuthors().get(0).getFirstName());
	}

	@Test
	public void testFindBookByOnlyAuthorLastName() {
		BookSearchCryteria bookSearchCryteria = new BookSearchCryteria("", "N", "");
		List<BookEntity> books = bookRepository.findBooksByAllCryteria(bookSearchCryteria);
		assertEquals(true, books.size() > 0);
		assertEquals("Nowak", books.get(0).getAuthors().get(0).getLastName());
	}

	@Test
	public void testFindBookByOnlyLibraryName() {
		BookSearchCryteria bookSearchCryteria = new BookSearchCryteria("", "", "Biblioteka1");
		List<BookEntity> books = bookRepository.findBooksByAllCryteria(bookSearchCryteria);
		assertEquals(true, books.size() > 0);
		assertEquals("Biblioteka1", books.get(0).getLibrary().getName());
	}

	@Test
	public void testFindAllBooksWithNoCryteria() {
		BookSearchCryteria bookSearchCryteria = new BookSearchCryteria("", "", "");
		List<BookEntity> books = bookRepository.findBooksByAllCryteria(bookSearchCryteria);
		assertEquals(true, books.size() == 3);
	}

}
