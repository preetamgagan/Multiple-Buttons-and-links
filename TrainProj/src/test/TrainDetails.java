package test;
import java.sql.*;
import java.util.*;
public class TrainDetails{
	public static void main(String[] args) 
			throws SQLException,ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"system","oracle");
		System.out.println("Enter the Train No: ");
		int train_no=Integer.parseInt(s.nextLine());
		System.out.println("Enter Train Name: ");
		String train_name=s.nextLine();
		System.out.println("From Station: ");
		String from_station=s.nextLine();
		System.out.println("To Station: ");
		String to_station=s.nextLine();
		System.out.println("Enter Availability: ");
		int availability=s.nextInt();
		PreparedStatement ps=con.prepareStatement("insert into train11 values(?,?,?,?,?)");
		ps.setInt(1,train_no);
		ps.setString(2, train_name);
		ps.setString(3, from_station);
		ps.setString(4, to_station);
		ps.setInt(5, availability);
		int k=ps.executeUpdate();
		if (k>=0)
		{
		System.out.println("Trains Details are Updated");	
		}
		else {
			System.out.println("Invalid");
		}
		con.close();
		s.close();
		
	}
	

}
