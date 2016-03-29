
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestInsert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

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
			stmt = conn.createStatement();

			// 4. SQL 실행
			String sql = "INSERT INTO pet VALUES('maumE','chanE','dog','m','2006-09-10','0000-00-00')"; 
			stmt.executeQuery(sql);

		} catch (ClassNotFoundException e) {
			System.out.println("Can not find driver");
		} catch (SQLException e) {

			System.out.println("SQL 오류");
		} finally {
			// 5. close

			if (stmt != null) {
				try {
					stmt.close();
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
