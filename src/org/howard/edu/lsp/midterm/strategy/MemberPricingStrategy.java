/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the pricing strategy for MEMBER customers.
 * 10% discount is applied.
 * 
 * @author Precious Ikejiofor
 */
public class MemberPricingStrategy implements PricingStrategy {
    private static final double DISCOUNT_RATE = 0.90; // 10% off
    
    /**
     * Applies 10% discount to original price.
     * 
     * @param originalPrice the original price
     * @return the price after discount
     */
    public double calculatePrice(double originalPrice) {
        return originalPrice * DISCOUNT_RATE;
    }
}