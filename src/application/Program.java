package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path:");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> votes = new LinkedHashMap<>();
			
			
			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				Integer vote = Integer.parseInt(fields[1]);
				
				if(votes.get(name) == null) {	
					votes.put(name,vote);
				}else {
					votes.put(name, vote + votes.get(name));
				}
				
				line = br.readLine();
			}
			
			for(String key : votes.keySet()) {
				System.out.println(key + ":" + votes.get(key));
			}
			
			

		}
		
		catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		

		sc.close();
	}

}


