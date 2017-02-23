package com.conflux.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.conflux.dao.StudentDAO;
import com.conflux.entity.Student;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	public Student loginStudent(Student student) {
		return studentDAO.loginStudent(student);
	}

}
