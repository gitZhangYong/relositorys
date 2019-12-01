package com.zy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.bean.Student;
import com.zy.service.StudentService;
import com.zy.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/stuupdate")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentService service =new StudentServiceImpl();
		Student student=new Student();
		try {
			student = service.SelectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("stu", student);
		request.getRequestDispatcher("stuupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		Date date=null;
		try {
			 date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			String[] habby = request.getParameterValues("habby");
			String habbies="";
			for(int i=0;i<habby.length;i++) {
				habbies+=habby[i]+",";
			}
			String info=request.getParameter("info");
			Student stu=new Student(id,name,sex,phone,date,habbies,info);
			StudentService service=new StudentServiceImpl();
			try {
				service.stuUpdate(stu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("stulist").forward(request, response);
			
	}

}
