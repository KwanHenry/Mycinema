package dao.impl.test;

import org.junit.Test;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import entity.Category;

public class CategoryDaoImplTest {

	CategoryDao cate = new CategoryDaoImpl();
	
	public void testAddCatrgory() {  
		cate.addCatrgory("科幻");
	}
	
	@Test
	public void testUpdate() {
		Category c = new Category(1,"动漫");
		cate.update(c);
	}

	@Test
	public void testDelete() {
		cate.delete(1);
	}

	@Test
	public void testFetchById() {
		Category c = cate.fetchById(1);
		System.out.println(c.getName());
	}

	@Test
	public void testGetAll() {
		for (Category c : cate.getAll()) {
			System.out.println(c.getId() + "\t" + c.getName());
		}
	}

}
