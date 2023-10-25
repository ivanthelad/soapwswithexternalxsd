package com.example.producingwebservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

import java.net.MalformedURLException;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "wsdl")
	public SimpleWsdl11Definition defaultWsdl11Definition() {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();


		wsdl11Definition.setPortTypeName("CountriesPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		//wsdl11Definition.setSchema(countriesSchema);
	//	wsdl11Definition.setSchema(countriesSchema());
		wsdl11Definition.setLocationUri("");

		SimpleWsdl11Definition t = new SimpleWsdl11Definition();
		t.setWsdl(new ClassPathResource("/example.wsdl"));

		return t;
	}

	//@Bean
	public SimpleXsdSchema countriesSchema() {
	//	return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
		try {
			return new SimpleXsdSchema(new UrlResource(	"https://xsdhostingdemo2.blob.core.windows.net/xsd/countries.xsd"));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}
}
