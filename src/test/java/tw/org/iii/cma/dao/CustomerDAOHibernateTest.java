package tw.org.iii.cma.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.cma.domain.CustomerBean;

@SpringBootTest
public class CustomerDAOHibernateTest {
	@Autowired
	private CustomerDAO customerDao;
	
	@Test
	public void testSelect() {
		
		CustomerBean carol = customerDao.select("Carol");
		System.out.println("carol"+carol);
	}
	

}
