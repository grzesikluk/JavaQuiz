package quiz1.question2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2016-12-16.
 */
public class ClassATest {

    @Test
    public void testSomeMethod() throws Exception{
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, new ClassA().someMethod(new ClassB()));
    }
}
