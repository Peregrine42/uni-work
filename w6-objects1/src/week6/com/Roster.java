package week6.com;

import java.util.ArrayList;

class Roster {
	ArrayList<Employee> employees;
	
	Roster(ArrayList<Employee> e) {
		employees = e;
	}
	
	public String getName(String id) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				return employee.first_name + " " + employee.surname;
			}
		}
		
		return "not found";
	}
	
	public String getJobTitle(String id) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				return employee.job_title;
			}
		}
		
		return "not found";
	}
	
	public String getID(String surname) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.surname.equals(surname)) {
				return employee.id;
			}
		}
		
		return "not found";
	}
	
	public void setJobTitle(String id, String jobTitle) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.id.equals(id)) {
				employee.job_title = jobTitle;
			}
		}
	}
}