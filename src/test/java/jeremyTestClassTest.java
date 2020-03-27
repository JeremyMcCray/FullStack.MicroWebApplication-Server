import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class jeremyTestClassTest {

    @Test
    public void adder() {
        jeremyTestClass tester = new jeremyTestClass();
        Integer actual = tester.adder(1,2);
        Integer expected = 3;

        Assert.assertEquals(expected,actual);
    }
}