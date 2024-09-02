package BankEntity;

public class Customer {
     private String name;
     private int age;
     private long accno;
     public Customer(String name,int age,long accno) {
    	 this.name=name;
    	 this.age=age;
    	 this.accno=accno;
     }
     
     public String toString() {
    	 return "name:"+this.name+"accno:"+this.accno;
     }
}
