import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;


public class JDBCTestInsert2 {
public static void main(String[] args){

	insertPet("둘리","고길동","cat","f","2010-01-01","0000-00-00");
	insertPet("둘리1","고길동1","dog","m","2010-01-01","0000-00-00");
	insertPet("둘리2","고길동2","cat","f","2010-01-01","0000-00-00");

}
public static void insertPet(String name, String owner, String species,String gender, String birth, String death){
	
	Connection conn = null;
	PreparedStatement pstmt = null;


	try {

		// 1. 드라이버 로드
		// db도 network program이기 때문에 exception이 많이 있다.
		// class path에 driver가 있어야 실행가능
		// class path설정은 project의 property가서 new user library에 external jar
		// file로 한다
		// file은 connector file 위치에 있는 ~~~~bin.jar file로 한다.
		Class.forName("com.mysql.jdbc.Driver");

		// 2. connection 얻기
		String url = "jdbc:mysql://localhost/webdb";

		// java sql connection(catch에서 SQLException)
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		System.out.println("연결 성공!");

		// 3. Satement 생성 (SQL문!!!!)
		String sql = "insert into pet values(?,?,?,?,?,?)";
		
		pstmt =  conn.prepareStatement(sql);

		// 4. SQL 실행
			pstmt.setString(1, name);
			pstmt.setString(2, owner);
			pstmt.setString(3, species);
			pstmt.setString(4, gender);
			pstmt.setString(5, birth);
			pstmt.setString(6, death);
			
		// 왜왜왜!!!!!
		pstmt.executeUpdate();
		

		

	} catch (ClassNotFoundException e) {
		System.out.println("Can not find driver");
	} catch (SQLException e) {

		System.out.println("SQL 오류");
	} finally {
		// 5. close
		
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}