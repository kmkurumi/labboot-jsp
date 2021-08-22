package tw.org.iii.cma.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.domain.ProductBean;

@Repository
public class ProductDAOHibernate implements ProductDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}
	@Override
	public ProductBean select(Integer id) {
		if(id!=null) {
			return this.getSession().get(ProductBean.class, id);
		}
		return null;
	}
	@Override
	public List<ProductBean> select() {
		return this.getSession().createQuery(
				"from ProductBean", ProductBean.class).list();
	}
	@Override
	public ProductBean insert(ProductBean bean) {
		if(bean!=null && bean.getId()!=null) {
			ProductBean temp =
					this.getSession().get(ProductBean.class, bean.getId());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	@Override
	public ProductBean update(String name, Double price,
			java.util.Date make, Integer expire, Integer id) {
		if(id!=null) {
			ProductBean bean = this.getSession().get(ProductBean.class, id);
			if(bean!=null) {
				bean.setName(name);
				bean.setPrice(price);
				bean.setMake(make);
				bean.setExpire(expire);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			ProductBean bean = this.getSession().get(ProductBean.class, id);
			if(bean!=null) {
				this.getSession().delete(bean);
				return true;
			}
		}
		return false;
	}
}
