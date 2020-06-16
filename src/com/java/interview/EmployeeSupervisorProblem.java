package com.java.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeSupervisorProblem {
	
	static Map<Integer, String> employeeDetails;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EmployeeSupervisor> employeeSupervisors = new ArrayList<>();
		employeeSupervisors.add(new EmployeeSupervisor("Sparsh", 1, 0));
		employeeSupervisors.add(new EmployeeSupervisor("Amit", 2, 1));
		employeeSupervisors.add(new EmployeeSupervisor("Sachin", 3, 4));
		employeeSupervisors.add(new EmployeeSupervisor("Kunal", 4, 1));
		employeeSupervisors.add(new EmployeeSupervisor("Rakesh", 5, 1));
		employeeSupervisors.add(new EmployeeSupervisor("Manish", 6, 10));
		
		employeeDetails = new HashMap<>();
		Set<Integer> supervisorIdSet = new HashSet<>();
		for (EmployeeSupervisor empSuprvisr : employeeSupervisors) {
			if (empSuprvisr != null) {
				if(!employeeDetails.containsKey(empSuprvisr.getEmployeeId()))				
					employeeDetails.put(empSuprvisr.getEmployeeId(), empSuprvisr.getEmployeeName());
				
				supervisorIdSet.add(empSuprvisr.getSupervisorId());
			}
		}
		
		//This is to handle any remainig supervisor or special case 0
		Set<Integer> employeeIdSet = employeeDetails.keySet();
		for(Integer supId : supervisorIdSet) {
			if(!employeeIdSet.contains(supId)) {
				String supName = supId == 0 ? "Ultimate Boss" : "No Supervisor details available";
				employeeDetails.put(supId, supName);
			}
		}
		
		printResult(employeeSupervisors);
	}
	
	//Output: Employee Name, Supervisor Name
	//Sample : Sparsh, Ultimate Boss(0 is as supervisor id)
	//		   Amit, Sparsh
	// 		   Sachin, Kunal
	//		   Kunal, Sparsh
	//		   Rakesh, Sparsh
	//		   Manish, No Supervisor details available
	private static void printResult(List<EmployeeSupervisor> employeeSupervisors) {
		for(EmployeeSupervisor empSuprvisr : employeeSupervisors) 
				System.out.println(employeeDetails.get(empSuprvisr.getEmployeeId()) + ", " + employeeDetails.get(empSuprvisr.getSupervisorId()));
	}
}

class EmployeeSupervisor {
	private String employeeName;
	private int employeeId;
	private int supervisorId;
	
	public EmployeeSupervisor(String employeeName, int employeeId, int supervisorId) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.supervisorId = supervisorId;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
}