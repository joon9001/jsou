package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest5 {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	//
	
public DbTest5() {
	try {
		Class.forName("org.mariadb.jdbc.Driver");
		String url ="jdbc:mariadb://localhost:3306/test";
		conn = DriverManager.getConnection(url, "root", "123");
			
		stmt = conn.createStatement();
		
		boolean b = false;
		//execute : executeQuery(), executeUpdate()를 하나로 처리
		//execute는 executeUpdate()라고 판별하면 false, executeQuery()라고 판별하면 true를 반환한다.
		
		//update -- executeUpdate()
		b= stmt.execute("update sangdata set sang ='마우스' where code=4"); //b=false
		System.out.println("update b: " + b);
		int result = stmt.getUpdateCount();
		System.out.println("result : " + result);
		if(result >=1 ) {
			System.out.println("작업 성공");
		}else {
			System.out.println("작업 실패");
		}
		
		//select -- executeQuery()
		b = stmt.execute("select * from sangdata"); // b= true
		System.out.println("select b:" + b);
		rs= stmt.getResultSet();
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + 
		rs.getString(2) + " " + 
			rs.getString(3) + " " +
			rs.getString(4));
			
		}
		
		} catch (Exception e) {
			System.out.println("DbTest5 실패 : " + e);
			return;
		}
	}


	public static void main(String[] args) {
		new DbTest5();

}
}