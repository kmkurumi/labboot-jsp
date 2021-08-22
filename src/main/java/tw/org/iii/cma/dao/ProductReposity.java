package tw.org.iii.cma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.org.iii.cma.domain.ProductBean;
//繼承JpaRepository，介面可以得到新修刪查
public interface ProductReposity extends JpaRepository<ProductBean, Integer>{
	
	

}
