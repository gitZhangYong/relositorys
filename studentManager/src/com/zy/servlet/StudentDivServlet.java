package com.zy.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.bean.PageBean;
import com.zy.service.StudentService;
import com.zy.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentDivServlet
 */
@WebServlet("/studiv")

public class StudentDivServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//需要显示的页码数
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			//根据页码数获取相应的数据
			StudentService service=new StudentServiceImpl();
			PageBean pageBean=new PageBean();
			try {
				 pageBean = service.findStudentByPage(currentPage);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//跳转
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("divpage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
