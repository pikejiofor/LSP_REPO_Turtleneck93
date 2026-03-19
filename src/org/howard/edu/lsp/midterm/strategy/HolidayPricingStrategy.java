/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the pricing strategy for HOLIDAY customers.
 * 15% discount is applied.
 * 
 * @author Precious Ikejiofor
 */
public class HolidayPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_RATE = 0.85; // 15% off
    
    /**
     * Applies 15% discount to original price.
     * 
     * @param originalPrice the original price
     * @return the price after discount
     */
    public double calculatePrice(double originalPrice) {
        return originalPrice * DISCOUNT_RATE;
    }
}