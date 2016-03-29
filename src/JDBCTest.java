import java.sql.*;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			String sql = "SELECT * FROM pet"; // 왜 얘는 dateformat안해서 그런가 왜안됨
												// 왜왜왜!!!!!
			rs = stmt.executeQuery(sql);
			String sql2 = "SELECT name, owner, species, gender, DATE_FORMAT(birth,'%Y-%m-%d'), DATE_FORMAT(death,'%Y-%m-%d') FROM pet";
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
			// while(rs.next()){
			// //첫 번째 column이 string이라서 getString으로 받는다
			// //한 row의 namecolumn을 받음
			// String name = rs.getString(1);
			//
			// String owner = rs.getString(2);
			//
			// String species = rs.getString(3);
			//
			// String gender = rs.getString(4);
			//
			// //date type도 string으로 받을 수 있다.
			// String birth = rs.getString(5);
			//
			// String death = rs.getString(6);
			//
			// System.out.println(name+" "+owner+" "+species+" "+gender+"
			// "+birth+" "+death);
			// }

		} catch (ClassNotFoundException e) {
			System.out.println("Can not find driver");
		} catch (SQLException e) {

			System.out.println("SQL 오류");
		} finally {
			// 5. close
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
