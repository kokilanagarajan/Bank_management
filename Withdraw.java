package BankEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Withdraw {
	public Withdraw() {
		
	}
	public void withdraw(Connection con,Scanner obj) {
		System.out.println("ENTER ACCOUNT NAME");
		String withName=obj.next();
		System.out.println("ENTER WITHDRAW AMOUNT:");
		int withamt=obj.nextInt();
		System.out.println("ENTER PASSWORD");
		 String ps=obj.next();
		String withd="UPDATE pro SET account=account-? WHERE name like ? AND password like ?";
		try {
			
			PreparedStatement psw=con.prepareStatement(withd);
			
			psw.setInt(1, withamt);
			psw.setString(2, withName);
			psw.setString(3, ps);
			//ResultSet rsw=psw.executeQuery();
			 int r=psw.executeUpdate();
			 if(r==0) {
				 System.out.println("CHECK PASSWORD");
				 withdraw(con,obj);
			 }else { 
			viewBalance(con,obj,withName);
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void viewBalance(Connection con, Scanner obj,String withName) {
		// TODO Auto-generated method stub
		String s="SELECT * FROM pro where name like ?";
		try {
			PreparedStatement pv=con.prepareStatement(s);
			pv.setString(1, withName);
			ResultSet rv=pv.executeQuery();
			while(rv.next()) {
				System.out.println("AVILAAVLE BALANCE:"+rv.getInt(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
