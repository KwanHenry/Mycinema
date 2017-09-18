package dao.impl.test;

import org.junit.Test;

import dao.impl.UserDaoImpl;
import entity.User;

public class UserDaoImplTest {
	private UserDaoImpl user = new UserDaoImpl();

	@Test
	public void testLogin() {
		User ur= user.login("bobo", "123");
		if(ur != null) {
			System.out.println("登陆成功！");
		}else {
			System.out.println("登陆失败！");
		}
	}

	@Test
	public void testFetchByUsername() {
		User u = user.fetchByUsername("bobo");
		System.out.println(u.getName());
	}

}
