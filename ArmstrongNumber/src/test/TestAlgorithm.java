package test;

import Algorithm.Algorithm;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static Algorithm.Algorithm.splitString;
import static org.junit.Assert.*;

public class TestAlgorithm {

    Algorithm temp;
    String input;

    @Before
    public void setUp(){
        temp = new Algorithm();
        input  = "3423423423";
    }

    @Test
    public void testIfInputIsNotNull(){
        assertNotNull(input);

    }

    @Test
    public void testIfArrayHasProperLength(){
        int StringLenght = input.length();
        int ArrayLength = splitString(input).length;
        assertEquals(StringLenght, ArrayLength);

    }

    @Test
    public void testIfArrayHasIntValues(){
        boolean watcher = false;
        String ArrayOfString[] = splitString(input);
        int ArrayOfInt[] = Algorithm.convertToIntegerArray(ArrayOfString);
        for(Object ArrayItem : ArrayOfInt){
            if(ArrayItem instanceof Integer)
                watcher = true;
            else{
                watcher = false;
                break;
            }
        }
        assertTrue(watcher);
    }


    @Test
    public void trivialTest() {
        assertTrue(true);
    }

    @After
    public void teardown(){
        temp = null;
    }

}
