import java.sql.*;
import javax.swing.*;

class DbHandler{
public static void addStudent(int rno, String name , int m1 , int m2 , int m3){
try {

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "system", "abc123");
	String sql = "insert into student values(?,?,?,?,?)";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1,rno);
	pst.setString(2,name);
	pst.setInt(3,m1);
	pst.setInt(4,m2);
	pst.setInt(5,m3);
	long res = pst.executeUpdate();
	JOptionPane.showMessageDialog(new JDialog(), res + " records added ");
	con.close();
	}
	catch(SQLException e)
	{
		JOptionPane.showMessageDialog(new JDialog(), " add issue "+e);
	}
}


public static void deleteStudent(int rno){
	try{
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","abc123");

	String sql = "delete from student where rno = ?";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1, rno);
	long res = pst.executeUpdate();
	System.out.println(res + " record deleted");

con.close();
	}
	catch(SQLException e){
	System.out.println("add issue"+e);
	}
}


public static String viewStudent(){
String data = "";
try {

	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "system", "abc123");
	String sql = "select * from student";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next())
	{
		String info = "	r: " + rs.getInt(1) + "	|	N: " + rs.getString(2) + "	|	s1: " + rs.getInt(3) + "	|	s2: " + rs.getInt(4) + "	|	s3: " + rs.getInt(5);
		data = data + info + "\n"; 
	}
	con.close();
	}
	catch(SQLException e)
	{
		JOptionPane.showMessageDialog(new JDialog(), " add issue "+e);
	}
	return data;
}
}