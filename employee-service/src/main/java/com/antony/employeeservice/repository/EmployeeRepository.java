/**
 * 
 */
package com.antony.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.antony.employeeservice.dataobject.Employee;

/**
 * @author Antony John
 *
 */
@Repository
@Transactional
//@CrossOrigin(origins = "http://localhost:4200")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{	

}
