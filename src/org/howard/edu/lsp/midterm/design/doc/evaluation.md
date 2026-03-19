Precious Ikejiofor
Professor Woolfolk
CSCI 363
19 March 2026

Design Evaluation - OrderProcessor Class

Identified Design Issues

1. Poor Encapsulation
The class puts everything out in the open with public fields like customerName, email, item, and price. This is bad because any other class can just walk in and change these values whenever they want with no checks at all. In good OOP, data should be hidden inside the class so the class can control how it's accessed and changed.

2. Single Responsibility Principle Violation
The processOrder() method does way too many things. It calculates tax, prints receipts, writes to files, sends emails, applies discounts, and logs stuff. That's like six different jobs for one method. If something needs to change about how emails are sent, I have to come into this same class and mess with it even though it has nothing to do with the other stuff.

3. Hard-coded Dependencies
Everything is just typed right into the code. Tax rate is 0.07 and that's it. Discount kicks in at $500 and gives 10% off, but that's just written there. File name is always "orders.txt". If I need to change any of these things, I have to actually change the code and recompile. Can't just configure it differently for different situations.

4. Lack of Abstraction
The class does everything itself instead of using other classes to handle specific jobs. It writes to files right there in the method. It prints to console right there. If I wanted to write to a database instead of a file, I'd have to rewrite this whole method. There's no separation between the different kinds of work being done.

5. Mixed Concerns
Business logic and infrastructure stuff are all mixed together. Tax calculation (which is business logic) is right next to file writing (which is infrastructure). This makes the code hard to read and harder to change because everything is connected to everything else.

6. Poor Error Handling
The catch block just prints the error and keeps going. There's no way for the code that called this method to know if anything went wrong. The order might fail but the program just moves on like nothing happened. This could cause big problems.

7. Timing Issues
The discount gets applied after printing the receipt and saving to file. So the receipt shows the wrong total and the file saves the wrong total, but the email would show the right total (if it actually sent emails, but it just prints to console). This is inconsistent and confusing.

Consequences for Maintainability and Extensibility

This design is going to be a nightmare to maintain. Changing anything means touching this one big class and hoping nothing breaks. Adding a new feature means more code in an already bloated class. Testing is hard because the method does so many things and touches files and console output. If the business rules change, like tax rates or discount policies, I have to modify and recompile this class. If I want to reuse the tax calculation somewhere else, I can't because it's buried in this method. This class is what they call a "god class" and it's going to cause problems down the road.