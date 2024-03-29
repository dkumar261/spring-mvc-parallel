package com.springpractice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.model.EmployeeAddress;
import com.springpractice.model.EmployeeAddresses;
import com.springpractice.model.EmployeeName;
import com.springpractice.model.EmployeeNames;
import com.springpractice.model.EmployeePhone;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@RestController
public class EmployeeDataController {

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public EmployeeAddresses getAddresses() throws InterruptedException {
		log.info("Employee addresses reached");

		EmployeeAddresses employeeAddressesList = new EmployeeAddresses();

		EmployeeAddress employeeAddress1 = new EmployeeAddress();
		EmployeeAddress employeeAddress2 = new EmployeeAddress();

		List<EmployeeAddress> addressList = new ArrayList<EmployeeAddress>();

		employeeAddress1.setHouseNo("1111");
		employeeAddress1.setStreetNo("111");
		employeeAddress1.setZipCode("111111");

		employeeAddress2.setHouseNo("222");
		employeeAddress2.setStreetNo("222");
		employeeAddress2.setZipCode("222222");

		addressList.add(employeeAddress1);
		addressList.add(employeeAddress2);

		employeeAddressesList.setEmployeeAddressList(addressList);
		System.out.println("Waiting for Address to complete");
		Thread.sleep(9000);
		Thread.sleep(9000);
		System.out.println("End of Address");
		return employeeAddressesList;
	}

	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public EmployeePhone getPhoneNumbers() throws InterruptedException {
		log.info("Employee Phones reached ");

		EmployeePhone employeePhone = new EmployeePhone();
		ArrayList<String> phoneNumberList = new ArrayList<String>();

		phoneNumberList.add("100000");
		phoneNumberList.add("200000");

		employeePhone.setPhoneNumbers(phoneNumberList);
		System.out.println("Waiting for phone to complete");
		Thread.sleep(9000);
		return employeePhone;
	}

	@RequestMapping(value = "/names", method = RequestMethod.GET)
	public EmployeeNames getEmployeeName() {
		log.info("Employee names Reached");

		EmployeeNames employeeNamesList = new EmployeeNames();

		EmployeeName employeeName1 = new EmployeeName();
		EmployeeName employeeName2 = new EmployeeName();

		List<EmployeeName> employeeList = new ArrayList<EmployeeName>();
		employeeName1.setFirstName("Santa");
		employeeName1.setLastName("Singh");
		employeeName2.setFirstName("Banta");
		employeeName2.setLastName("Singh");

		employeeList.add(employeeName1);
		employeeList.add(employeeName2);

		employeeNamesList.setEmployeeNameList(employeeList);

		return employeeNamesList;
	}
}
