package com.fuse.bankManagementSystem.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class AttendenceDto {

	public String id;
	public EmployeeDto employee;
	public Date date;
	public boolean isPresent;

}
