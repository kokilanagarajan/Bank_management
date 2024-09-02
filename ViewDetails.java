package BankEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ViewDetails {

	public ViewDetails() {
		
	}
	public void viewDetails(Connection con,Scanner obj) {
		System.out.println("ENTER ACCOUNT NAME");
		String cust=obj.next();
		String view="SELECT * FROM pro  WHERE name like ?";
		try {
			PreparedStatement pst=con.prepareStatement(view);
			pst.setString(1, cust);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("name:"+rs.getString(1)+"\t"+"age:"+rs.getInt(2)+"\t"+"amount:"+rs.getInt(3));
				if(rs.getInt(2)>18) {
					System.out.println("Account Type: MAJOR");
				}
				else {
					System.out.println("Account Type:MINOR");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
