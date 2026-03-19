/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the pricing strategy for VIP customers.
 * 20% discount is applied.
 * 
 * @author Precious Ikejiofor
 */
public class VIPPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_RATE = 0.80; // 20% off
    
    /**
     * Applies 20% discount to original price.
     * 
     * @param originalPrice the original price
     * @return the price after discount
     */
    public double calculatePrice(double originalPrice) {
        return originalPrice * DISCOUNT_RATE;
    }
}