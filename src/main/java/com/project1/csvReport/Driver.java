package com.project1.csvReport;

import java.io.File;
import java.io.FileReader;
import java.sql.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
@SpringBootApplication
public class Driver {

	
		public static void main(String[] args) {
			try {
			
				
				Connection Conn = DatabaseConnection.getConnection();	
				
				File file = new File("D:\\projects\\Data1\\DataSet1.csv");
		        FileReader filereader = new FileReader(file); 
		        
		        CSVReader csvReader = new CSVReader(filereader); 
		        String[] header= csvReader.readNext(); 
		        String[] nextRecord;
		
		        
		        SimpleValidator dataValidator = new SimpleValidator();
		        Boolean validation;
		      
		       
		        String query = " insert into Donations (Date_of_donation,Order_id,Non_profit,Donation_Curr,Donation_Amount,Fee)"
				        + " values (convert (date,?,103), ?, ?, ?, ?, ?)";

				PreparedStatement preparedStmt = Conn.prepareStatement(query);
				
		        while ((nextRecord = csvReader.readNext()) != null) {
		        	
		        	validation= dataValidator.validate(nextRecord);
		        	if(validation==false) {
		        		System.out.println("Stopping the application");
			        	System.exit(0);
			        }
		        	preparedStmt.setString (1, nextRecord[0]);
				      preparedStmt.setString (2, nextRecord[1]);
				      preparedStmt.setString   (3, nextRecord[2]);
				      preparedStmt.setString(4, nextRecord[3]);
				      preparedStmt.setString    (5,nextRecord[4]);
				      preparedStmt.setString    (6, nextRecord[5]);

				      preparedStmt.addBatch();
				      
		        }
				
			      			      // execute the preparedstatement
			      preparedStmt.executeBatch();
			      csvReader.close();
			      Conn.commit();
			   //   Conn.close();
					
					PrepareReport prepare = new PrepareReport();
					prepare.getReport(Conn);
			    }catch (Exception e) {
					e.printStackTrace();
				}
		
				
				
		
			
		}
}
