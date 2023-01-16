package com.example.jpa;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@EnableDiscoveryClient

public class ClientController {	
	
	RestTemplate restTemplate = new RestTemplate();
	@Autowired
	DiscoveryClient discoveryClient;

 	
	
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Customer> getCustomers() {		
		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
 		URI uri = service.getUri();
		ResponseEntity<Customer[]> response = restTemplate.getForEntity(uri+"/customers", Customer[].class);
		return Arrays.asList(response.getBody());
	}
	
	@RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Book> getBooks() {		
		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
 		URI uri = service.getUri();
		ResponseEntity<Book[]> response = restTemplate.getForEntity(uri+"/books", Book[].class);
		return Arrays.asList(response.getBody());
	}
	
	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Transaction> getTransactions() {		
		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
 		URI uri = service.getUri();
		ResponseEntity<Transaction[]> response = restTemplate.getForEntity(uri+"/transactions", Transaction[].class);
		return Arrays.asList(response.getBody());
	}
	
	@RequestMapping(value = "/getBooksAvailable", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Book> getBooksAvailable() {		
		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
 		URI uri = service.getUri();
		ResponseEntity<Book[]> response = restTemplate.getForEntity(uri+"/booksAvailable", Book[].class);
		return Arrays.asList(response.getBody());
	}
	
	@RequestMapping(value = "/getBooksLentOut", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<Book> getBooksLentOut() {		
		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
 		URI uri = service.getUri();
		ResponseEntity<Book[]> response = restTemplate.getForEntity(uri+"/booksLentOut", Book[].class);
		return Arrays.asList(response.getBody());
	}
	
	
//	//
//	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
//	public ResponseEntity<String>addBook(@Valid Book book, BindingResult result, Model model) {		
//		
//		ServiceInstance service = discoveryClient.getInstances("SELECT-CUSTOMER-SERVICE").get(0);
// 		URI uri = service.getUri();
// 		
// 		
// 		
//		ResponseEntity<String> response = restTemplate.postForEntity(uri+"/booksLentOut", book);
//		return ResponseEntity.ok("Book successfully registered");
//	}
	
	
	
	
}
