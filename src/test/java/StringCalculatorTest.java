import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    StringCalculator calc = new StringCalculator();
    int testResults;
    int expectedResults;

    @Test
    public void AddEmptyString() {
        testResults = calc.Add("");
        expectedResults = 0;
        Assert.assertEquals(expectedResults,testResults);
    }
    @Test
    public void AddOneNumber() {
        testResults = calc.Add("9");
        expectedResults = 9;
        Assert.assertEquals(expectedResults,testResults);
    }
    @Test
    public void AddTwoNumbers() {
        testResults = calc.Add("2,2");
        expectedResults = 4;
        Assert.assertEquals(expectedResults,testResults);
    }
    @Test
    public void AddMultipleNumbers() {
        testResults =calc.Add("2,9,8,5,6");
        expectedResults = 30;
        Assert.assertEquals(expectedResults,testResults);
    }
    @Test
    public void AddThatHandlesLinesBetween() {
        testResults = calc.Add("1\n2,3");
        expectedResults = 6;
        Assert.assertEquals(expectedResults,testResults);
    }
    @Test
    public void AddThatHandlesDifferentDelimiters() {
        testResults = calc.Add("//;\n1;2");
        expectedResults = 3;
        Assert.assertEquals(expectedResults,testResults);

    }
    @Test(expected = IllegalArgumentException.class)
    public void AddThatHandlesNegativeIntegers() {
        testResults = calc.Add("-1,-4");
    }
    @Test
    public void AddThatIgnoreIntegerGreaterOrEquals1000 () {
        testResults = calc.Add("1000,1,2,1001");
        expectedResults = 3;
        Assert.assertEquals(expectedResults,testResults);
    }
}
