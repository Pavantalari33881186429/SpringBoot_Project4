package com.assignment4;

import java.util.ArrayList;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment4.model.Employee;
import com.assignment4.sql.EmployeeSqlRepository;





@RestController()

public class EmployeeController {
	
	@Autowired
	EmployeeSqlRepository emprep;
        
	@PostMapping("/saveEmployee") 	
        public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		Employee e1=new Employee(employee.getId(),employee.getName(),employee.getEmail(),employee.getLocation());
		//Employee e1= new Employee(Long.parseLong((String) m.getAttribute("id")), m.getAttribute("name").toString(), m.getAttribute("email").toString(),m.getAttribute("location").toString() );
        emprep.save(e1);
        
        if(!e1.equals("null")) {
        	return "</h1>Registration Successful</h1>";
        }
		return "<h1>Registration Unsuccessful</h1>";
        }
		
	   @GetMapping("/displayAll")
	   public List<Employee> getAllEmployees(){
	      List<Employee> employees =  new ArrayList<Employee>();
      emprep.findAll().forEach(employee -> employees.add(employee));
      
	      return employees;
   }
		
		@GetMapping("/displayAll/{id}")
		public Employee getEmployeeById(@PathVariable("id") long id) {
		      return emprep.findById(id).get();
		   }

	}


