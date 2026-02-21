package org.howard.edu.lsp.assignment3;

/**
 * Represents a single product with all its data
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private String category;
    private String priceRange;
    
    // Private constructor - use createFromLine instead
    private Product() {}
    
    /**
     * Creates a product from a CSV line
     * Returns null if the line is invalid
     */
    public static Product createFromLine(String line, int lineNum) {
        // Skip empty lines
        if (line.isEmpty()) {
            System.out.println("Skipped line " + lineNum + ": empty line");
            return null;
        }
        
        // Split by commas
        String[] parts = line.split(",");
        
        // Need exactly 4 parts
        if (parts.length != 4) {
            System.out.println("Skipped line " + lineNum + ": wrong number of columns");
            return null;
        }
        
        // Clean up the parts
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        
        Product p = new Product();
        
        // Parse ID
        try {
            p.id = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Skipped line " + lineNum + ": invalid product ID");
            return null;
        }
        
        // Get name
        p.name = parts[1];
        
        // Parse price
        try {
            p.price = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Skipped line " + lineNum + ": invalid price format");
            return null;
        }
        
        // Get category
        p.category = parts[3];
        
        return p;
    }
    
    /**
     * Applies all transformations to this product
     */
    public void transform() {
        String oldCategory = this.category;
        
        System.out.println("Processing: " + this.name + 
                          " ($" + String.format("%.2f", this.price) + 
                          ", " + this.category + ")");
        
        // Step 1: Uppercase name
        this.name = this.name.toUpperCase();
        System.out.println("  Name to uppercase: " + this.name);
        
        // Step 2: Discount for Electronics
        if (this.category.equals("Electronics")) {
            this.price = this.price * 0.90;
            System.out.println("  Electronics discount: $" + String.format("%.2f", this.price));
        }
        
        // Step 3: Round price
        this.price = Math.round(this.price * 100.0) / 100.0;
        System.out.println("  Rounded price: $" + String.format("%.2f", this.price));
        
        // Step 4: Check for Premium Electronics
        if (this.price > 500.00 && oldCategory.equals("Electronics")) {
            this.category = "Premium Electronics";
            System.out.println("  Upgraded to: " + this.category);
        }
        
        // Step 5: Set price range
        if (this.price <= 10.00) {
            this.priceRange = "Low";
        } else if (this.price <= 100.00) {
            this.priceRange = "Medium";
        } else if (this.price <= 500.00) {
            this.priceRange = "High";
        } else {
            this.priceRange = "Premium";
        }
        System.out.println("  Price range: " + this.priceRange);
    }
    
    /**
     * Converts product to CSV format
     */
    public String toCSVString() {
        return id + "," + name + "," + 
               String.format("%.2f", price) + "," + 
               category + "," + priceRange;
    }
}