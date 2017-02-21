package com.denis.myapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
        }
)
public class Teacher {
	private Long id;
	private String name;
	private Set<Course> courses;
	
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
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER, mappedBy = "teacher")
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	

}
