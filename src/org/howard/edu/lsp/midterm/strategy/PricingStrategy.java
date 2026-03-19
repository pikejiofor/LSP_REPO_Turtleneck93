/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the strategy interface for calculating prices.
 * All pricing strategies must implement this.
 * 
 * @author Precious Ikejiofor
 */
public interface PricingStrategy {
    /**
     * Calculates final price based on original price.
     * 
     * @param originalPrice the original price
     * @return the final price
     */
    double calculatePrice(double originalPrice);
}