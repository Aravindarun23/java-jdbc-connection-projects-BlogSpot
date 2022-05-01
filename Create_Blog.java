package ZOHO;
import java.sql.*;
import java.util.Scanner;
public class Create_Blog{
	public void Create(Connection con) throws Exception{
		PreparedStatement pstmt =con.prepareStatement("insert into BlogSpot (Name,UserId,UserPass,TopicName,Content) values(?,?,?,?,?)");
		try (Scanner Scan = new Scanner(System.in)){
			System.out.println("<<--Enter Your Name-->>");
			String Name=Scan.nextLine();
			System.out.println("<<--Set UserID-->");
			int UserId=Scan.nextInt();
			System.out.println("<<-Set UserPassword (Max 8 Characters)-->>");
			String UserPass =Scan.next();
			Scan.nextLine();
			System.out.println("<<--Enter the Title Name-->>");
			String TopicName=Scan.nextLine();
			System.out.println("<<-Write the Blog-->>");
			String Content=Scan.nextLine();
			pstmt.setString(1,Name);
			pstmt.setInt(2,UserId);
			pstmt.setString(3,UserPass);
			pstmt.setString(4,TopicName);
			pstmt.setString(5,Content);
			pstmt.executeUpdate();
			System.out.println("\n---------------------------Thanks for writting blog! Your blog added sucessfully--------------------------");
		}
		catch (Exception e) {
			System.out.println("-------------Input Error <<PleaseEnter Valid Inputs>>-------------");
		}
	}
}
 
