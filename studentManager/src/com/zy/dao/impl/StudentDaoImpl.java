package com.zy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.zy.bean.Student;
import com.zy.dao.StudentDao;
import com.zy.util.JDBCutil;
import com.zy.util.TextUtils;
/**
 * 这是StudentDao的实现类
 * @author zy
 *
 */
public class StudentDaoImpl  implements StudentDao{
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Override
	@Test
	public List<Student> SelectAll() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		List<Student> list=queryRunner.query("select * from student", new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void StudentAdd(Student stu) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		queryRunner.update("insert into student values(0,?,?,?,?,?,?)",stu.getName(),stu.getSex(),stu.getPhone(),stu.getBirthday(),stu.getHabby(),stu.getInfo());
	}

	@Override
	public void StudentDelete(int id) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		queryRunner.update("delete from student where id=?",id);
	}

	@Override
	public Student SelectById(int id) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		
		return queryRunner.query("select * from student where id=?", new BeanHandler<Student>(Student.class),id);
	}

	@Override
	public void StuUpdate(Student stu) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		queryRunner.update("update student set name=? , sex=? , phone=? ,birthday=? ,habby=? ,info=?  where id=?",
							stu.getName(),
							stu.getSex(),
							stu.getPhone(),
							stu.getBirthday(),
							stu.getHabby(),
							stu.getInfo(),
							stu.getId()
							);
	}

	
	@Override
	public List<Student> SelectByNameAndSex(String name, String sex) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		/**
		 * 模糊查询  两种条件 name  sex
		 */
		String sql="select * from student where 1=1 ";
		List<String> list=new ArrayList<String>();
		if(!TextUtils.isEmpty(name)) {
			sql+=" and name like ? ";
			list.add("%"+name+"%");
		}
		if(!TextUtils.isEmpty(sex)) {
			sql+="and sex=  ?";
			list.add(sex);
		}
		return queryRunner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		
		return queryRunner.query("select * from student limit ? offset ?", new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
	}

	@Override
	@Test
	public int findTotal() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(JDBCutil.getDataSource());
		/**
		 * 处理平均值  个数
		 */ 
		Long result=(Long) queryRunner.query("select count(*) from student", new ScalarHandler());
		return result.intValue();
	}

}
