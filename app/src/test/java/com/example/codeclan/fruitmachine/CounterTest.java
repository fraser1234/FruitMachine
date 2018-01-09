package com.example.codeclan.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by fraserblack on 09/01/2018.
 */

public class CounterTest {

    Counter counter;

    @Before
    public void before(){
        counter = new Counter();
    }

    @Test
    public void canGetWinnings(){
        assertEquals(0, counter.getWinnings());
    }

    @Test
    public void canAddOneToWinnings(){
        assertEquals(1, counter.increaseByOne());
    }

    @Test
    public void canAddThreeToWinnings(){
        assertEquals(3, counter.increaseByThree());
    }

    @Test
    public void canAddFiveToWinnigs(){
        assertEquals(5, counter.increaseByFive());
    }

}
