package d1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import d1.model.userTable;

public class userservice {
	private Connection conn;
private PreparedStatement pstmt;
	public userservice() {
		conn = new d1.conn.conn().getCon();
	}

	public boolean valiUser(d1.model.userTable user)
	{
		
		try {
			pstmt=conn.prepareStatement("select * from usertable where username=? and password=?");
		pstmt.setString(1,user.getUsername());
		pstmt.setString(2,user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
