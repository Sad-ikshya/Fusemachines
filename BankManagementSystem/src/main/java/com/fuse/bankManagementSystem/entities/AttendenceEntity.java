package com.fuse.bankManagementSystem.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document
@Builder
public class AttendenceEntity {
	@Id
	public String id;
	@DBRef
	public EmployeeEntity employee;
	public Date date;
	public boolean isPresent;

}
