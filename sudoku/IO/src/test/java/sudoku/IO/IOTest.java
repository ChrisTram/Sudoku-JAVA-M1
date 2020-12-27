package sudoku.IO;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( IOTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testSave() throws IOException
    {
    	int[][] intMatrix = { 
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},};
    	
    	IO io = new IO();
    	assertTrue(io.save(intMatrix, "test"));
}
    
    public void testLoad() throws IOException
    {
    	int[][] intMatrix = { 
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},};
    	
    	int[][] intMatrix2 = { 
    			{0,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},
    			{1,1,1,1,1,1,1,1,1,1},};
    	IO io = new IO();
    	io.save(intMatrix, "test");
    	intMatrix2 = io.load("test");
    	assertTrue(intMatrix2[0][0] == 1);
}
    //Other functions are already call by Main when testing the different entries of  the App. They are exclude
    //by default in the Main pom.xml to avoid having to quit the game 3 times at each test serie
    
}
