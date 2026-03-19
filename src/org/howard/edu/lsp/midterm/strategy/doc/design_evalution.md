Precious Ikejiofor
Professor Woolfolk
CSCI 363
19 March 2026

Design Evaluation - PriceCalculator Class

Maintenance and Extensibility Problems

1. Violation of Open/Closed Principle
If I want to add a new customer type, I have to go into the PriceCalculator class and change the calculatePrice method. This is bad because the class should be open for extension but closed for modification. Every time I add a new type, I risk breaking the existing ones.

2. Conditional Complexity
The method uses a bunch of if statements checking strings. As more customer types get added, this is just going to grow and grow. Eventually it'll be this huge wall of if statements that's hard to read and easy to mess up.

3. String-based Type Safety
Using strings for customer types is asking for trouble. If someone types "MEMBR" instead of "MEMBER", the code won't catch it and the customer will just get the regular price with no discount. The compiler can't help catch these kinds of mistakes.

4. Tight Coupling
The pricing logic is all tied up with the customer type checking. I can't test just the VIP discount calculation by itself because it's buried in this method with all the other logic. There's no way to reuse these calculations elsewhere.

5. Poor Extensibility
Every new pricing strategy means more if statements in this one method. The class just keeps getting bigger and bigger. Over time it becomes this monster class that nobody wants to touch because they're afraid of breaking something.

6. Violation of Separation of Concerns
This method is doing two different things. It's figuring out which customer type it has, and it's calculating discounts. Those are two different concerns that should be separated.

7. Duplicate Code Pattern
If I ever have two customer types that need the same discount, I'd have to duplicate the calculation in two different if blocks. That's not good.

8. Difficult to Unit Test
To test all the discount calculations, I have to test them through this one method. I can't test each discount in isolation. This makes unit testing harder than it needs to be.

Example of Future Problems

If the company wants to add seasonal discounts that change every month, or customer-specific discounts, or discounts based on how many items someone buys, this design falls apart. I'd have to keep adding more and more if statements and the method would become impossible to manage. The whole thing needs to be redesigned.