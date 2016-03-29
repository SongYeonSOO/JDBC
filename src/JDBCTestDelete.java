import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTestDelete {





	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		ResultSet rs2 = null;

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
////고쳐라 DELETE 문
			String sql2 = "DELETE FROM pet WHERE name= 'maumE'";
			rs2 = stmt.executeQuery(sql2);
		

			while (rs2.next()) {
				String name = rs2.getString(1);

				String owner = rs2.getString(2);

				String species = rs2.getString(3);

				String gender = rs2.getString(4);

				// date type도 string으로 받을 수 있다.
				String birth = rs2.getString(5);

				String death = rs2.getString(6);

				System.out.println(name + " " + owner + " " + species + " " + gender + " " + birth + " " + death);

			}


		} catch (ClassNotFoundException e) {
			System.out.println("Can not find driver");
		} catch (SQLException e) {

			System.out.println("SQL 오류");
		} finally {
			// 5. close
			
			if (rs2 != null) {
				try {
					rs2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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


