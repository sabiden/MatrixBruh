//Shaik Abiden
//APCS1 pd10
//HW53 -- Red vs Blue
//2016 - 1 - 5

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

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
	Object old = get(r,c);
	matrix[r][c] = newVal;
	return old;
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
	    else{
		return false;
	    }
	}
	else{
	    return false;
	}
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	//Go to each row and switch whatever's at c1 index with what's at c2 index
	for (int i = 0; i < matrix.length; i++){
	    Object savVal = matrix[i][c1];
	    matrix[i][c1] = matrix[i][c2];
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

    /*
    public boolean isFull()
	public Object[] getRow( int r )
	public Object[] setRow( int r, Object[] newRow )
	public Object[] getCol( int c )
	public Object[] setCol( int c, Object[] newCol )
	public void transpose()
	public boolean contains( Object o )
    */



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
	System.out.print("\n\nLooks good to me!\n\n");
	System.out.println("TESTING COMPLETE");
    }

}//end class Matrix
