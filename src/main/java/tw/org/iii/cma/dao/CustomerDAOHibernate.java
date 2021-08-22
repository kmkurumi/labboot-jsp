package tw.org.iii.cma.dao;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.domain.CustomerBean;


@Repository
public class CustomerDAOHibernate implements CustomerDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}
	@Override
	public CustomerBean select(String custid) {
		if(custid!=null) {
			return this.getSession().get(CustomerBean.class, custid);
		}
		return null;
	}
	@Override
	public boolean update(byte[] password, String email, java.util.Date birth, String custid) {
		if(custid!=null) {
			CustomerBean bean = this.getSession().get(CustomerBean.class, custid);
			if(bean!=null) {
				bean.setPassword(password);
				bean.setEmail(email);
				bean.setBirth(birth);
				return true;
			}
		}
		return false;
	}
}
