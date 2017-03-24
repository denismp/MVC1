package com.denis.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.denis.myapp.entity.Student;

public interface StudentDaoInterface {
	public List<Student> getAll() throws Exception;
	
	public List<Student> getByName(String name) throws Exception;
	
	public void update(Student object) throws Exception;

	public Student merge(Student object) throws SQLException, Exception;
	
	public void persist(Student object) throws Exception;
}
