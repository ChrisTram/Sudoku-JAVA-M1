package sudoku.Main;

import junit.framework.TestCase;

public class MainPlayTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainPlayTest ( String testName )
    {
        super( testName );
        
    }
    
   //Those tests are by default exclude in the main/pom.xml

    
    public void testStartRandom()
    {
        Main.start("Random");
    }
    
    public void testStartFromResources()
    {
        Main.start("fromResources");
    }
    
    public void testStartFromPath()
    {
        Main.start("/tableTest");
    }
}
