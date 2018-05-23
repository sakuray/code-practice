package com.sakuray.code.practice.leetcode._600_699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sakuray.code.practice.leetcode.Entity.Employee;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, 
 * his importance value and his direct subordinates' id.
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
 * They have importance value 15, 10 and 5, respectively. 
 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], 
 * and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1,
 * the relationship is not direct.
 * 
 * Now given the employee information of a company, and an employee id, 
 * you need to return the total importance value of this employee and all his subordinates.
 * 
 * Example 1:
 * 	Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
	Output: 11
   Explanation:
	Employee 1 has importance value 5, and he has two direct subordinates: 
	employee 2 and employee 3. They both have importance value 3. 
	So the total importance value of employee 1 is 5 + 3 + 3 = 11.
Note:
	One employee has at most one direct leader and may have several subordinates.
	The maximum number of employees won't exceed 2000.
 */
public class _690_EmployeeImportance {

	public static void main(String[] args) {
		Employee l1 = new Employee(1, 5);
		Employee l2 = new Employee(2, 3);
		Employee l3 = new Employee(3, 3);
		List<Integer> list = new ArrayList<>();
		list.add(2); list.add(3);
		l1.subordinates = list;
		List<Employee> q = new ArrayList<>();
		q.add(l1); q.add(l2); q.add(l3);
		System.out.println(getImportance(q, 1));
	}
	
	public static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> em = new HashMap<>();
		Employee cur;
		for(int i = 0; i < employees.size(); i++) {
			cur = employees.get(i);
			em.put(cur.id, cur);
		}
		return calc(em, id);
    }
	
	public static int calc(Map<Integer, Employee> employees, int id) {
		Employee cur = employees.get(id);
		if(cur == null) return 0;
		int importance = cur.importance;
		List<Integer> list = cur.subordinates;
		if(list == null || list.isEmpty()) return importance;
		for(int i = 0; i < list.size(); i++) {
			importance += calc(employees, list.get(i));
		}
		return importance;
	}
	
	Employee[] mapping = new Employee[2000 + 1];
    public int getImportance_S(List<Employee> employees, int id) {
        for (Employee e : employees) {
            mapping[e.id] = e;
        }
        
        Employee target = mapping[id];
        return helper(target);
    }
    
    private int helper(Employee cur) {
        int imp = 0;
        if (cur != null) {
            imp += cur.importance;      
        
            for(Integer sub : cur.subordinates) {
                imp += helper(mapping[sub]);
            }
        }
        
        return imp;
    }
}
