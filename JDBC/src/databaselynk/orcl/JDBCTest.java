package databaselynk.orcl;

//You will have to set a build path before running
//path  :right click on project, java build path, external jars and paste the external jar path and add orcljdbc6 or 14
//orcl is one instance of oracle
//multiple instaces can run like that
//in  sql command prompt, ensure that the connection is established
//Db is expensive. you can not keep the connection open for longer time
//There is a problem with Driver manager: It does not support connection pooling
//connection pooling basically acts as gateway, when users updates, deletes, creates or anything, the gate(connection) is opened
//and closed after the use so that others can access it.
//We use DataSource which supports connection pooling(java.utilx.*) mainly used in server side programming
//DPCP is basic DataSource,SPRING is DataSource. OracleDataSource is its own DataSource





import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

public class JDBCTest {
	//comment
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","c##mithun","Connect14");
		Statement st = con.createStatement();
		System.out.println("after connection");
		st.execute("create table student5(sid number(5), sname varchar2(15), sex varchar2(1), age number(2), year number(4), gpa number(3,2))");
		st.execute("insert into student5 values (1011,'Student1','M',25,1994,3.2)");
		st.execute("insert into student5 values (1012,'Student2','F',26,1990,3.56)");
		st.execute("update student5 set sname ='Mithun' where sid=1011");
		
		ResultSet rs = st.executeQuery("Select * from student5");
		while(rs.next()){
			System.out.println("Sid: "+rs.getInt(1)+" ");
			System.out.println("Sname: "+rs.getString(2)+" ");
			System.out.println(("Ssex: "+rs.getString(3)+" "));
			
		}
	}

}
