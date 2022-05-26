package com.springpractice.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springpractice.model.EmployeeAddresses;
import com.springpractice.model.EmployeeNames;
import com.springpractice.model.EmployeePhone;

@Service
public class EmployeeService {

	private static Logger log = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private RestTemplate restTemplate;

	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> {
			log.info("EmployeeName Rest Api call Starts");
			EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8001/names",
					EmployeeNames.class);

			log.info("EmployeeName Rest Api call completed, {}", employeeNameData);
			return employeeNameData;
		});
	}

	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> {

			log.info("EmployeeAddress Rest Api call Starts");
			EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8001/address",
					EmployeeAddresses.class);
			log.info("EmployeeAddress Rest Api call completed, {}", employeeAddressData);
			return employeeAddressData;
		});
	}

	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> {
			log.info("EmployeePhone Rest Api call Starts");
			EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8001/phones",
					EmployeePhone.class);

			log.info("EmployeePhone Rest Api call completed, {}", employeePhoneData);
			return employeePhoneData;
		});
	}

}
