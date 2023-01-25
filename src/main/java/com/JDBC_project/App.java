package com.JDBC_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
	
	static Connection conn = null;
	static String day;
	
	public static void Login() {
		String name = JOptionPane.showInputDialog("Username :");
		String pd = JOptionPane.showInputDialog("Password :");
		if(name.equals("ahlam")&& pd.equals("123456")){
			System.out.println("\n******************************  Successful Login  ******************************\n");
			try {
				conn = connect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);		
		}
	}
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
		// Creating a connection to the database:
		String url = "jdbc:mysql://localhost:3306/ahlamdemo";
		String username = "root";
		String password = "password";
				
		conn = DriverManager.getConnection(url, username, password);
		
		System.out.println("Connection to MySQL has been established.\n");	
		return conn;
	}
	
	public static void PickAnEntity() throws SQLException {
		// After creating the connection using conn = connect(), Creating and executing SQL statements
		System.out.println("\n");
		String sql = "SHOW TABLES";
		ResultSet Rs = conn.createStatement().executeQuery(sql);
		int i = 1;
		while (Rs.next()) {
			System.out.println("  " +i +" "+ Rs.getString("Tables_in_ahlamdemo"));
			i++;
		}	
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);  

		System.out.println("\n Which entity would you like to view ? 1-5 \n");
		int a= sc.nextInt();
		
		if (a == 1){
			System.out.println("\n The Expenses Entity has the following data:\n");
			String sql1 = "SELECT * FROM expenses";
			ResultSet Rs1 = conn.createStatement().executeQuery(sql1);
			while (Rs1.next()) {
				System.out.println( "  " + Rs1.getString("EXPENSE_ID") + "  " + Rs1.getString("DESCRIPTION") + "  " + Rs1.getString("AMOUNT") +"  " + Rs1.getString("EXPENSE_DATE")+"  "  +Rs1.getString("INVOICE_NUMBER")+"  " + Rs1.getString("FAMILY_ID"));
			}	
		}
		if (a == 2){
			System.out.println("\n The Family Entity has the following data:\n");
			String sql1 = "SELECT * FROM family";
			ResultSet Rs1 = conn.createStatement().executeQuery(sql1);
			while (Rs1.next()) {
				System.out.println("  " + Rs1.getString("FAMILY_ID") + "  " + Rs1.getString("FAMILY_NAME") + "  " + Rs1.getString("PHONE_NUMBER") +"  " + Rs1.getString("NET_WORTH"));
			}	
		}
		if (a == 3){
			System.out.println("\n The Family_members Entity has the following data:\n");
			String sql1 = "SELECT * FROM family_members";
			ResultSet Rs1 = conn.createStatement().executeQuery(sql1);
			while (Rs1.next()) {
				System.out.println("  " + Rs1.getString("FAMILY_MEMBER_ID") + "  " + Rs1.getString("FIRST_NAME") + "  " + Rs1.getString("LAST_NAME") +"  " + Rs1.getString("BIRTH_DATE")+"  "  +Rs1.getString("GENDER")+"  " + Rs1.getString("FAMILY_ID"));
			}	
		}
		if (a == 4){
			System.out.println("\n The Task Entity has the following data:\n");
			String sql1 = "SELECT * FROM task";
			ResultSet Rs1 = conn.createStatement().executeQuery(sql1);
			while (Rs1.next()) {
				System.out.println( "  " + Rs1.getString("TASK_ID") + "  " + Rs1.getString("TASK_MANAGER") + "  " + Rs1.getString("TASK_NAME") +"  " + Rs1.getString("DESCRIPTION")+"  "  +Rs1.getString("START_DATE")+"  " + Rs1.getString("END_DATE"));
			}	
		}
		if (a == 5){
			System.out.println("\n The Task_member Entity has the following data:\n");
			String sql1 = "SELECT * FROM task_member";
			ResultSet Rs1 = conn.createStatement().executeQuery(sql1);
			while (Rs1.next()) {
				System.out.println("  " + Rs1.getString("TASK_MEMBER_ID") + "  " + Rs1.getString("TASK_ID") + "  " + Rs1.getString("FAMILY_MEMBER_ID") +"  " + Rs1.getString("START_DATE")+"  "  +Rs1.getString("END_DATE"));
			}	
		}
	}

	public static void WeeklyFamilyExpensesReport() throws SQLException {
		
	//This method will print weekly report of the expenses of family whose family id is 10 
		if(day.equals("Tuesday")) {
			System.out.println("This week's expenses of Family whose ID is 10 : \n");
			String sql = "SELECT * FROM expenses WHERE FAMILY_ID = 10";
			ResultSet Rs = conn.createStatement().executeQuery(sql);
			while (Rs.next()) {
				System.out.println("  " + Rs.getString("family_id") + "  " + Rs.getString("EXPENSE_ID") + "  " + Rs.getString("DESCRIPTION") +"  " + Rs.getString("AMOUNT")+"  "  +Rs.getString("INVOICE_NUMBER"));
			}	
		}
		
	//This method will print weekly report of the expenses of family whose family id is 20 
		else if(day.equals("Wednesday")) {
			System.out.println("This week's expenses of Family whose ID is 20 : \n");
			String sql = "SELECT * FROM expenses WHERE FAMILY_ID = 20";
			ResultSet Rs = conn.createStatement().executeQuery(sql);
			while (Rs.next()) {
				System.out.println("  " + Rs.getString("family_id") + "  " + Rs.getString("EXPENSE_ID") + "  " + Rs.getString("DESCRIPTION") +"  " + Rs.getString("AMOUNT")+"  "  +Rs.getString("INVOICE_NUMBER"));
			}	
		}
		
	//This method will print weekly report of the expenses of family whose family id is 30 
		else if(day.equals("Thursday")) {
			System.out.println("This week's expenses of Family whose ID is 30 : \n");
			String sql = "SELECT * FROM expenses WHERE FAMILY_ID = 30";
			ResultSet Rs = conn.createStatement().executeQuery(sql);
			while (Rs.next()) {
				System.out.println("  " + Rs.getString("family_id") + "  " + Rs.getString("EXPENSE_ID") + "  " + Rs.getString("DESCRIPTION") +"  " + Rs.getString("AMOUNT")+"  "  +Rs.getString("INVOICE_NUMBER"));
			}	
		}
		
		else {
			System.out.println("A report is only issued on the following days:\n");
			System.out.println("1. Family id = 10 on Tuesday");
			System.out.println("2. Family id = 20 on Wednesday");
			System.out.println("3. Family id = 30 on Thursday");
		}
	}

	public static void InsertIntoDB() throws SQLException, ClassNotFoundException {
		Connection conn = connect();
		
		//create Statement
		String sql = "INSERT INTO FAMILY (FAMILY_ID, FAMILY_NAME, PHONE_NUMBER, NET_WORTH) VALUES (40,'Abdullah', '0467217890', '43.2')";
		conn.createStatement().executeUpdate(sql);
	}
	
	public static void DeleteFromDB(int id) throws SQLException, ClassNotFoundException {
		Connection conn = connect();
		// Creating Delete Statement
		String sql = "DELETE FROM FAMILY WHERE FAMILY_ID =" + id ;
		conn.createStatement().executeUpdate(sql);
	}
	
	public static void UpdateDB(int id) throws SQLException, ClassNotFoundException {
		Connection conn = connect();
		// Creating Statement
		String sql = "UPDATE FAMILY SET PHONE_NUMBER = '1234567890' WHERE FAMILY_ID =" + id ; //The phone number was 0477862431 before

		conn.createStatement().executeUpdate(sql);
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// This method is used to login to the system application before connecting to MySQL
		Login(); 
		
	// This line exists in case I comment out the Login() method so that I can connect without logging in :
		//conn = connect();
		
	//To obtain Current Day 
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		//System.out.println(day);
		
	//To obtain a weekly report of a family's recorded expenses	where Tuesday-> family id 10, Wednesday -> family id 20, Thursday -> family id 30
		//WeeklyFamilyExpensesReport();
		
	//To insert an instance into a desired entity (in this case Family entity) in the database ahlamdemo 	
		//InsertIntoDB();
		
	//To delete an instance into a desired entity (in this case Family entity with family_id of 31) in the database ahlamdemo 	
		//DeleteFromDB(40) ;
		
	//To update an entity (in this case Family entity) and make changes to the attribute (in this case phone_number) in the database ahlamdemo 
		UpdateDB(10);
		
	//To view any desired entity in the database ahlamdemo 
		//PickAnEntity();
	}
}
