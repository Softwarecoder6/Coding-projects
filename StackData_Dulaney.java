/*David Dulaney UHCL ID 2344357
In this homework assignment, by using a stack. We are to be able to take in a string
and be able to add words to the sentence, as well as delete words, undo and redo actions as many times as the user wants.
 */
import java.util.Scanner;
public class StackData_Dulaney<Anystring_type>
{
/**
* Construct the stack.
*/
public StackData_Dulaney( )
{
this( DEFAULT_CAPACITY );
}
/**
* Construct the stack.
* @param capacity the capacity.
*/
public StackData_Dulaney( int capacity )
{
theArray = new Object[ capacity ];
topOfStack = -1;
}
/**
* Test if the stack is logically empty.
* @return true if empty, false otherwise.
*/
public boolean isEmpty( )
{
return topOfStack == -1;
}
/**
 *  * Test if the stack is logically full.
 * @return true if full, false otherwise.
 */
public boolean isFull( )
{
return topOfStack == theArray.length - 1;
}

/**
* Make the stack logically empty.
*/
public void makeEmpty( )
{
topOfStack = -1;
}
/**
* Get the most recently inserted item in the stack.
* Does not alter the stack.
* @return the most recently inserted item in the stack, or null, if empty.
 */
public Object top( )
{
if( isEmpty( ) )
return null;
return theArray[ topOfStack ];
}
public static class Underflow extends Exception
{
public Underflow()
{
super("Stack underflow: Cannot pop from empty stack.");
}
}
/**
* Remove the most recently inserted item from the stack.
* @exception Underflow if stack is already empty.
*/
public void pop() throws Underflow
{
if( isEmpty() )
throw new Underflow();
theArray[ topOfStack-- ] = null;
}
public static class Overflow extends Exception
{
public Overflow()
{
super("Stack overflow: Cannot push onto a full stack.");
}
}

/**
* Insert a new item into the stack, if not already full.
* @param x the item to insert.
* @exception Overflow if stack is already full.
*/
public void push( Object x ) throws Overflow
{
if( isFull( ) )
throw new Overflow( );
theArray[ ++topOfStack ] = x;
}
/**
* Return and remove most recently inserted item from the stack.
* @return most recently inserted item, or null, if stack is empty.
 */
public Object topAndPop( )
{
if( isEmpty( ) )
return null;
Object topItem = theArray[topOfStack];
theArray[ topOfStack-- ] = null;
return topItem;
}
private Object [] theArray;
private int topOfStack;

static final int DEFAULT_CAPACITY = 25;

public static void main( String [ ] args ) throws StackData_Dulaney.Overflow, StackData_Dulaney.Underflow
{

/*Created a scanner to read inputs as well as create an empty array of length 25 that holds strings
Initialized and declare an integer(type_tracker) as well as initialize and declare a string(stored_word)
Created three stacks called stack undo and redo to hold each string
Output "Enter a sentence" and take the user's next input
Initialize and declare string(Initial_Sentence) to have the value of the user's input and split the sentence by the spaces
Create an array that holds strings(words) and its length is the size of the amount of words that were split
create a for loop to push each word from that array to the main stack
 */
Scanner input = new Scanner(System.in);
String[] string_type = new String[25];
int type_tracker = 0;
String stored_word;
StackData_Dulaney<String> stack = new StackData_Dulaney<String>();
StackData_Dulaney<String> undo = new StackData_Dulaney<String>();
StackData_Dulaney<String> redo = new StackData_Dulaney<String>();
System.out.print("Enter a sentence: ");
String Initial_sentence = input.nextLine();
String[] words = Initial_sentence.split(" ");
for (int i = 0; i < words.length; i++) 
{
stack.push(words[i]);
}

/*While boolean is true, output the menu options to user and read user's next input and go to case based on input
 */
while (true)
{
System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n","Pick an option for your sentence:",
"1. Add.","2. Undo","3. Redo.","4. Delete.", "5. Print sentence.", "6. Exit.");
int question = input.nextInt();
input.nextLine();
switch(question)
{

/*Case 1 reads user's next input then pushes the word onto the main and undo stack
The array at index equal to the integer type_tracker has the string "added" inserted in that index
increment type_tracker and make the redo stack empty then break the case
 */
case 1:
System.out.println("Enter a word to add: ");
String word = input.nextLine();
stack.push(word);
undo.push(word);
string_type[type_tracker] = "added";
type_tracker++;
redo.makeEmpty();
break;

/*Case 2 starts with an if statement to check if the undo stack is not empty
if it is not empty, then decrement type_tracker and check to see if the index of the array string_type at index type_tracker
is equal to the string "added". If so then check the top word of the main stack and pop it, then push that word onto the redo stack
else if the index of the array string_type at index type_tracker's string is equal to "deleted", then check the top word of the undo stack then pop it
and push it onto the main stack
else if the undo stack is empty, then output cannot undo
 */
case 2:
if(!undo.isEmpty())
{
type_tracker--;
if(string_type[type_tracker].equals("added"))
redo.push(stack.topAndPop());
else if(string_type[type_tracker] .equals("deleted"))
stack.push(undo.topAndPop());
}
else
System.out.println("Cannot undo.");
break;

/*Case 3 starts with an if statement to check if the redo stack is not empty
if it is not empty, then check to see if the index of the array string_type at index type_tracker
is equal to the string "added". If so then check the top word of the redo stack and pop it, then push that word onto the main stack
else if the index of the array string_type at index type_tracker's string is equal to "deleted", then check the top word of the main stack then pop it
then check the top word of the main stack and push it into the undo stack and increment type_tracker
else if the undo stack is empty, then output cannot redo */
case 3:
if(!redo.isEmpty())
{
if(string_type[type_tracker].equals("added"))
stack.push(redo.topAndPop());
else if(string_type[type_tracker].equals("deleted"))
stack.topAndPop();
undo.push(stack.top());
type_tracker++;
}
else
System.out.println("Cannot redo.");
break;

/*String stored word is equal to the string that is checked and popped from the main stack then push that word onto the undo stack
if the index of the array string_type at index type_tracker's string is equal to "deleted", then increment type_tracker and push the stored word onto the redo stack
 */
case 4:
stored_word = (String) stack.topAndPop();
undo.push(stored_word);
string_type[type_tracker] = "deleted";
type_tracker++;
redo.push(stored_word);
break;

/*Case 5 outputs the current sentence based on modifications through a for loop that prints the words from the stack referring to an array */
case 5:
System.out.print("Sentence: ");
for (int i = 0; i <= stack.topOfStack; i++) 
{
System.out.printf("%s ",stack.theArray[i]);
}
System.out.println();
break;

/*Case 6 closing the program */
case 6:
System.out.println("Goodbye!");
input.close();
return;

/*Lets user know, they did enter a correct input */
default:
System.out.println("Wrong input, re-enter input");
}
}
}
}