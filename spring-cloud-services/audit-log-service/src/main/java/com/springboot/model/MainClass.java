package com.springboot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {

	public class Student {

	}

	public static void main(String[] args) {
		List<AuditLog> student = new ArrayList<>();
		Collections.sort(student, new Comparator<AuditLog>() {

			@Override
			public int compare(AuditLog o1, AuditLog o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		student.sort((s1, s2) -> s1.getEndDate().compareTo(s2.getEndDate()));
		student.stream().forEach(c -> System.out.println(c));
	}

}
