import java.sql.*;

public class JDBCTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {

			// 1. ����̹� �ε�
			// db�� network program�̱� ������ exception�� ���� �ִ�.
			// class path�� driver�� �־�� ���డ��
			// class path������ project�� property���� new user library�� external jar
			// file�� �Ѵ�
			// file�� connector file ��ġ�� �ִ� ~~~~bin.jar file�� �Ѵ�.
			Class.forName("com.mysql.jdbc.Driver");

			// 2. connection ���
			String url = "jdbc:mysql://localhost/webdb";

			// java sql connection(catch���� SQLException)
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("���� ����!");

			// 3. Satement ���� (SQL��!!!!)
			stmt = conn.createStatement();

			// 4. SQL ����
			String sql = "SELECT * FROM pet"; // �� ��� dateformat���ؼ� �׷��� �־ȵ�
												// �ֿֿ�!!!!!
			rs = stmt.executeQuery(sql);
			String sql2 = "SELECT name, owner, species, gender, DATE_FORMAT(birth,'%Y-%m-%d'), DATE_FORMAT(death,'%Y-%m-%d') FROM pet";
			rs2 = stmt.executeQuery(sql2);
			
			
			while (rs2.next()) {
				String name = rs2.getString(1);

				String owner = rs2.getString(2);

				String species = rs2.getString(3);

				String gender = rs2.getString(4);

				// date type�� string���� ���� �� �ִ�.
				String birth = rs2.getString(5);

				String death = rs2.getString(6);

				System.out.println(name + " " + owner + " " + species + " " + gender + " " + birth + " " + death);

			}
			// while(rs.next()){
			// //ù ��° column�� string�̶� getString���� �޴´�
			// //�� row�� namecolumn�� ����
			// String name = rs.getString(1);
			//
			// String owner = rs.getString(2);
			//
			// String species = rs.getString(3);
			//
			// String gender = rs.getString(4);
			//
			// //date type�� string���� ���� �� �ִ�.
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

			System.out.println("SQL ����");
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
