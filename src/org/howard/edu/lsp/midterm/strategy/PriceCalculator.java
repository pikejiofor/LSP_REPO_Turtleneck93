/**
 * Name: Precious Ikejiofor
 */
package org.howard.edu.lsp.midterm.strategy;

/**
 * This is the context class that uses a pricing strategy.
 * It delegates price calculation to the selected strategy.
 * 
 * @author Precious Ikejiofor
 */
public class PriceCalculator {
    private PricingStrategy strategy;
    
    /**
     * Makes a calculator with the given strategy.
     * 
     * @param strategy the initial pricing strategy
     */
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Changes the pricing strategy at runtime.
     * 
     * @param strategy the new pricing strategy
     */
    public void setPricingStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Calculates price using current strategy.
     * 
     * @param originalPrice the original price
     * @return the final price
     */
    public double calculatePrice(double originalPrice) {
        return strategy.calculatePrice(originalPrice);
    }
}