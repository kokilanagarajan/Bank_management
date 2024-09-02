package BankEntity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","****");
		System.out.println("1.create account\t 2.despoit\t 3.withdraw\t 4.view Details");
		
		
		Create c=new Create();
		Depoist d=new Depoist();
		ViewDetails v=new ViewDetails();
		Withdraw w=new Withdraw();
		boolean time=true;
		while(time) {
			System.out.println("enter choice");
			Scanner obj=new Scanner(System.in);
			int choice=obj.nextInt();
		switch(choice) {
		case 1:
			
			c.createAccount(con,obj);
			break;
		case 2:
			d.depoist(con,obj);
			
			break;
		case 4:
			v.viewDetails(con,obj);
			break;
		case 3:
			w.withdraw(con,obj);
			break;
		
		case 5:
			time=false;
			break;
		}}
		}
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

		
	}

}
