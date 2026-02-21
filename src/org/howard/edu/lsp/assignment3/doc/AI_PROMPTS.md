# AI Prompts for Assignment 3

## Prompt 1
**Me:**
I have an ETL program from Assignment 2 that's all in one class. It reads a CSV file, transforms the data, and writes a new file. How do I make it object-oriented? What classes should I make?

**AI:**
Look at what your program does. It has three main jobs: handling files, holding product data, and running the process. You could make three classes: one for products, one for file operations, and one to run everything. This way each class has one job.

## Prompt 2
**Me:**
What should go in the Product class?

**AI:**
The Product class should have the data that describes a product: id, name, price, category, and price range. Make these variables private so nothing outside can change them directly. Add methods like transform() that changes the product data, and toCSVString() that turns the product back into text for writing to a file. Also add a method to create a product from a line in the CSV file.

## Prompt 3
**Me:**
What about the file class? What should it do?

**AI:**
The file class should handle everything with files. Methods to check if a file exists, read all products from the input file, write products to the output file, and keep track of how many rows were skipped. This way if you need to change how files are read later, you only change this one class.

## Prompt 4
**Me:**
How do I handle bad data like empty lines or wrong number of columns?

**AI:**
Check for bad data when you're creating a Product object. If the line is empty, has wrong number of columns, or has invalid numbers, print an error message with the line number and return null. Don't add it to the list of products. Keep a counter of how many rows were skipped.

## Prompt 5
**Me:**
How do I make sure my new program works exactly like my old one?

**AI:**
Run both programs with the same input file. Compare the output files - they should be identical. Compare the console output too - the messages should be the same. Test edge cases like empty files, missing files, and files with bad data. Both programs should act the same way.

## Prompt 6
**Me:**
What's the simplest way to write this? I don't want it to be complicated.

**AI:**
Keep it simple. Three classes is enough. Don't try to use fancy design patterns if you don't need them. Just make sure each class has one clear job and data is kept inside objects. Use private variables and public methods to work with them.

## Prompt 7
**Me:**
How do I write those Javadoc comments?

**AI:**
Put /** before each class and each public method. Write one sentence saying what it does. If it takes parameters, use @param to explain them. If it returns something, use @return. Keep it short and simple.