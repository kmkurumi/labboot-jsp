package tw.org.iii.cma.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.cma.domain.ProductBean;

@SpringBootTest
public class ProductDAOHibernateTest {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void testSelect() {
		ProductBean product = productDAO.select(5);
		System.out.println("product:"+product);
	}
	
}
