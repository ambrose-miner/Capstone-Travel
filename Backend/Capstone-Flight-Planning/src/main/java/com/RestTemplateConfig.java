package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new
				InetSocketAddress("proxy.Capstone-Server.local",8761));
				factory.setProxy(proxy);
		System.out.println("************Made Rest Template");
		return new RestTemplate(factory);
		// Trying to have the a user's requests 
		//have the same headers created by global headers this header would Identify them...global would be to their run time environment correct?
//		//if that is not the case than I don't want to make these headers global.
		
//		restTemplate.setInterceptors(List.of(new ClientHttpRequestInterceptor() {//neither use of list allows this to work...?
//			@Override
//			public ClientHttpResponse
//			intercept(HttpRequest request, byte[] body, Execution execution)//Not sure what this code is trying to do here specifically."Execution"
//									throws IOException {					//"byte[]"
//				request.getHeaders().set("User-Agent", "userid");
//				
//				return execution.execute(request, body);
//			}
//		}));
//				return restTemplate();
	}

}
//This code would not need to be duplicated in Login micro service because the login micro service doesn't need to look at the headers.
//I gets a direct response from User Service...or do I need to generate their header name tag first so that when I put things in the session it can be pulled
//out by association with their headers?

//This dependency gets flagged and returns "Overriding managed version 5.3.4 for httpcore5"
//Is this saying that this dependency is already covered in some way by springboot maybe?
//<dependency>
//	 <groupId>org.apache.httpcomponents.core5</groupId>
//	 <artifactId>httpcore5</artifactId>
//	 <version>5.2.1</version>
//</dependency>