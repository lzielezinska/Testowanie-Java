package test;

import Algorithm.Algorithm;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class TestAlgorithm {

    Algorithm temp;

    @Before
    public void setUp(){
        temp = new Algorithm();
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
    }






    @After
    public void teardown(){
        temp = null;
    }

}
