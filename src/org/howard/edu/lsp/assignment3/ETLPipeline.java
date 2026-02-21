package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.*;

/**
 * Main class that runs the ETL pipeline
 */
public class ETLPipeline {
    
    public static void main(String[] args) {
        ETLPipeline pipeline = new ETLPipeline();
        pipeline.runETL();
    }
    
    public void runETL() {
        System.out.println("Starting ETL Pipeline...");
        System.out.println();
        
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";
        
        // Create FileProcessor to handle file operations
        FileProcessor processor = new FileProcessor();
        
        // Check if input file exists
        if (!processor.checkFileExists(inputFile)) {
            System.out.println("ERROR: File 'data/products.csv' not found.");
            System.out.println("Make sure the file exists in the data folder!");
            return;
        }
        
        // Make sure data folder exists
        processor.createDataFolder();
        
        try {
            // Read all products from file
            ArrayList<Product> products = processor.readProducts(inputFile);
            
            System.out.println("Reading from: " + inputFile);
            System.out.println("Writing to: " + outputFile);
            System.out.println();
            System.out.println("Processing data...");
            
            // Transform each product
            ArrayList<Product> transformedProducts = new ArrayList<>();
            
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                p.transform();
                transformedProducts.add(p);
                
                // Show first 3 processed items
                if (i < 3) {
                    System.out.println("Processed: " + p.toCSVString());
                }
            }
            
            // Write to output file
            processor.writeProducts(outputFile, transformedProducts);
            
            // Show summary
            processor.printSummary(products.size(), transformedProducts.size(), outputFile);
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}