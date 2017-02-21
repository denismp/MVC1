package com.denis.myapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id", "teacher_id"}),
                @UniqueConstraint(columnNames = {"id", "student_id"})               
        }
)
public class Course {
	private Long id;
	private String name;
	private Teacher teacher;
	private Student student;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
