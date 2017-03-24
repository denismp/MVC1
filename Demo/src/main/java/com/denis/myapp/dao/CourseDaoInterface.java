package com.denis.myapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.denis.myapp.entity.Course;

public interface CourseDaoInterface {
	public List<Course> getAll() throws Exception;
	public List<Course> getByName(String name) throws Exception;
	public void update(Course object) throws Exception;
	public Course merge(Course object) throws SQLException, Exception;
	public void persist(Course object) throws Exception;
}
