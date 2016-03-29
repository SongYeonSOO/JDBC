import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;


public class JDBCTestInsert2 {
public static void main(String[] args){

	insertPet("�Ѹ�","��浿","cat","f","2010-01-01","0000-00-00");
	insertPet("�Ѹ�1","��浿1","dog","m","2010-01-01","0000-00-00");
	insertPet("�Ѹ�2","��浿2","cat","f","2010-01-01","0000-00-00");

}
public static void insertPet(String name, String owner, String species,String gender, String birth, String death){
	
	Connection conn = null;
	PreparedStatement pstmt = null;


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
		String sql = "insert into pet values(?,?,?,?,?,?)";
		
		pstmt =  conn.prepareStatement(sql);

		// 4. SQL ����
			pstmt.setString(1, name);
			pstmt.setString(2, owner);
			pstmt.setString(3, species);
			pstmt.setString(4, gender);
			pstmt.setString(5, birth);
			pstmt.setString(6, death);
			
		// �ֿֿ�!!!!!
		pstmt.executeUpdate();
		

		

	} catch (ClassNotFoundException e) {
		System.out.println("Can not find driver");
	} catch (SQLException e) {

		System.out.println("SQL ����");
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