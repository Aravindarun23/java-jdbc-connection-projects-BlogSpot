package ZOHO;
import java.util.Scanner;
import java.sql.*;

public class Delete_Blog {
	public void Delete(Connection con) throws SQLException {
		PreparedStatement pstmt =con.prepareStatement("DELETE FROM BlogSpot WHERE UserId = (?)");
		Statement st=con.createStatement();		
		ResultSet rs=st.executeQuery("select * from BlogSpot");
		try (Scanner Scan = new Scanner(System.in)){
			System.out.println("-----------------If You Want To Delete Your Blog You Must Enter Id And Password----------------------\n");
			System.out.println("<<--Enter Your Id-->>");
			int UserId=Scan.nextInt();
			System.out.println("<<--Enter Your Password-->>");
			String UserPass =Scan.next();
			String v = null;
			while(rs.next()) {
				if(rs.getInt("UserId")==UserId){
					v=rs.getString("UserPass");
					break;
				}
			}
			if (v.equals(UserPass)) {
				System.out.println("----------------------Your Id Was Found--------------------\n");
				System.out.println("<--Are You Want To Delete Your Blog-->(Type YES/NO)\n");
				
				String Final=Scan.next();
				if(Final.equals("YES")) {
					pstmt.setInt(1,UserId);
					pstmt.executeUpdate();
					System.out.println("----------------------Your Blog Was Sucessfully Deleted--------------------\n");
				}
				else {
					System.out.print("----------------------Your Blog Was Not Deleted--------------------\n");
				}
					
				}
		}
		catch(Exception e) {
			System.out.println("----------------------Please Enter Valid Details----------------------");
		}
	}
}
