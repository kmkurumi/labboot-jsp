package tw.org.iii.cma.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import tw.org.iii.cma.domain.ProductBean;
import tw.org.iii.cma.service.ProductService;
//Controller + Re
@RestController
@RequestMapping(path = {"/open/api"})
public class ProductRestController {
	private static final String SITE = "http://localhost:8081/labboot/"; 
	@Autowired
	private ProductService productService;
	//select one
	//select all
	//insert
	//update
	//delete
	//Accept:application/json

//處理HTTP Request
	//path用value代替，只有一個省略
	@GetMapping("/products")
	public ResponseEntity<List<ProductBean>> selectAll() {
		List<ProductBean> beans = productService.select(null);
		ResponseEntity<List<ProductBean>> respones = 
				new ResponseEntity<List<ProductBean>>(beans,HttpStatus.OK);
		return respones;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> selectOne(@PathVariable("id") Integer id) {
		ProductBean param = new ProductBean();
		param.setId(id);
		List<ProductBean> result = productService.select(param);
		if(result!=null &&!result.isEmpty()) {
			ProductBean bean = result.get(0);
			ResponseEntity<ProductBean> entity = ResponseEntity.ok(bean);
			return entity;		
		}else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;	
		}
	}
	//insert
	@PostMapping("/products/")
	public ResponseEntity<?> insert(@RequestBody ProductBean bean){
		System.out.println("insert");
		ProductBean result = productService.insert(bean);
		if(result!=null) {
			Integer id = result.getId();
			URI uri =URI.create(SITE+"/open/api/product"+id);
			return ResponseEntity.created(uri).body(result);
		}else {
			return ResponseEntity.noContent().build();
		}	
	}
	//成功204 (No content)
	//失敗404
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		ProductBean param = new ProductBean();
		param.setId(id);
		boolean result = productService.delete(param);
		if(result) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?>  update(@PathVariable("id") Integer id,@RequestBody ProductBean bean) {
		ProductBean result = productService.update(bean);
		if(result!=null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}	
}
