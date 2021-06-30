package com.fuse.utilityApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuse.utilityApi.dtos.MathFunctionDto;
import com.fuse.utilityApi.services.MathFunctionUtility;

@RestController
@RequestMapping("/mathFunctions")
public class MathFunctionController {
	@Autowired
	MathFunctionUtility mathFunction;
	
	@PostMapping("/add")
	public ResponseEntity<Integer> add(@RequestBody MathFunctionDto input){
		return new ResponseEntity<Integer>(mathFunction.add(input.getNum1(), input.getNum2()),HttpStatus.OK);
	}
@PostMapping("/substract")
public ResponseEntity<Integer> substract(@RequestBody MathFunctionDto input){
	return new ResponseEntity<Integer>(mathFunction.substract(input.getNum1(), input.getNum2()), HttpStatus.OK);
	
}
@PostMapping("/multiply")
public ResponseEntity<Integer> multiply(@RequestBody MathFunctionDto input){
	return new ResponseEntity<Integer>(mathFunction.multiply(input.getNum1(), input.getNum2()), HttpStatus.OK);
	
}
@PostMapping("/divide")
public ResponseEntity<Integer> divide(@RequestBody MathFunctionDto input){
	return new ResponseEntity<Integer>(mathFunction.divide(input.getNum1(), input.getNum2()), HttpStatus.OK);
	
}
@PostMapping("/squareRoot")
public ResponseEntity<Double> squareRoot(@RequestBody MathFunctionDto input){
	return new ResponseEntity<Double>(mathFunction.squareRoot(input.getNum()),HttpStatus.OK);
}

}
