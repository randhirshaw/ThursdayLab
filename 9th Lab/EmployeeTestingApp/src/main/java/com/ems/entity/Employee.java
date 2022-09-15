package com.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	private long empId;
	private String empName;
	private double empSal;
//If a class have an entity reference, it is known as Aggregation 
	Address a;  //Aggregation represents HAS-A relationship.
}
