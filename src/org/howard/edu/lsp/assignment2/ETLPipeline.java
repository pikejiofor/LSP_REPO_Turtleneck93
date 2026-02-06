package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

/*
 * Assignment 2 - CSV ETL Pipeline
 * This program reads a CSV file, transforms the data, and writes it back out
 */
public class ETLPipeline {
    
    public static void main(String[] args) {
        // Start the ETL process
        new ETLPipeline().runETL();
    }
    
    /*
     * Main method that runs the whole ETL process
     * ETL = Extract, Transform, Load
     */
    public void runETL() {
        System.out.println("Starting ETL Pipeline...");
        System.out.println();
        
        // File locations
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";
        
        // Make sure the data folder exists
        File dataFolder = new File("data");
        if (!dataFolder.exists()) {
            System.out.println("Creating data folder...");
            dataFolder.mkdir();
        }
        
        // Check if input file exists
        File input = new File(inputFile);
        if (!input.exists()) {
            System.out.println("ERROR: File 'data/products.csv' not found.");
            System.out.println("Make sure the file exists in the data folder!");
            return;
        }
        
        try {
            // Open the files
            Scanner scanner = new Scanner(input);
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
            
            System.out.println("Reading from: " + inputFile);
            System.out.println("Writing to: " + outputFile);
            System.out.println();
            
            // Write header row to output
            writer.println("ProductID,Name,Price,Category,PriceRange");
            
            // Skip header in input file
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                System.out.println("Found header: " + header);
            }
            
            // Setup counters
            int rowsRead = 0;
            int rowsTransformed = 0;
            int rowsSkipped = 0;
            
            // Process each line
            System.out.println();
            System.out.println("Processing data...");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                rowsRead++;
                
                // Check if line should be skipped
                if (shouldSkipLine(line)) {
                    rowsSkipped++;
                    System.out.println("Skipped line " + rowsRead + ": " + 
                                      (line.length() > 30 ? line.substring(0, 30) + "..." : line));
                    continue;
                }
                
                // Process valid row
                try {
                    String transformedRow = transformRow(line);
                    writer.println(transformedRow);
                    rowsTransformed++;
                    
                    // Show progress for first few rows
                    if (rowsTransformed <= 3) {
                        System.out.println("Processed: " + transformedRow);
                    }
                } catch (Exception e) {
                    rowsSkipped++;
                }
            }
            
            // Close files
            scanner.close();
            writer.close();
            
            System.out.println();
            System.out.println("Processing complete!");
            
            // Show final summary
            showSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        } catch (IOException e) {
            System.out.println("ERROR: Problem reading/writing files");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    /*
     * Checks if a row should be skipped
     */
    private boolean shouldSkipLine(String line) {
        // Skip empty lines
        if (line.isEmpty()) {
            return true;
        }
        
        // Split by commas
        String[] parts = line.split(",");
        
        // Need exactly 4 parts
        if (parts.length != 4) {
            return true;
        }
        
        // Trim whitespace
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        
        // Check if ProductID is valid
        try {
            Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return true;
        }
        
        // Check if Price is valid
        try {
            Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            return true;
        }
        
        return false;
    }
    
    /*
     * Transforms a valid row
     */
    private String transformRow(String line) {
        // Split and clean
        String[] parts = line.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        
        // Get data from columns
        int productId = Integer.parseInt(parts[0]);
        String name = parts[1];
        double price = Double.parseDouble(parts[2]);
        String category = parts[3];
        String originalCategory = category;
        
        System.out.println("Processing: " + name + " ($" + price + ", " + category + ")");
        
        // Step 1: Convert name to uppercase
        name = name.toUpperCase();
        System.out.println("  Name to uppercase: " + name);
        
        // Step 2: Apply 10% discount for Electronics
        if (category.equals("Electronics")) {
            price = price * 0.90;
            System.out.println("  Electronics discount: $" + String.format("%.2f", price));
        }
        
        // Step 3: Round to 2 decimal places
        price = Math.round(price * 100.0) / 100.0;
        System.out.println("  Rounded price: $" + String.format("%.2f", price));
        
        // Step 4: Check for Premium Electronics
        if (price > 500.00 && originalCategory.equals("Electronics")) {
            category = "Premium Electronics";
            System.out.println("  Upgraded to: " + category);
        }
        
        // Step 5: Add PriceRange
        String priceRange;
        if (price <= 10.00) {
            priceRange = "Low";
        } else if (price <= 100.00) {
            priceRange = "Medium";
        } else if (price <= 500.00) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
        System.out.println("  Price range: " + priceRange);
        
        // Format price to 2 decimal places
        String formattedPrice = String.format("%.2f", price);
        
        // Return transformed row
        return productId + "," + name + "," + formattedPrice + "," + category + "," + priceRange;
    }
    
    /*
     * Shows summary after processing
     */
    private void showSummary(int read, int transformed, int skipped, String outputFile) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("FINAL STATS");
        System.out.println("========================================");
        System.out.println("Total rows read: " + read);
        System.out.println("Successfully transformed: " + transformed);
        System.out.println("Skipped (bad data): " + skipped);
        
        if (skipped > 0) {
            System.out.println();
            System.out.println("Note: Some rows were skipped because:");
            System.out.println("  - Blank lines");
            System.out.println("  - Wrong number of columns");
            System.out.println("  - Invalid ID or price format");
        }
        
        System.out.println();
        System.out.println("Output saved to: " + outputFile);
        System.out.println("========================================");
        
        // Check if output file was created
        File output = new File(outputFile);
        if (output.exists() && output.length() > 0) {
            System.out.println("All done! Check " + outputFile + " for results.");
        } else {
            System.out.println("Note: Output file might be empty.");
        }
    }
}
