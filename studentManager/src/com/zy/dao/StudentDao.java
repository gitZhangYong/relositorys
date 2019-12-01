package com.zy.dao;

import java.sql.SQLException;
import java.util.List;

import com.zy.bean.Student;

/**
 * 针对学生表的数据访问操作
 * @author zy
 *
 */
public interface StudentDao {
	//定义每页查询多少条数据
	int PAGE_SIZE=5;
	/**
	 * 查询所有学生 存放在list中
	 * @return
	 */
	public List<Student> SelectAll() throws SQLException;
	
	public void StudentAdd(Student student) throws SQLException;
	
	public void StudentDelete(int id) throws SQLException;

	public Student SelectById(int id) throws SQLException ;

	public void StuUpdate(Student stu) throws SQLException;

	public List<Student> SelectByNameAndSex(String name, String sex)throws SQLException;
	
	//查询当页学生数据
	List<Student> findStudentByPage(int ccurrentPage)throws SQLException;
	
	//查询数据库中的数据总条数
	int findTotal() throws SQLException;
}
