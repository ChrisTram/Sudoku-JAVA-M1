package org.SudokuGame;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SudokuCheckingTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public SudokuCheckingTest(String testName) {
		super(testName);

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SudokuCheckingTest.class);
	}

	/**
	 * Testing checkLine() with a correct matrix in good order
	 */
	public void testCheckLine() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 7, 1, 0, 3, 0, 5, 6, 0, 9, 8 } };
		;
		assertTrue(sudoku.checkLine(intMatrix, 0));
	}

	/**
	 * Testing checkLine() with a correct matrix in bad order
	 */
	public void testCheckLineRandom() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { { 7, 1, 4, 3, 2, 5, 6, 9, 8 }, { 7, 1, 0, 3, 0, 5, 6, 0, 9, 8 } };
		;
		assertTrue(sudoku.checkLine(intMatrix, 0));
	}

	/**
	 * Testing checkLine() with a correct matrix with empty numbers
	 */
	public void testCheckLineWithVoid() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { { 7, 1, 0, 3, 0, 5, 6, 0, 9, 8 }, { 7, 1, 0, 3, 0, 5, 6, 0, 9, 8 } };
		;
		assertTrue(sudoku.checkLine(intMatrix, 0));
	}

	/**
	 * Testing checkColumn() with a correct matrix with empty numbers
	 */
	public void testCheckColumn() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { { 7, 1, 0, 3, 0, 5, 6, 0, 9, 8 }, { 8, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 9, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 3, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 6, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 1, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, };
		;

		assertTrue(sudoku.checkColumn(intMatrix, 0));
	}

	/**
	 * Testing checkRegion() with a correct matrix with empty numbers
	 */
	public void testCheckRegion() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { { 0, 1, 0, 3, 0, 5, 6, 0, 9, 8 }, { 8, 6, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 9, 0, 4, 3, 4, 5, 6, 7, 8, 9 }, { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 3, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 6, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 1, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, };
		;

		assertTrue(sudoku.checkRegion(intMatrix, 1));
	}
	
	public void testCheckAllLines() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9},  };
		;

		assertTrue(sudoku.checkAllLines(intMatrix));
	}
	
	public void testCheckAllColumns() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { 
				{ 1, 2, 9,0,0,0,0,0,0}, 
				{ 2, 3, 8,0,0,0,0,0,0}, 
				{ 3, 4, 7,0,0,0,0,0,0}, 
				{ 4, 5, 6,0,0,0,0,0,0}, 
				{ 5, 6, 5,0,0,0,0,0,0}, 
				{ 6, 8, 4,0,0,0,0,0,0}, 
				{ 7, 7, 3,0,0,0,0,0,0}, 
				{ 8, 9, 2,0,0,0,0,0,0}, 
				{ 9, 1, 1,0,0,0,0,0,0},  };
		;

		assertTrue(sudoku.checkAllColumns(intMatrix));
	}
	
	public void testCheckAllRegions() {
		Sudoku sudoku = new Sudoku();
		int[][] intMatrix = { 
    			{1,0,5,0,0,0,0,4,6},
    			{0,3,0,0,0,0,0,0,0},
    			{4,0,6,0,0,0,0,0,5},
    			{0,2,0,0,0,0,0,0,0},
    			{0,1,9,0,0,9,5,0,0},
    			{0,0,0,0,0,0,0,0,0},
    			{8,0,0,0,9,0,9,0,0},
    			{5,0,0,0,0,0,0,0,0},
    			{4,0,0,3,0,0,0,0,0},};	
		assertTrue(sudoku.checkAllRegions(intMatrix));
	}
	
	
    //HasWin() just check if there isn't any 0 left in the grid, because we check the validity 
    //inside the AddValue()
    public void testHasWin()
    {
      	Sudoku sudoku = new Sudoku();
    	int[][] intMatrix = { 
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},};	;
    	      	sudoku.sudokuTable = intMatrix;

    		assertTrue( sudoku.hasWin() );

    }
}
