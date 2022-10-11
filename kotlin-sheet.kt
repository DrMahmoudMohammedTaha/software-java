
// online kotlin compilers
// https://www.w3schools.com/kotlin/trykotlin.php?filename=demo_helloworld
// https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS41LjMxIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS4gXG4gKiBwbGF5LmtvdGxpbmxhbmcub3JnIFxuICovXG5cbmZ1biBtYWluKCkge1xuICAgIHByaW50bG4oXCJIZWxsbywgd29ybGQhISFcIilcbn0ifQ==
// https://www.jdoodle.com/compile-kotlin-online/

// define function in koltin
fun main() {
  println(3 + 3)
}

// define function with return 
fun myFunction(x: Int, y: Int): Int {
  return (x + y)
}

// anther way for function with return 
fun myFunction(x: Int, y: Int) = x + y

// To create a variable, use var or val, and assign a value 
// to it with the equal sign (=):
// The difference between var and val is that variables 
// declared with the var keyword can be changed/modified, while val variables cannot.
var name = "John"
val birthyear = 1975

// Kotlin is smart enough to understand that "John" is a String (text), 
// and that 1975 is an Int (number) variable.
var name: String = "John" // String
val birthyear: Int = 1975 // Int

// You can also declare a variable without assigning the value, 
// and assign the value later. However, this is only possible 
// when you specify the type

// this will generate error
var name
name = "John"

// data types
val myNum: Int = 5                // Int
val myDoubleNum: Double = 5.99    // Double
val myLetter: Char = 'D'          // Char
val myBoolean: Boolean = true     // Boolean
val myText: String = "Hello"      // String

// access string
var txt = "Hello World"
println(txt[0]) // first element (H)
println(txt[2]) // third element (l)

// string interpolation
var firstName = "John"
var lastName = "Doe"
println("My name is $firstName $lastName")

// arrays 
val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
println(cars.size)

// check in range
val nums = arrayOf(2, 4, 6, 8)
if (2 in nums) {
  println("It exists!")
} else {
  println("It does not exist.")
}

// define class
class Car {
  var brand = ""
  var model = ""
  var year = 0
}

// anther way define class
class Car(var brand: String, var model: String, var year: Int)
fun main() {
  val c1 = Car("Ford", "Mustang", 1969)
    
  println(c1.brand)
  println(c1.model)
  println(c1.year)
}

// inheritance
// Superclass
open class MyParentClass {
  val x = 5
}
// Subclass
class MyChildClass: MyParentClass() {
  fun myFunction() {
    println(x) // x is now inherited from the superclass
  }
}
// Create an object of MyChildClass and call myFunction
fun main() {
  val myObj = MyChildClass()
  myObj.myFunction()
}

////////////////////////////////////////////////////
// java to kotlin (differences)
///////////////////////////////////////////////////

// Java
System.out.print("Hello, World!");
System.out.println("Hello, World!");
// Kotlin
print("Hello, World!")
println("Hello, World!")

// Variables
// Java
int w;
int z = 2;
z = 3;
w = 1;
// Kotlin
var w: Int
var z = 2
z = 3
w = 1 

// Null I
// Java
final String name = null;
String lastName;
lastName = null
// Kotlin
val name: String? = null
var lastName: String?
lastName = null
var firstName: String
firstName = null // Compilation error!!

// Null II
// Java
if(text != null){
  int length = text.length();
}
// Kotlin
val length = text?.length
val length = text!!.length // NullPointerException if text == null

// Strings I
// Java
String name = "John";
String lastName = "Smith";
String text = "My name is: " + name + " " + lastName;
String otherText = "My name is: " + name.substring(2);
// Kotlin
val name = "John"
val lastName = "Smith"
val text = "My name is: $name $lastName"
val otherText = "My name is: ${name.substring(2)}"

// Strings II
// Java
String text = "First Line\n" +
              "Second Line\n" +
              "Third Line";
// Kotlin
val text = """
        |First Line
        |Second Line
        |Third Line
""".trimMargin()

// Ternary Operator
// Java
String text = x > 5 ? "x > 5" : "x <= 5";
// Kotlin
val text = if (x > 5)
              "x > 5"
            else "x <= 5"

// Bits Operations
// Java
final int andResult  = a & b;
final int orResult   = a | b;
final int xorResult  = a ^ b;
final int rightShift = a >> 2;
final int leftShift  = a << 2;
// Kotlin
val andResult  = a and b
val orResult   = a or b
val xorResult  = a xor b
val rightShift = a shr 2
val leftShift  = a shl 2

