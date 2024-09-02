package BankEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Depoist {
 public Depoist() {
	 
 }
 public void depoist(Connection con,Scanner obj) {
	 Withdraw q=new Withdraw();
	 
	 System.out.println("ENTER ACCOUNT NAME:");
	 String accname=obj.next();
	 System.out.println("ENTER AMOUNT:");
	 int depamt=obj.nextInt();
	 System.out.println("ENTER PASSWORD");
	 String psa=obj.next();
	 String dep="UPDATE pro SET account=account+? WHERE name like ? AND password like ? ";
	 
	 try {
		 PreparedStatement psd=con.prepareStatement(dep);
		 psd.setInt(1, depamt);
		 psd.setString(2, accname);
		 psd.setString(3, psa);
		// ResultSet rsd=psd.executeQuery();
		 int r=psd.executeUpdate();
		 if(r==0) {
			 System.out.println("CHECK PASSWORD");
			 depoist(con,obj);
			 
		 }else {
		 q.viewBalance(con, obj, accname);
		 }
		 
		
		 
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
 }
}
