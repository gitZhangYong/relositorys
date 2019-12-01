package com.zy.service;

import java.sql.SQLException;
import java.util.List;

import com.zy.bean.PageBean;
import com.zy.bean.Student;

public interface StudentService {

	public List<Student> SelectAll() throws SQLException;
	
	public void StudentAdd(Student student) throws SQLException;
	
	public void StudentDelete(int id) throws SQLException;

	public Student SelectById(int id) throws SQLException;

	public void stuUpdate(Student stu) throws SQLException;


	public List<Student> SelectByNameAndSex(String name, String sex) throws SQLException;
	
	PageBean findStudentByPage(int CurrentPage) throws SQLException;
}