package com.zy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCutil {
	
	//初始化连接池
	static ComboPooledDataSource dataSource=null;
	static {	
		dataSource=new ComboPooledDataSource();
		
		
	}
	
	//获取dataSource
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//获取dataSource的连接
	public static Connection getConn() throws SQLException {
		
		return  dataSource.getConnection();
		
	}
	/**
	 * 
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
		if(conn!=null) {
			
				conn.close();
			} 
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				conn=null;
			}
		
			try {
				if(pst!=null) {
				pst.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pst=null;
		}
			try {
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				rs=null;
		}	
		
		}
		
	
}
