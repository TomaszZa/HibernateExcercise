package pl.spring.demo.dao;

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
@ContextConfiguration(locations = "CommonDaoLibreryTest-context.xml")
public class LibraryDaoImplTest {
	@Autowired
	LibraryDao libraryDao;

	@Test
	public void testShouldFindLibreryByName() {
		// given
		final String libraryName = "b";
		// when
		List<LibraryEntity> librarysEntity = libraryDao.findLibraryByName(libraryName);
		// then
		assertNotNull(librarysEntity);
		assertFalse(librarysEntity.isEmpty());
		assertEquals("Biblioteka1", librarysEntity.get(0).getName());
	}
}
