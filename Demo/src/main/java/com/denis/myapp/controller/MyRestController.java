package com.denis.myapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.denis.myapp.entity.Student;
import com.denis.myapp.service.StudentService;

@RestController
public class MyRestController {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	protected StudentService studentService;
	
	@ResponseBody
	@RequestMapping(value = { "/students" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Student>> getStudents() {
		log.info("getStudents(): Called...");

		List<Student> students = null;
		try {
			students = this.studentService.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (students == null || students.isEmpty()) {
			log.info("getStudents(): returned a null or empty list."); 
			ResponseEntity<List<Student>> rVal = new ResponseEntity<List<Student>>(students, HttpStatus.NO_CONTENT);
			return rVal;
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

}
