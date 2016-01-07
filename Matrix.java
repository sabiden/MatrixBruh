//Team The Bruhchowskis - Shaik Abiden, Jason Mohabir 
//APCS1 pd10
//HW55 -- Don’t Think You Are. Know You Are.
//2016-01-06

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 
import java.util.Arrays;

public class Matrix {
    
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;
    
    private Object[][] matrix;
    
    
    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }
    

    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    }
    
    
    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length * matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return get(r,c) == null;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	//Save the old val, change it with the newVal, return the old val
	Object ret = get(r,c);
	matrix[r][c] = newVal;
	return ret;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	//Go to each index of matrix and write it out, this is one row; then make new line and make the next row with the next index
	for (int i = 0; i < matrix.length; i++){
	    for (int j = 0; j < matrix[i].length; j++){
		retStr += get(i,j) + "\t";
	    }
	    retStr += "\n";
	}
	return retStr;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	//Check if rightSide is a matrix, then check the toStrings to see if they the same
	if (rightSide instanceof Matrix){
	    if (toString().equals(rightSide.toString())){
		return true;
	    }
	    else { return false; }
	}
	else{ return false; }
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	//Go to each row and switch whatever's at c1 index with what's at c2 index
	for (int i = 0; i < matrix.length; i++){
	    Object savVal = get(i,c1);
	    matrix[i][c1] = get(i,c2);
	    matrix[i][c2] = savVal;
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	//Just switching whole arrays around since each row is just an index of matrix 
	Object[] savRow = matrix[r1];
	matrix[r1] = matrix[r2];
	matrix[r2] = savRow;
    }


    //HW55 Methods


    //returns Object[] of r row
    public Object[] getRow( int r ){
	return matrix[r];
    }

    //sets r row as Object[] newRow
    //returns old row
    public Object[] setRow( int r, Object[] newRow ){
	Object[] ret = getRow(r);
	for (int c = 0; c < matrix[r].length; c++){
	    matrix[r][c] = newRow[c];
	}   
	return ret;
    }

    // returns Object[] of c column
    public Object[] getCol( int c ){
	Object[] ret = new Object[matrix.length];
	for (int r = 0; r < matrix.length; r++){
	    ret[r] = get(r,c); 
	}
	return ret;
    }
    
    //sets c column as Object[] newCol
    //returns old column
    public Object[] setCol( int c, Object[] newCol ){
	for (int r = 0; r < matrix.length; r++){
	    matrix[r][c] = newCol[r];
	}
	return getCol(c);
    }
    
    //sets matrix as tranpose
    //every value (r,c) swap with new value (c,r)
    public void transpose(){
	Object[][] trans = new Object[matrix.length][matrix.length];
	for (int r = 0; r < matrix.length; r++)
	    for (int c = 0; c < matrix[r].length ; c++)
		trans[c][r] = get(r,c);
	matrix = trans;	
    }

    //check every matrix and return if Object o is present
    public boolean contains( Object o ){
	for (Object[] r: matrix){
	    for (Object c: r){
		if ( o.equals(c) ){
		    return true;
		}
	    }
	}
	return false;
    }

    //check every matrix index for object
    public boolean isFull(){
	boolean retBool = false;
	for (int r = 0; r < matrix.length; r++){
	    for (int c = 0; c < matrix[r].length; c++){
		if (isEmpty(r,c)){return false;}
	    }
	}
	return true;
	
    }



    //main method for testing
    public static void main( String[] args ) {
	System.out.println("TESTING\n\n\n");
	System.out.println("Creating matrix Bob with default constructor");
	Matrix bob = new Matrix();
	System.out.println("Bob's size:");
	System.out.println(bob.size());
	System.out.println("\nCreating matrix Jill who is a 3x3 matrix");
	Matrix jill = new Matrix(3);
	System.out.println("\nJill's size:");
	System.out.println(jill.size());
	System.out.println("\nJill's value at 1,2 :");
	System.out.println(jill.get(1,2));
	System.out.println("\nChecking is Jill's 1,2 is empty :");
	System.out.println(jill.isEmpty(1,2));
	System.out.println("\nSetting Jill's 1,2 to Hello");
	jill.set(1,2,"Hello");
	System.out.println("\nTesting get on Jill's 1,2:");
	System.out.println(jill.get(1,2));
	System.out.println("\nChecking is Jill's 1,2 is empty :");
	System.out.println(jill.isEmpty(1,2));
	System.out.println("\nPopulating Jill\nJill now is:");
	jill.set(0,0,"Mango");
	jill.set(0,1,"Bannana");
	jill.set(0,2,"Orange");
	jill.set(1,0,"Apple");
	jill.set(1,1,"Grape");
	jill.set(1,2,"Kiwi");
	jill.set(2,0,"Lime");
	jill.set(2,1,"Olive");
	jill.set(2,2,"Potato");
	System.out.print(jill);
	System.out.println("\nCreating and populating Jack who is identical to Jill\nJack is:");
	Matrix jack = new Matrix(3);
	jack.set(0,0,"Mango");
	jack.set(0,1,"Bannana");
	jack.set(0,2,"Orange");
	jack.set(1,0,"Apple");
	jack.set(1,1,"Grape");
	jack.set(1,2,"Kiwi");
	jack.set(2,0,"Lime");
	jack.set(2,1,"Olive");
	jack.set(2,2,"Potato");
	System.out.print(jack);
	System.out.println("\nChecking is Jack is equal to Jill:");
	System.out.println(jack.equals(jill));
	System.out.println("\nChanging is Jack's 1,2 to Yam:");
	jack.set(1,2,"Yam");
	System.out.print("\nChecking is Jack is equal to Jill:\n");
	System.out.println(jack.equals(jill) + "\n\n");
	System.out.print("TESTING SWAP METHODS:\n\n");
	System.out.println("Swapping rows 0 and 2\nOriginal Jill:\n");
	System.out.print(jill);
	System.out.println("\nAfter switch:\n");
	jill.swapRows(0,2);
	System.out.print(jill);
	System.out.println("\nSwapping columns 0 and 2\nOriginal Jill:\n");
	System.out.print(jill);
	System.out.println("\nAfter switch:\n");
	jill.swapColumns(0,2);
	System.out.print(jill);


	System.out.println("\n\nHW 55 New Methods:");
	System.out.println("Here is Jill again:\n");
	System.out.println(jill);
	System.out.println("\nHere is Jill's 2nd Row:\n");
	System.out.println(Arrays.toString(jill.getRow(1)));
	System.out.println("\nHere is Jill's 2nd Column:\n");
	System.out.println(Arrays.toString(jill.getCol(1)));
	System.out.println("\n\n\nCreating a new Array for the set Functions\nHere is an array of OtherFruits:\n");
	Object[] OtherFruits = new Object[3];
	OtherFruits[0] ="Lemon";
	OtherFruits[1] ="Gourd";
	OtherFruits[2] ="Tomato";
	System.out.println(Arrays.toString(OtherFruits));
	System.out.println("Setting Jill's 1st row to OtherFruits:\n");
	jill.setRow(0,OtherFruits);
	System.out.println(jill);
	System.out.println(Arrays.toString(OtherFruits));
	System.out.println("Setting Jill's 2nd row to OtherFruits:\n");
	jill.setRow(1,OtherFruits);
	System.out.println(jill);
	System.out.println("Setting Jill's 3rd row to OtherFruits:\n");
	jill.setRow(2,OtherFruits);
	System.out.println(jill);
	System.out.println("Setting Jill's 1st column to OtherFruits:\n");
	jill.setCol(0,OtherFruits);
	System.out.println(jill);
	System.out.println(Arrays.toString(OtherFruits));
	System.out.println("Setting Jill's 2nd column to OtherFruits:\n");
	jill.setCol(1,OtherFruits);
	System.out.println(jill);
	System.out.println("Setting Jill's 3rd column to OtherFruits:\n");
	jill.setCol(2,OtherFruits);
	System.out.println(jill);
	System.out.println("Checking if Jill now contains Lemon:");
	System.out.println(jill.contains("Lemon"));
	System.out.println("Checking if Jill now contains Apple:");
	System.out.println(jill.contains("Apple"));
	System.out.println("\n\nChecking if Jill is full of values:");
	System.out.println(jill.isFull());
	System.out.println("\n\nChecking if Bob, who we didn't give and values, is full of values:");
	System.out.println(bob.isFull());
	System.out.println(jill);
	System.out.println("\n\nResetting Jill's values to more diverse fruits:\n");
	jill.set(0,0,"Mango");
	jill.set(0,1,"Bannana");
	jill.set(0,2,"Orange");
	jill.set(1,0,"Apple");
	jill.set(1,1,"Grape");
	jill.set(1,2,"Kiwi");
	jill.set(2,0,"Lime");
	jill.set(2,1,"Olive");
	jill.set(2,2,"Potato");
	System.out.println(jill);
	jill.transpose();
	System.out.println(jill);
	System.out.print("\n\nLooks good to me!\n\n");
	System.out.println("TESTING COMPLETE");
    }

}//end class Matrix
