package com.estsoft.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookshop.vo.AuthorVo;
import com.estsoft.bookshop.vo.BookVo;

public class AuthorDao {
	@SuppressWarnings("finally")
	private Connection getConnection(){
		Connection conn = null;	
		try{
			//1. ����̹� �ε�
		
		Class.forName( "com.mysql.jdbc.Driver" );

		//2. Connection ���
		String url = "jdbc:mysql://localhost/webdb";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException ex) {
			System.out.println( "����̹��� ã�� �� �����ϴ�:" + ex );
		}catch( SQLException ex ) {
			System.out.println( "SQL ����:" + ex );
		}finally{
		return conn;
		}
	}
	
	
	public List<AuthorVo> getList() {
		List<AuthorVo> list = new ArrayList<AuthorVo>();
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			
			//3. Statement ����
			stmt = conn.createStatement();
			
			//4. SQL ����
			String sql = "select no, name from author";
			rs = stmt.executeQuery( sql );
			
			// 5. ������ �޾ƿ��� 
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				
				AuthorVo authorVo = new AuthorVo();
				authorVo.setNo(no);
				authorVo.setName(name);
				
				list.add( authorVo );
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

		return list;
	}
	
	
	public void insert( AuthorVo authorVo ) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {

			//3. Statement �غ�
			String sql = "insert into author values(  null, ? )";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			pstmt.setString( 1, authorVo.getName() );
			
			//5. SQL ����
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL ����:" + ex );
		} finally {
			//6. �ڿ�����(clean-up)
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
	}

}
