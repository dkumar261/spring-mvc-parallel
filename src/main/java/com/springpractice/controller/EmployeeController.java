package com.springpractice.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.model.EmployeeAddresses;
import com.springpractice.model.EmployeePhone;
import com.springpractice.model.EmployeeResponse;
import com.springpractice.service.EmployeeService;

@RestController
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public EmployeeResponse getEmployee() throws InterruptedException, ExecutionException {

		log.info("employeeAddress Start");
		CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
		log.info("employeePhone Start");
		CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
//		log.info("employeeName Start");
//		CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();

		// Wait until they are all done
		try {
			CompletableFuture.allOf(employeeAddress, employeePhone).get(10, TimeUnit.SECONDS);
		}

		catch (TimeoutException e) {
			System.out.println("Timeout exception is occured !!!!!");
		}

		EmployeeAddresses employeeAddresses = employeeAddress.get();

		EmployeePhone employeePhoneRes = employeePhone.get();

		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployeeAddresses(employeeAddresses);

		return employeeResponse;
	}
}
