package tw.org.iii.cma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.dao.ProductReposity;
import tw.org.iii.cma.domain.ProductBean;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductReposity productReposity;
	
	@Transactional(readOnly = true)
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		if(bean!=null && bean.getId()!=null && !bean.getId().equals(0)) {
			Optional<ProductBean> temp = productReposity.findById(bean.getId());
			//資料存在
			if(temp.isPresent()) {
				result = new ArrayList<ProductBean>();
				result.add(temp.get());
			}
		} else {
			result = productReposity.findAll();
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) {
		if(bean!=null && bean.getId()!=null) {
			return productReposity.save(bean);
		}
		return null;
	}
	public ProductBean update(ProductBean bean) {
		if(bean!=null && bean.getId()!=null) {
			Optional<ProductBean> temp = productReposity.findById(bean.getId());
			if(temp.isPresent()) {
				return productReposity.save(bean);
			}					
		}
		return null;
	}
	public boolean delete(ProductBean bean) {;
		if(bean!=null && bean.getId()!=null) {
			Optional<ProductBean> temp = productReposity.findById(bean.getId());
			if(temp.isPresent()) {
				productReposity.delete(temp.get());
				return true;
			}				
		}						
		return false;
	}
}
