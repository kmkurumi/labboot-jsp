package tw.org.iii.cma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//測試程式
@SpringBootTest
public class DatabaseTests {
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		Session session = sessionFactory.openSession();
	    Transaction transaction = session.beginTransaction();
	    
	    List result = session.createNativeQuery("select * from customer").list();
	    for (Object obj : result) {
	        Object[] array = (Object[]) obj;
	        System.out.println(array[0] + ":" + array[2] + ":" + array[3]);
    }
    
    transaction.commit();
    session.close();
	}

    
	@Test
	public void testDataSource() throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from product");
		ResultSet rset = stmt.executeQuery();
		while(rset.next()) {
			int id = rset.getInt("id");
			String name = rset.getString("name");
			System.out.println(id+":"+name);
		}
		rset.close();
		stmt.close();
		conn.close();
	}
}
