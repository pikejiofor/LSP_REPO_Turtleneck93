/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This class demonstrates the Strategy Pattern.
 * It tests all customer types with a base price of 100.0.
 * 
 * @author Precious Ikejiofor
 */
public class Driver {
    
    /**
     * Main method that runs the demonstration.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        double basePrice = 100.0;
        
        // Test REGULAR customer
        PriceCalculator calculator = new PriceCalculator(new RegularPricingStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(basePrice));
        
        // Test MEMBER customer
        calculator.setPricingStrategy(new MemberPricingStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(basePrice));
        
        // Test VIP customer
        calculator.setPricingStrategy(new VIPPricingStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(basePrice));
        
        // Test HOLIDAY customer
        calculator.setPricingStrategy(new HolidayPricingStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(basePrice));
    }
}