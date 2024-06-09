package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ThisTestIsFlaky {
    //This test is just to show the use of IRetry analyzer
    @Test (retryAnalyzer=Retry.class)
    public void ThisTestIsFlaky (){
        boolean retry = false;

        Random randomNumber = new Random();
        if (randomNumber.nextInt(3) == 1) {
            retry = true;
        }

        Assert.assertFalse(retry);
    }

}
