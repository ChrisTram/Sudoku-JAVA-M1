package org.SudokuGame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SudokuAddTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SudokuAddTest ( String testName )
    {
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SudokuAddTest.class );
    }
    
    public void testAddValue()
    {
      	Sudoku sudoku = new Sudoku();
    	int[][] intMatrix = { 
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0},};	;
    	      	sudoku.sudokuTable = intMatrix;

    		assertTrue( sudoku.addValue(1,1,1) );

    }
}
