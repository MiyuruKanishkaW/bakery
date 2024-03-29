package com.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.servlet.Filter;

@SpringBootApplication(exclude={SolrAutoConfiguration.class})
//@EnableAutoConfiguration
@EnableSwagger2
public class BakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}
	@Bean
	public Filter filter(){
		ShallowEtagHeaderFilter filter=new ShallowEtagHeaderFilter();
		return filter;
	}
}