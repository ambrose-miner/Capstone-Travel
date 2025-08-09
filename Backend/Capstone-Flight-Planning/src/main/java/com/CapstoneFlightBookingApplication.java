package com;



import org.apache.http.client.CookieStore;//new
import org.apache.http.impl.client.BasicCookieStore;//new
import org.apache.http.impl.client.CloseableHttpClient;//new
import org.apache.http.impl.client.HttpClients;//new
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;//new
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.bean")	
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient

public class CapstoneFlightBookingApplication {
	@Configuration
	public class RestTemplateConfig {
	@Bean
	public CookieStore httpCookieStore() {
		return new BasicCookieStore();
	}
	@Bean
    public RestTemplate restTemplate(CookieStore cookieStore) {
		CloseableHttpClient httpClient = HttpClients.custom()
				.setDefaultCookieStore(cookieStore)
				.build();
	        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));// error on this line
	    }						//  ^The constructor HttpComponentsClientHttpRequestFactory(CloseableHttpClient) is undefined
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CapstoneFlightBookingApplication.class, args);
	}

}
