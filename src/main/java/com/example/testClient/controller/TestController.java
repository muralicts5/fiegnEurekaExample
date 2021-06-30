package com.example.testClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.testClient.model.Employee;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/test")
public class TestController {


	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	
	@GetMapping
	public List<Employee> test() {
		/*RestTemplate restTemplate = new RestTemplate();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("EMPLOYEESERVICE", false);
				String url=instanceInfo.getHomePageUrl()+"/employees";
		ResponseEntity<List<Employee>> response=restTemplate.exchange(url, 
									HttpMethod.GET, null,  
									new ParameterizedTypeReference<List<Employee>>() {});
									
									EmployeeServiceClient employeeServiceClient = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(EmployeeServiceClient.class))
				  .target(EmployeeServiceClient.class, url);
		
		*/
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("EMPLOYEESERVICE", false);
		String url=instanceInfo.getHomePageUrl()+"/employees";
		System.out.println(url);
		return employeeServiceClient.findAll();
	}
	
}
