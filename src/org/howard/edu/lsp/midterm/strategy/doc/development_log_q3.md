Precious Ikejiofor
Professor Woolfolk
CSCI 363
19 March 2026

Development Log - Question 3

External Resources Used

AI Tool: Claude
Date: March 19, 2026

Prompt 1:
"What files do I need for question 3 with the Strategy Pattern? I need to refactor the PriceCalculator class"

Response:
Told me I need to create PricingStrategy interface, then concrete classes for RegularPricingStrategy, MemberPricingStrategy, VIPPricingStrategy, and HolidayPricingStrategy. Also need a PriceCalculator class that uses the strategy and a Driver class to test it. All need to go in org/howard/edu/lsp/midterm/strategy/ and the doc files in the doc folder.

Prompt 2:
"Can you show me what the directory structure should look like for question 3?"

Response:
Showed me a tree with strategy/ containing all the Java files and a doc/ folder inside that for the markdown files. This helped me organize everything the right way.

Prompt 3:
"How should I format my Javadoc for the Strategy Pattern classes? Keep it simple like before"

Response:
Told me to keep the same simple style. Class comments like "This is the pricing strategy for MEMBER customers" and method comments like "Applies 10% discount to original price." Use @param and @return tags where needed and put my name at the top.

Online Resource: Refactoring Guru - Strategy Pattern
URL: https://refactoring.guru/design-patterns/strategy

How it helped:
I looked at this to understand the Strategy Pattern better. The diagrams showed how the Context, Strategy interface, and Concrete Strategies all fit together. This helped me structure my classes correctly.

Online Resource: Baeldung - Strategy Pattern in Java
URL: https://www.baeldung.com/java-strategy-pattern

How it helped:
I looked at their code examples to see how to implement the pattern. Their discount example was pretty much exactly what I needed for this assignment.

No other external resources were used.