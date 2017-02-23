package com.conflux.dao;

import com.conflux.entity.Student;

public interface StudentDAO {

	public void saveStudent(Student student);
	public Student loginStudent(Student student);
}
