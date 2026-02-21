package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

/**
 * Handles all file reading and writing
 */
public class FileProcessor {
    private int validRows = 0;
    private int skippedRows = 0;
    
    public boolean checkFileExists(String filepath) {
        File f = new File(filepath);
        return f.exists();
    }
    
    public void createDataFolder() {
        File folder = new File("data");
        if (!folder.exists()) {
            System.out.println("Creating data folder...");
            folder.mkdir();
        }
    }
    
    public ArrayList<Product> readProducts(String filepath) throws FileNotFoundException {
        ArrayList<Product> products = new ArrayList<>();
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);
        
        // Skip header line
        if (scanner.hasNextLine()) {
            String header = scanner.nextLine();
            System.out.println("Found header: " + header);
        }
        
        int lineNumber = 1;
        
        // Read each line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            lineNumber++;
            
            // Try to create product from line
            Product p = Product.createFromLine(line, lineNumber);
            
            if (p != null) {
                products.add(p);
                validRows++;
            } else {
                skippedRows++;
            }
        }
        
        scanner.close();
        return products;
    }
    
    public void writeProducts(String filepath, ArrayList<Product> products) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filepath));
        
        // Write header
        writer.println("ProductID,Name,Price,Category,PriceRange");
        
        // Write each product
        for (Product p : products) {
            writer.println(p.toCSVString());
        }
        
        writer.close();
    }
    
    public void printSummary(int totalRead, int totalValid, String outputFile) {
        System.out.println();
        System.out.println("Processing complete!");
        System.out.println();
        System.out.println("========================================");
        System.out.println("FINAL STATS");
        System.out.println("========================================");
        System.out.println("Total rows read: " + totalRead);
        System.out.println("Successfully transformed: " + totalValid);
        System.out.println("Skipped (bad data): " + skippedRows);
        
        if (skippedRows > 0) {
            System.out.println();
            System.out.println("Note: Some rows were skipped because:");
            System.out.println("  - Blank lines");
            System.out.println("  - Wrong number of columns");
            System.out.println("  - Invalid ID or price format");
        }
        
        System.out.println();
        System.out.println("Output saved to: " + outputFile);
        System.out.println("========================================");
        
        File output = new File(outputFile);
        if (output.exists()) {
            System.out.println("All done! Check " + outputFile + " for results.");
        }
    }
}