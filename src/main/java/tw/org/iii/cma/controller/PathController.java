package tw.org.iii.cma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PathController {
	@GetMapping("/")
	public String method1() {
		return "/index";
	}
	
	@GetMapping("/secure/login.page")
	public String method2() {
		return "/secure/login";
	}
	
	@GetMapping("/pages/product.page")
	public String method3() {
		return "/pages/product";
	}
	
	@GetMapping("/pages/display.page")
	public String method4() {
		return "/pages/display";
	}
}
