package sudoku.GUI;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GUITest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GUITest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GUITest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDisplay()
    {
    	GUI gui = new GUI();
    	int[][] intMatrix = { 
    			{-1,1,1,-1,1,1,1,1,1,1},
    			{1,1,5,1,1,1,1,1,1,1},
    			{1,2,3,4,5,6,7,8,1,1},
    			{1,5,6,7,3,9,2,4,1,1},
    			{1,3,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},};	;
    			
    			
        gui.displaySudoku(intMatrix);
    }
    
    
  //Other functions are already call by Main when testing the different entries of  the App. They are exclude
  //by default in the Main pom.xml to avoid having to quit the game 3 times at each test serie
}
