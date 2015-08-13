package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {
	@Autowired
	LibraryRepository libraryRepository;

	@Test
	public void testShouldFindLibraryByName() {
		// given
		final String libraryName = "b";
		// when
		List<LibraryEntity> librarysEntity = libraryRepository.findLibraryByName(libraryName);
		// then
		assertNotNull(librarysEntity);
		assertFalse(librarysEntity.isEmpty());
		assertEquals("Biblioteka1", librarysEntity.get(0).getName());
	}
}
