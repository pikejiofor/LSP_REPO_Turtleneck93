```markdown
# Reflection: Assignment 2 vs Assignment 3

**Name:** Precious Ikejiofor  
**Course:** CSCI 363  
**Assignment:** 3  

---

## What's different about the design?

### Assignment 2
- One big class called `ETLPipeline.java` that did everything
- All methods were in the same file
- Data was passed around as string arrays
- File reading, transformation, and printing were all mixed together

### Assignment 3
- Three separate classes with clear jobs:
  - `ETLPipeline.java` - runs the program and coordinates everything
  - `FileProcessor.java` - handles all file reading and writing
  - `Product.java` - represents one product and knows how to transform itself
- Each class has one responsibility
- Data is stored in objects with fields instead of arrays
- Products know how to transform themselves

---

## How is Assignment 3 more object-oriented?

### 1. Using Objects
**Assignment 2:** I stored product data in string arrays and passed them around.

**Assignment 3:** I create Product objects that hold their own data:
```java
Product product = Product.createFromLine(line, lineNumber);
product.transform();
String output = product.toCSVString();
```

### 2. Encapsulation
I hid the internal details of each class:
```java
public class Product {
    private int id;        // can't access from outside
    private String name;   // private means hidden
    private double price;
    
    public void transform() { ... }  // public methods to work with the object
}
```
Outside code can't change the product's data directly. They have to use the methods.

### 3. Clear Class Responsibilities
Each class has one job:
- **Product** - holds product data and transformation rules
- **FileProcessor** - reads/writes files and tracks stats
- **ETLPipeline** - runs the whole process

This makes the code easier to understand and change.

### 4. State and Behavior Together
**Assignment 2:** Data and logic were separate. Methods worked ON data.

**Assignment 3:** Data and logic are together. Objects work ON THEMSELVES.

---

## Which OO ideas did I use?

| OO Concept | How I used it |
|------------|---------------|
| **Class** | Made 3 classes: ETLPipeline, FileProcessor, Product |
| **Object** | Created Product objects from each valid CSV row |
| **Encapsulation** | Made fields private, added public methods to work with them |
| **Constructor** | Used private constructor + factory method (createFromLine) |

I didn't use inheritance or polymorphism because this program is simple and didn't need them. That's okay - OOP is about using what makes sense, not using every concept.

---

## How I tested to make sure it works the same

### Test 1: Normal Input
- Ran both programs with the same `products.csv` file
- Compared the output files - they were exactly the same
- Counted the same number of transformed rows (7)

### Test 2: Empty File
- Created an empty `products.csv`
- Both programs created a file with just the header row
- Both showed 0 rows processed

### Test 3: Missing File
- Removed `products.csv`
- Both programs showed error message and stopped
- Both didn't create an output file

### Test 4: Bad Data
- Created a file with empty lines, wrong columns, and invalid numbers
- Both programs skipped the SAME bad rows
- Both transformed the SAME good rows
- Output files matched exactly

### Test 5: Console Output
- Ran both and saved the console output
- Messages were the same:
  - Same "Processing: ProductName..." lines
  - Same transformation steps shown
  - Same final statistics
  - Same skipped row messages with line numbers

### Test 6: Price Calculations
- Checked electronics discount (10% off)
- Checked rounding to 2 decimal places
- Checked "Premium Electronics" upgrade (price > $500)
- Checked price ranges (Low, Medium, High, Premium)
- All matched Assignment 2 exactly

---

## What I learned

1. **Object-oriented design is about organizing code better**, not changing what it does.

2. **Encapsulation makes code safer** - when data is private, other code can't accidentally mess it up.

3. **Single Responsibility makes code easier to work with** - if there's a bug in file reading, I know exactly where to look (FileProcessor). If there's a bug in transformation, I check Product.

4. **Testing is important** - without comparing outputs, I couldn't be sure my new code worked the same as the old code.

5. **Simple OOP is better than complicated OOP** - I didn't need inheritance or polymorphism for this project, so I didn't use them.

---

## Conclusion

Assignment 3 does the EXACT same thing as Assignment 2. The input is the same, the transformations are the same, the output file is the same, and the console messages are the same.

The only difference is HOW the code is organized. Assignment 3 is better because:
- Each class has one clear job
- Data is hidden inside objects
- The code is easier to read and change
- If I need to add features later, it will be easier
