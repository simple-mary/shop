package helpers;

import org.testng.Assert;
import org.testng.TestNGException;

/**
 * Created by Perets on 27.07.2017.
 */
public class Assertion
{
    public static Assertion assertion = new Assertion();

    public void assertEquals(String p_expected, String p_actual, String p_message) {
        try {
            Assert.assertEquals(p_actual, p_expected);

        } catch (AssertionError p_ex) {

            throw new TestNGException(p_message + " Actual [" + p_actual + "] is NOT equal [" + p_expected + "] ");
        }
    }

    public void assertNotEquals(String p_expected, String p_actual, String p_message) {
        try {
            Assert.assertNotEquals(p_actual, p_expected);

        } catch (AssertionError p_ex) {

            throw new TestNGException(p_message + " Actual [" + p_actual + "] is equal [" + p_expected + "] ");
        }
    }

}
