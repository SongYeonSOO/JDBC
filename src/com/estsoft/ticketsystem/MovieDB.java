package com.estsoft.ticketsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookshop.vo.AuthorVo;

public class MovieDB {

	private Connection getConnection(){
		Connection conn = null;	
		try{
			//1. 드라이버 로드
		
		Class.forName( "com.mysql.jdbc.Driver" );

		//2. Connection 얻기
		String url = "jdbc:mysql://localhost/webdb";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException ex) {
			System.out.println( "드라이버를 찾을 수 없습니다:" + ex );
		}catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		}finally{
		return conn;
		}
	}
	
	public void insert(Movie m) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {

			//3. Statement 준비
			String sql = "insert into movie values( null, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. bind
			
			pstmt.setString(1, m.getTitle());
			
			//5. SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			//6. 자원정리(clean-up)
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
	public int Count(Long movien) {
		List<Customer> list = new ArrayList<Customer>();
		
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = "select customername from customer where no2="+movien;
			rs = stmt.executeQuery( sql );
			
			// 5. 데이터 받아오기 
			while( rs.next() ) {
				String customername = rs.getString( 1 );
				
				Customer c = new Customer();
				c.setCustomername(customername);
				
				list.add( c );
			}
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
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

		return list.size();
	}
		
}
