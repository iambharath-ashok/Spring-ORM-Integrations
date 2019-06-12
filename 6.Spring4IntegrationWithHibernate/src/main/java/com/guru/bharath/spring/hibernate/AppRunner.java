package com.guru.bharath.spring.hibernate;

import java.util.Random;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.guru.bharath.spring.hibernate.config.HibernateConfig;
import com.guru.bharath.spring.hibernate.model.Employee;
import com.guru.bharath.spring.hibernate.service.EmployeeService;

public class AppRunner {

	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfig.class);
		ac.start();
		EmployeeService es = ac.getBean(EmployeeService.class);
		
		Employee employee = new Employee();
		employee.setEmployeeName("Bharath The Great");
		employee.setJoiningDate(new LocalDate(2015,9,07));
		employee.setSalary(1800000);
		employee.setSsn("Bharath0897"+new Random().nextInt(30));
		es.saveEmployee(employee);
		
		Employee employee2 = new Employee();
		employee2.setEmployeeName("Emperor Bharath");
		employee2.setJoiningDate(new LocalDate(1990,9,13));
		employee2.setSalary(99800000);
		employee2.setSsn("Bharath786"+new Random().nextInt(50));
		es.saveEmployee(employee2);
		
		
		
		es.findAllEmployees().stream().forEach(System.out::println);
		
	}
}
