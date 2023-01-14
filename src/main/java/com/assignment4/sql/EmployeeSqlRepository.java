package com.assignment4.sql;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment4.model.Employee;

@Repository

public interface EmployeeSqlRepository extends CrudRepository<Employee, Long>{

}
