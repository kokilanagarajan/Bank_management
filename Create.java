package BankEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
//	private String name;
//	private int age;
//	private double initalamt;
//	public Create(String name,int age,double initalamt) {
//		this.name=name;
//		this.age=age;
//		this.initalamt=initalamt;
//	}
	public Create() {
		
	}

	public void createAccount(Connection con, Scanner obj) {
		//boolean c=true;
	//	while(c) {
		System.out.println("ENTER NAME:");
		String name=obj.next();
		System.out.println("ENTER PASSWORD");
		String password=obj.next();
		System.out.println("Enter age");
		int age=obj.nextInt();
		System.out.println("Enter initalAmount:");
		int amount=obj.nextInt();
		String sql="INSERT INTO pro VALUES(?,?,?,?)";

		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,name);
			pst.setInt(2,age);
			pst.setInt(3,amount);
			pst.setString(4, password);
			int r=pst.executeUpdate();
			if(r>0) {
				System.out.println("ACCOUNT CREATE SUSCCESSFULLLY");
				//c.viewDetails(Connection con,Scanner obj);
				//c=false;
			
			}
			else {
				System.out.println("try again later");
			}
			return;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	

}
