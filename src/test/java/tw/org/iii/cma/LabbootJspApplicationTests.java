package tw.org.iii.cma;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;

@SpringBootTest
class LabbootJspApplicationTests {
	@Test
	void contextLoads() {
	}
	
	@Value("${login.fail.times}")
	private String failTiems;
	
	@Autowired
	private Environment env;
	
//	@Test
	public void testCustomKeys() {
		System.out.println("failTiems="+failTiems);
		
		String lockMinute = env.getProperty("login.fail.lock.minute");
		System.out.println("lockMinute="+lockMinute);
	}

	@Autowired
	private MessageSource messageSource;
	
//	@Test
	public void testMessageSource() {
		String error1 = messageSource.getMessage("login.username.required", null, Locale.TAIWAN);
		System.out.println("error1="+error1);
	}
}
