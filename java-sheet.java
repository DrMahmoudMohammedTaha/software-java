

// Declaring Variables
byte age = 30;
long viewsCount = 3_123_456L;
float price = 10.99F;
char letter = ‘A’;
boolean isEligible = true;

// In Java, we terminate statements with a semicolon.

// Type Bytes Range
byte 1 [-128, 127]
short 2 [-32K, 32K]
int 4 [-2B, 2B]
long 8
float 4
double 8
char 2 A, B, C, …
boolean 1 true / false

// We enclose characters with single quotes and strings (series of characters) with double quotes.
// The default integer type in Java is int. To represent a long value, we should add L to it as a postfix.
// The default floating-point type in Java is double. To represent a float, we should append F to it as a postfix.

// Comments
// This is a comment and it won’t get executed.

// Reference Types
// In Java we have 8 primitive types. All the other types are reference types. These
// types don’t store the actual objects in memory. They store the reference (or the
// address of) an object in memory.
// To use reference types, we need to allocate memory using the new operator.
Date now = new Date();

// Strings
// Strings are reference types but we don’t need to use the new operator to allocate
// memory to them. 
String name = “Mosh”;

// Useful String Methods
• startsWith(“a”)
• endsWith(“a”)
• length() 
• indexOf(“a”)
• replace(“a”, “b”)
• toUpperCase()
• toLowerCase()

// Strings are immutable, which means once we initialize them, their value cannot be
// changed. All methods that modify a string (like toUpperCase) return a new string

// Escape Sequences
• \\
• \”
• \n (new line)
• \t (tab)

// Arrays
// Creating and and initializing an array of 5 elements
int[] numbers = new int[3];
int[] numbers = { 10, 20, 30 };

// Java arrays have a fixed length (size). You cannot add or remove new items once
// If you need to add new items or remove existing items, you need to use one of the collection classes.

// The Array Class
int[] numbers = { 4, 2, 7 };
Arrays.sort(numbers);
String result = Arrays.toString(numbers);

// Multi-dimensional Arrays
// Creating a 2x3 array (two rows, three columns)
int[2][3] matrix = new int[2][3];
int[2][3] matrix = {
 { 1, 2, 3 },
 { 4, 5, 6 }
 };

// Constants
final float INTEREST_RATE = 0.04;

// By convention, we use CAPITAL LETTERS to name constants.
// Arithmetic Expressions
int x = 10 + 3;
int x = 10 - 3;
int x = 10 * 3;
int x = 10 / 3; // returns an int
float x = (float)10 / (float)3; // returns a float
int x = 10 % 3; // modulus (remainder of division)

// Increment and Decrement Operators
int x = 1;
x++; // Equivalent to x = x + 1
x--; // Equivalent to x = x - 1

// Augmented Assignment Operator
int x = 1;
x += 5; // Equivalent to x = x + 5

// Casting
// • Implicit: happens automatically when we store a value in a larger or more
// precise data type.
// • Explicit: we do it manually.
short x = 1;
int y = x;
// Explicit casting
int x = 1;
short y = (short) x;

// To convert a string to a number, we use one of the following methods:
• Byte.parseByte(“1”)
• Short.parseShort(“1”)
• Integer.parseInt(“1”)
• Long.parseLong(“1”)
• Float.parseFloat(“1.1”)
• Double.parseDouble(“1.1”)

// Formatting Numbers
NumberFormat currency = NumberFormat.getCurrencyInstance();
String result = currency.format(“123456”); // $123,456
NumberFormat percent = NumberFormat.getPercentInstance();
String result = percent(“0.04”); // 4%

// Reading Input
Scanner scanner = new Scanner(system.in);
double number = scanner.nextDouble();
byte number = scanner.nextByte();
String name = scanner.next();
String line = scanner.nextLine();

// Control Flow
// Comparison Operators
x == y // equality operator
x != y. // in-equality operator
x > y
x >= y
x < y
x <= y

// Logical Operators
• x && y (AND)
• x || y (OR)
• !x (NOT)

// If Statements
if (condition1)
 statement1
else if (condition2)
 statement2
else if (condition3)
 statement3
else
 statement4

// The Ternary Operator
String className = (income > 100_000) ? “First” : “Economy”;


// Switch Statements
switch (x) {
 case 1:
 …
 break;
 case 2:
 …
 break;
 default:
 …
}

// For Loops
for (int i = 0; i < 5; i++)
 statement

// While Loops
while (someCondition) {
 …
 if (someCondition)
 break;
}

// Do..While Loops
do {
 …
} while (someCondition);

// For-each Loops
int[] numbers = {1, 2, 3, 4};
for (int number : numbers)
 …
