package com.guru.bharath.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.guru.bharath.spring.hibernate.model.Employee;

@Repository
public class EmployeeImpl extends AbstractDao<Employee, Long> implements EmployeeDao {

	@Override
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = this.getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	public Employee findEmployeeById(Long id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public Employee updateEmployee(Employee employee) {
		return update(employee);
	}

	public void deleteEmployee(Employee employee) {
		delete(employee);
	}

	public int deleteEmployeeById(Long id) {
		String deleteQuery = "DELETE FROM Employee e WEHRE e.id=:id";
		Query query = getSession().createQuery(deleteQuery);
		int employeesDeleted = query.executeUpdate();
		return employeesDeleted;
	}


	@Override
	public Long saveEmployee(Employee employee) {
		return save(employee);
	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		String deleteQuery = "DELETE FROM Employee e WEHRE e.ssn=:ssn";
		Query query = getSession().createQuery(deleteQuery);
		query.executeUpdate();
	}
}
