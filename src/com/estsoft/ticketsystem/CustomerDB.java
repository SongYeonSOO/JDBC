package com.estsoft.ticketsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {

	private Connection getConnection() {
		Connection conn = null;
		try {
			// 1. ����̹� �ε�

			Class.forName("com.mysql.jdbc.Driver");

			// 2. Connection ���
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException ex) {
			System.out.println("����̹��� ã�� �� �����ϴ�:" + ex);
		} catch (SQLException ex) {
			System.out.println("SQL ����:" + ex);
		} finally {
			return conn;
		}
	}

	public void insert(Customer c) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {

			// 3. Statement �غ�
			String sql = "insert into customer values(  null, ?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. bind
			pstmt.setString(1, c.getCustomername());
			pstmt.setLong(2, c.getMovieno());

			// 5. SQL ����
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQL ����:" + ex);
		} finally {
			// 6. �ڿ�����(clean-up)
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public boolean isAccount(Customer c) {
		List<Customer> list = new ArrayList<Customer>();
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			
			//3. Statement ����
			stmt = conn.createStatement();
			System.out.println(c.getCustomername());
			//4. SQL ����
			String sql = "select customername from customer where customername="+"'"+c.getCustomername()+"'";
			rs = stmt.executeQuery( sql );
			
			// 5. ������ �޾ƿ��� 
			while( rs.next() ) {
				String customername = rs.getString( 1 );
				
				Customer c1 = new Customer();
				c.setCustomername(customername);
				
				list.add( c1 );
			}
		} catch( SQLException ex ) {
			System.out.println( "SQL ����:" + ex );
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}

		return list.size()>0;
	}
	
	
	
	
	public void delete(Customer c) {
		Connection conn = getConnection();
		Statement stmt = null;
		try {

			// 3. Statement �غ�
			String sql = "delete from customer where customername= "+"'"+ c.getCustomername()+"'";
			stmt = conn.createStatement();

			// 5. SQL ����
			stmt.executeUpdate(sql);

		} catch (SQLException ex) {
			System.out.println("SQL ����:" + ex);
		} finally {
			// 6. �ڿ�����(clean-up)
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
