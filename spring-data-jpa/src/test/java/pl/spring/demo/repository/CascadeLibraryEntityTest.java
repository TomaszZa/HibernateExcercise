package pl.spring.demo.repository;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class CascadeLibraryEntityTest {

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void testIfDelitingLibraryMeanDelitingConnectedBooks() {

		libraryRepository.delete(1L);

		assertNull(bookRepository.findOne(1L));
		assertNull(bookRepository.findOne(2L));
		assertNull(bookRepository.findOne(3L));

	}
}
