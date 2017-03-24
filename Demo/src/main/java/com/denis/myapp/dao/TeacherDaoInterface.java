package com.denis.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.denis.myapp.entity.Teacher;

public interface TeacherDaoInterface {
	public List<Teacher> getAll() throws Exception;
	
	public List<Teacher> getByName(String name) throws Exception;
	
	public void update(Teacher object) throws Exception;

	public Teacher merge(Teacher object) throws SQLException, Exception;

	public void persist(Teacher object) throws Exception;
}
