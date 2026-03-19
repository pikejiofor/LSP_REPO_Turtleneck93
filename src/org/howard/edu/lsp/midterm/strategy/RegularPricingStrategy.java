/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the pricing strategy for REGULAR customers.
 * No discount is applied.
 * 
 * @author Precious Ikejiofor
 */
public class RegularPricingStrategy implements PricingStrategy {
    
    /**
     * Returns original price with no discount.
     * 
     * @param originalPrice the original price
     * @return the original price
     */
    public double calculatePrice(double originalPrice) {
        return originalPrice;
    }
}