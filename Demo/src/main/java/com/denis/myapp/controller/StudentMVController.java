package com.denis.myapp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.denis.myapp.service.StudentService;

@Controller
public class StudentMVController {
	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	protected StudentService studentService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentForm( Locale locale, Model model ){
		log.debug("studentForm() called...");
		return "studentform";
	}
}