// Is As In
// Java
if(x instanceof Integer){ }
final String text = (String) other;
if(x >= 0 && x <= 10 ){}
// Kotlin
if (x is Int) { }
val text = other as String
if (x in 0..10) { }

// Smart Cast
// Java
if(a instanceof String){
  final String result = ((String) a).substring(1);
}
// Kotlin
if (a is String) {
  val result = a.substring(1)
}

// Switch / When
// Java
final int x = // value;
final String xResult;
switch (x){
  case 0:
  case 11:
    xResult = "0 or 11";
    break;
  case 1:
  case 2:
    //...
  case 10:
    xResult = "from 1 to 10";
    break;
  default:
    if(x < 12 && x > 14) {
      xResult = "not from 12 to 14";
      break;
    }

    if(isOdd(x)) {
      xResult = "is odd";
      break;
    }

    xResult = "otherwise";
}
final int y = // value;
final String yResult;

if(isNegative(y)){
  yResult = "is Negative";
} else if(isZero(y)){
  yResult = "is Zero";
}else if(isOdd(y)){
  yResult = "is Odd";
}else {
  yResult = "otherwise";
}
// Kotlin
val x = // value
val xResult = when (x) {
  0, 11 -> "0 or 11"
  in 1..10 -> "from 1 to 10"
  !in 12..14 -> "not from 12 to 14"
  else -> if (isOdd(x)) { "is odd" } else { "otherwise" }
}
val y = // value
val yResult = when {
  isNegative(y) -> "is Negative"
  isZero(y) -> "is Zero"
  isOdd(y) -> "is odd"
  else -> "otherwise"
}

// For
// Java
for (int i = 1; i < 11 ; i++) { }
for (int i = 1; i < 11 ; i+=2) { }
for (String item : collection) { }
for (Map.Entry<String, String> entry: map.entrySet()) { }
// Kotlin
for (i in 1 until 11) { }
for (i in 1..10 step 2) {}
for (item in collection) {}
for ((index, item) in collection.withIndex()) {}
for ((key, value) in map) {}

// Collections
// Java
final List<Integer> numbers = Arrays.asList(1, 2, 3);
final Map<Integer, String> map = new HashMap<Integer, String>();
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");
// Java 9
final List<Integer> numbers = List.of(1, 2, 3);
final Map<Integer, String> map = Map.of(1, "One",
                                        2, "Two",
                                        3, "Three");
// Kotlin
val numbers = listOf(1, 2, 3)
val map = mapOf(1 to "One",
                2 to "Two",
                3 to "Three")

// Collections
// Java
for (int number : numbers) {
  System.out.println(number);
}
for (int number : numbers) {
  if(number > 5) {
    System.out.println(number);
  }
}
// Kotlin
numbers.forEach {
    println(it)
}
numbers.filter  { it > 5 }
       .forEach { println(it) }

// Collections
// Java
final Map<String, List<Integer>> groups = new HashMap<>();
for (int number : numbers) {
  if((number & 1) == 0){
    if(!groups.containsKey("even")){
      groups.put("even", new ArrayList<>());
    }

    groups.get("even").add(number);
    continue;
  }

  if(!groups.containsKey("odd")){
    groups.put("odd", new ArrayList<>());
  }

  groups.get("odd").add(number);
}
// or
Map<String, List<Integer>> groups = items.stream().collect(
  Collectors.groupingBy(item -> (item & 1) == 0 ? "even" : "odd")
);
// Kotlin
val groups = numbers.groupBy {
                if (it and 1 == 0) "even" else "odd"
             }

// Collections
// Java
final List<Integer> evens = new ArrayList<>();
final List<Integer> odds = new ArrayList<>();
for (int number : numbers){
  if ((number & 1) == 0) {
    evens.add(number);
  }else {
    odds.add(number);
  }
}
// Kotlin
val (evens, odds) = numbers.partition { it and 1 == 0 }

// Collections
// Java
final List<User> users = getUsers();
Collections.sort(users, new Comparator<User>(){
  public int compare(User user, User otherUser){
    return user.lastname.compareTo(otherUser.lastname);
  }
});
// or
users.sort(Comparator.comparing(user -> user.lastname));
// Kotlin
val users = getUsers()
users.sortedBy { it.lastname }
