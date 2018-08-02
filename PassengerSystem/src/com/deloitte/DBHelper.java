package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBHelper {

	public ArrayList<PassengerVO> getAllPassengers(String dest) {
		ArrayList<PassengerVO> al = new ArrayList<PassengerVO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PASSENGERS WHERE DST=?");

			pstmt.setString(1, dest);

			ResultSet rs = pstmt.executeQuery();
			String fn;
			String ln;
			String sr;
			String ds;
			String sx;
			while (rs.next()) {
				fn = rs.getString(1);
				ln = rs.getString(2);
				sr = rs.getString(3);
				ds = rs.getString(4);
				sx = rs.getString(5);
				PassengerVO pvo = new PassengerVO();
				pvo.setFname(fn);
				pvo.setLname(ln);
				pvo.setSrc(sr);
				pvo.setDst(ds);
				pvo.setSex(sx);
				al.add(pvo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return al;
	}

}
