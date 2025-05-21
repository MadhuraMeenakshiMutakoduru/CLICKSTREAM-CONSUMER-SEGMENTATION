package com.clickstream.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
	
	private static Integer safeParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for value: " + value);
            return 0; // Or some default value
        }
    }
    public static List<Customer> readCsv(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Flag to skip header line

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Trim whitespace around the line
                if (isHeader) {
                    isHeader = false; // Skip header line
                    continue; // Continue to next iteration
                }

                // Skip empty lines
                if (line.isEmpty()) {
                    continue; 
                }

                // Split line by comma (handling spaces if needed)
                String[] values = line.split(",\\s*"); // Use regex to handle space after comma

                // Ensure that you have the expected number of values
                if (values.length < 16) {
                    System.out.println("Skipping invalid line: " + line);
                    continue; // Skip lines with insufficient data
                }

                // Create a new Customer object and add it to the list
                Customer customer = new Customer(
                	    values[0],                       // Shopping ID
                	    values[1],                       // Customer Name
                	    safeParseInt(values[2]),        // Age
                	    values[3],                       // Gender
                	    values[4],                       // Income Level
                	    values[5],                       // Purchase Frequency
                	    values[6],                       // Loyalty Level
                	    values[7],                       // Region
                	    values[8],                       // Lifestyle
                	    values[9],                       // Product Preference
                	    safeParseInt(values[10]),       // Pages Visited
                	    safeParseInt(values[11]),       // Time on Site (mins)
                	    safeParseInt(values[12]),       // Products Clicked
                	    values[13],                      // Categories Explored
                	    values[14],                      // Exit Page
                	    safeParseInt(values[15])        // Purchase Intent
                	);

                customers.add(customer); // Add the customer to the list
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return customers;
    }
    
    
}
