package tw.org.iii.cma;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
//	<mvc:interceptors>
//	    <bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
//	        <property name="paramName" value="lang"></property>
//	    </bean>
//	</mvc:interceptors>
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		//login的lang
		interceptor.setParamName("lang");
		registry.addInterceptor(interceptor);
	}
	
	
//	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
//	    <property name="defaultLocale" value="zh_TW"></property>
//	    <property name="cookieMaxAge" value="86400"></property>
//	    <property name="cookieName" value="langCookie"></property>
//    </bean>
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.TAIWAN);
		resolver.setCookieMaxAge(86400);
		resolver.setCookieName("langCookie");
		return resolver;
	}



}
