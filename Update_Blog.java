package ZOHO;
import java.util.Scanner;
import java.sql.*;

public class Update_Blog {
	public void Update(Connection con) throws SQLException {
		PreparedStatement pstmt =con.prepareStatement("UPDATE BlogSpot SET Content =(?) WHERE UserId = (?)");
		Statement st=con.createStatement();		
		ResultSet rs=st.executeQuery("select * from BlogSpot");
		try (Scanner Scan = new Scanner(System.in)){
			System.out.println("-----------------If You Want To Update Your Blog You Must Enter Id And Password----------------------\n");
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
				System.out.println("----------------------Your Id Was Found You Can Update Your Content--------------------\n");
				System.out.println("<<--  Write A New Content For "+rs.getString("TopicName")+"  -->>\n");
				Scan.nextLine();
				String UpdateContent=Scan.nextLine();
				pstmt.setString(1,UpdateContent);
				pstmt.setInt(2,UserId);
				pstmt.executeUpdate();
				System.out.println("---------------!! Your Blog Content Updated Sucessfully !!--------------------/n");
			}
		}
		catch(Exception e) {
			System.out.println("-----------------------Information Is Wrong Please Re Check Id Ans Password-------------------------");
		}
	}
}
	
