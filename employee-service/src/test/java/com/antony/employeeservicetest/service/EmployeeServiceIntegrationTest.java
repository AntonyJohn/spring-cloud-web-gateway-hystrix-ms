/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antony.employeeservicetest.service;

import com.antony.employeeservice.LogInjector;
import com.antony.employeeservice.dataobject.Employee;
import com.antony.employeeservice.repository.EmployeeRepository;
import com.antony.employeeservice.service.EmployeeService;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *
 * @author Antony John
 */

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceIntegrationTest {

	@Mock
	private EmployeeRepository employeeRepositoryMock;

	@InjectMocks
	EmployeeService employeeService;

	/**
	 * setupFactory method used to inject @LOG on EmployeeController class 
	 * to avoid null pointer exception
	 */
	@Before
	public void setupFactory() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		factory.addBeanPostProcessor(new LogInjector());
		factory.applyBeanPostProcessorsBeforeInitialization(employeeService, "employeeService");
	}
	
	@Test
	public void testRetrieveEmployee() {
		Employee antony = new Employee();
		antony.setId(1);
		antony.setFirstName("antony");
		Mockito.when(employeeRepositoryMock.findById(antony.getId())).thenReturn(Optional.of(antony));
		Employee emp = (Employee) employeeService.retrieveEmployee("1").getResponseValue();
		assertEquals(antony.getFirstName(), emp.getFirstName());
	}

	@Test
	public void testRetrieveAllEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		Employee antony = new Employee();
		antony.setId(1);
		antony.setFirstName("antony");
		empList.add(antony);
		Employee john = new Employee();
		antony.setId(2);
		antony.setFirstName("john");
		empList.add(john);

		Mockito.when(employeeRepositoryMock.findAll()).thenReturn(empList);
		List<Employee> emp = (List<Employee>) employeeService.retrieveAllEmployee().getResponseValue();
		assertEquals(empList.get(0).getFirstName(), emp.get(0).getFirstName());
	}
}
