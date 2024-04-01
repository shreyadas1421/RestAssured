package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import org.joda.time.LocalDate;

public class Logging {
	
	
	public static void log(String msg, String type) {
		LocalDate today = LocalDate.now();
		//String formattedDate = today.format(DateTimeFormatter.ofPattern("mm-dd-yyyy"));
		
		try {
			File fr = new File("C:\\Users\\User\\Desktop\\Git Project1\\RestAssured\\log.text");
			BufferedWriter writer = new BufferedWriter(new FileWriter(fr,true));
			LocalDateTime currenttime = LocalDateTime.now();
			String format = currenttime.format(DateTimeFormatter.ofPattern("mm-dd-yyyy HH:mm:ss"));
			
			writer.append(type + " : ");
			writer.append(format + " : ");
			writer.append(msg);
			writer.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		
	
	}

}
