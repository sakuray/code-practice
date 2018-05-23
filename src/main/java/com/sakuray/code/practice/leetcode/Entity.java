package com.sakuray.code.practice.leetcode;

import java.util.List;

/**
 * 实体类
 */
public class Entity {

	public static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
		public Employee(int id, int importance) {
			this.id = id;
			this.importance = importance;
		}
	}
}
