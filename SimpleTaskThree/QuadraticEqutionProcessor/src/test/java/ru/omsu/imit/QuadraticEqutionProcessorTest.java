package ru.omsu.imit;

import org.junit.Test;
import static org.junit.Assert.*;

public class QuadraticEqutionProcessorTest {
    @Test
    public void maxDecisionTest(){
        QuadraticEqutionProcessor temp = new QuadraticEqutionProcessor(1,-70,600);
        assertEquals("Ошибка поиска макс. корня! [1/2]",60,temp.maxDecision(),0.0001);
        temp = new QuadraticEqutionProcessor(3,-18,27);
        assertEquals("Ошибка поиска макс. корня! [2/2]",3,temp.maxDecision(),0.0001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void maxDecisionTest1(){
        QuadraticEqutionProcessor temp = new QuadraticEqutionProcessor(1,2,3);
        temp.maxDecision();
    }
}

