package com.zy.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zy.bean.PageBean;
import com.zy.bean.Student;
import com.zy.dao.StudentDao;
import com.zy.dao.impl.StudentDaoImpl;
import com.zy.service.StudentService;
/**
 * 这是学生业务实现
 * @author zy
 *
 */
public class StudentServiceImpl implements StudentService {
	
	@Override
	public List<Student> SelectAll() throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.SelectAll();
		
	}

	@Override
	public void StudentAdd(Student student) throws SQLException{
		StudentDao dao=new StudentDaoImpl();
		dao.StudentAdd(student);
	}

	@Override
	public void StudentDelete(int id) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.StudentDelete(id);
	}

	@Override
	public Student SelectById(int id) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		
		return dao.SelectById(id);
	}

	@Override
	public void stuUpdate(Student stu) throws SQLException{
		StudentDao dao=new StudentDaoImpl();
		
		dao.StuUpdate(stu);
		
	}


	@Override
	public List<Student> SelectByNameAndSex(String name, String sex) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.SelectByNameAndSex(name,sex);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {

		//封装分页的该页数据
		int pagesize=StudentDao.PAGE_SIZE;
		PageBean<Student> pageBean=new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pagesize);
		List<Student> list = new StudentDaoImpl().findStudentByPage(currentPage);
		pageBean.setList(list);
		int count= new StudentDaoImpl().findTotal();
		pageBean.setTotalSize(count);
		
		pageBean.setTotalPage((count%pagesize)==0?count/pagesize:(count/pagesize)+1);
	
		return pageBean;
	}

}
