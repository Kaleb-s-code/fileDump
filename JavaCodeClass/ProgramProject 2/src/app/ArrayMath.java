// package pack;
/**
 * This class contains all of the the methods which 
 * perform all of the actual mathematics in the program. 
 * 
 * @author Kaleb Moreno (kalebm2@uw.edu)
 * @version 1/23/2019 (LATE)
 */
public class ArrayMath {
	/**
	 * This method performs the addition of two arrays
	 * @param theArray1 This is the first array passed
	 * @param theArray2 This is the second array passed
	 * @return This method returns an array of the addition results
	 */
	public int[][] add(int[][] theArray1, int[][] theArray2 ) {
	    int[][] addedValues;
		int ct = 0;
        int ct2 = 0;
        int row = 0;
        int col = 0;
		        
        addedValues = new int[theArray1.length][theArray1[0].length];
        while (ct != theArray1[0].length) {
            while(ct2 < theArray1.length) {
                addedValues[row][col] = theArray1[row][col] + theArray2[row][col];
                row ++;
                ct2 ++;
            }
        ct ++;
        ct2 = 0;
        row = 0;
        col ++;
        }
	    
		return addedValues;
	}
	/**
	 * This method performs the subtraction of two arrays 
	 * @param theArray1 This is the first array passed 
	 * @param theArray2 This is the second array passed
	 * @return This method returns an array of the subtraction
	 * results
	 */
	public int[][] subtract(int[][] theArray1, int[][] theArray2 ) {
		int[][] subtractedValues;	
		int ct = 0;
        int ct2 = 0;
        int row = 0;
        int col = 0;
        subtractedValues = new int[theArray1.length][theArray1[0].length];
        while (ct != theArray1[0].length) {
            while(ct2 < theArray1.length) {
                subtractedValues[row][col] = theArray1[row][col] - theArray2[row][col];
                row ++;
                ct2 ++;
            }
        ct ++;
        ct2 = 0;
        row = 0;
        col ++;
        }
        return subtractedValues;
	}
	/**
	 * This method multiplies two arrays of different dimensions
	 * and assigns the result to a different array
	 * @param theArray1 This is the first array passed
	 * @param theArray2 This is the second array passed
	 * @return This method returns an array of the multiplied
	 * 
	 */
	public int[][] mult(int[][] theArray1, int[][] theArray2 ) {
		int[][] multiValues;
		multiValues = new int[0][0];
		int ct = 0;
        int ct2 = 0;
		int row = 0;
		int ct3 = 0;
        int ct4 = 0;
        int testInt = 0;
        int ct6 = 0;
        multiValues = new int[theArray1.length][theArray2[0].length];

        while (ct < theArray1.length * theArray2[0].length) {
            while(ct2 < theArray1[0].length) {
                if (ct4 == theArray2[0].length) {
                    testInt ++;
                    ct4 = 0;
                    row = 0;
                }
            multiValues[testInt][ct4] += (theArray1[testInt][ct6] * theArray2[ct3][row]);
            ct2 ++;
            ct6 ++;
            ct3 ++;  
            }
        ct6 = 0;
        ct3 = 0;
        ct ++;
        ct2 = 0;
        ct4 ++;
        row ++;
        }
        return multiValues;		
	}
}