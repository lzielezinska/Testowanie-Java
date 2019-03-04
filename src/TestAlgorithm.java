import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;


public class TestAlgorithm {

    ArmstrongNumber temp;

    @Before
    public void setUp(){
        temp = new ArmstrongNumber();
    }

    @Test
    public void trivialTest() {
        assertTrue(true);
    }
    @Test
    public void testIfTheAssertIsntNull(){
        assertNotNull(temp.getNumber());
    }
    @Test
    public void testIfTheAssertIsInteger(){
        String numberString = temp.getNumber();
        boolean watcher;
        if(numberString >)
        assertNotNull(temp.getNumber());
    }






    @After
    public void teardown(){
        temp = null;
    }

}
