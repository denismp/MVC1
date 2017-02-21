package com.denis.myapp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denis.myapp.dao.StudentDao;
import com.denis.myapp.entity.Student;

@Service("studentService")
public class StudentService {
	private final Logger log = Logger.getLogger (this.getClass());
	
	@Autowired
	protected StudentDao studentDao;
	
	public List<Student> getStudents() throws Exception{
		return studentDao.getAll();
		
	}
}
