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
////���Ķ� DELETE ��
			String sql2 = "DELETE FROM pet WHERE name= 'maumE'";
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


		} catch (ClassNotFoundException e) {
			System.out.println("Can not find driver");
		} catch (SQLException e) {

			System.out.println("SQL ����");
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


