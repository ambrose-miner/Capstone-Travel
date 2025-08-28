package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bean.Login;
import com.bean.User;
//import com.bean.User;
import com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	@Autowired
	RestTemplate restTemplate;
	
//	public Login
//	sendUserInfo(Login login){
//		String url = "http://localhost:8282/Capstone-Flight-Planning";
//		Login currentUser = restTemplate.postForObject(url, login, Login.class);// does this need to be embedded in a way inside the sign in
//		return currentUser;										//method so that it is only trying to send the User object after it has it?
//	}
//	public String signIn(Login login) {		
//		Optional<Login> result = loginRepository.findById(login.getPassword());//This will no longer match up with the front end. User vs Login
//		if(result.isPresent()) {											
//							
//			Login ll = result.get();			// ll hold email, password and typeofuser from db.
//												// will be taking email and password and getting userid and typeofuser from db.
//					if(ll.getPassword().equals(login.getPassword())) {
//						
//							if(ll.getLogintype().equals(login.getUsertype()) && login.getUsertype().equals("admin")) {
//								return "Admin login";
//							}else if(ll.getLogintype().equals(login.getUsertype()) && login.getUsertype().equals("customer")) {
//								return "You have loged in successfully";
//							}else {
//								return "You can not log in as Admin";
//							}
//						
//					}else {
//						return "Wrong email or password P";
//					}
//		}else {
//			
//			return "Wrong email or password E";
//		}
//	}
		//The below four lines removed from sign in method to simplify and stream line.
			//if(currentUser.getUsertype().equals("admin");
			//		return "admin home link";
			//	if{(currentUser.getUsertype().equals("customer");
			//		return "customer home link";
	
	//New attempt at cleaning up and combining above methods no need for checking user type here.
	//will need to return user or admin page on the front end currentUser object will have that in it.
	
//	public String signIn(User user) {			//This needs to be changed back to Login. create login class...?		
//		Optional<User> varifyingUser = loginRepository.findById(user.getUserid());
//		User currentUser = varifyingUser.get();
//		if(varifyingUser.isPresent()) {
//			String url = "http://localhost:8282/Capstone-Flight-Planning";
//			User currentUser = restTemplate.postForObject(url, user, User.class);//currentUser is flagged as duplicate local variable.
//				if(currentUser.getPassword().equals(user.getPassword()) && currentUser.getEmail().equals(user.getEmail())) {
//				}else {
//	
//						return "Wrong email or password";
//				}
//		}
//	}
	
	//Attempt to reform the above method around a login object and compairing login properties to user then get userid
	//http://localhost:8282/user/{password}/{email}
	public String signIn(Login login){
		String url1 = "http://localhost:8282/user/userVerification/{password}/{email}";
		User verifyingUser = restTemplate.postForObject(url1, login, User.class);
		Optional<User> optionalVerifyingUser = Optional.ofNullable(verifyingUser);
		
		if(optionalVerifyingUser.isPresent()) {
			
			return "Login sucessful";
		}else {
			return "Wrong email or password";
					
		}
		//error return. Double nullable logic? url path?
		//org.springframework.web.client.HttpClientErrorException$NotFound: 404  on POST request for "http://localhost:8181/Capstone-login/signIn": "{"timestamp":"2025-08-28T16:34:18.625+00:00","status":404,"error":"Not Found","trace":"org.springframework.web.servlet.resource.NoResourceFoundException: No static resource Capstone-login/signIn.\r\n\tat org.springframework.web.servlet.resource.ResourceHttpRequestHandler.handleRequest(ResourceHttpRequestHandler.java:585)\r\n\tat org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter.handle(HttpRequestHandlerAdapter.java:52)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)\r\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\r\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\r\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\r\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:116)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:398)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:903)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1769)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1189)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:658)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\r\n\tat java.base/java.lang.Thread.run(Thread.java:842)\r\n","message":"No static resource Capstone-login/signIn.","path":"/Capstone-login/signIn"}"
		
	}
	
		//String url2 = "http://localhost:8282/user";
		//Optional<Long> varifyingUser = restTemplate.getForObject(url2, User.class);
		//String url3= "http://localhost:8282/Capstone-Flight-Planning";
		//Login currentUser = restTemplate.postForObject(url3, login, Login.class);
		//public Optional<Long> getUser(String password , String email){
		//login.getPassword(), login.getEmail())


	

	public String signUp(Login login) { 
		Optional<Login> result = loginRepository.findById(login.getPassword());
		if(result.isPresent()) {
				return "That account already exists";
		}else {
			//if(user.getUsertype().equals("admin")) {
				//return "You can't create admin account";
			//}else {
			loginRepository.save(login);
			return "Account created successfully";
			}
		}
	}