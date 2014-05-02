package ruleTest;

import org.junit.Test;
import rule.CombineRule;
import rule.ContainRule;
import rule.Rule;
import rule.SimpleRule;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class CombineRuleTest {
    private List<Rule> simpleRules = new ArrayList<Rule>();
    private CombineRule combineRule;

    @Test
    public void canHandleWhenIsMultipleOfTwoSpecialNumbers() throws Exception {
        simpleRules.add(new SimpleRule(3, "Fizz"));
        simpleRules.add(new SimpleRule(5, "Buzz"));
        simpleRules.add(new SimpleRule(7, "Whizz"));
        combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));
        assertTrue(combineRule.canHandle(70));
        assertTrue(combineRule.canHandle(15));
        assertTrue(combineRule.canHandle(21));
    }

    @Test
    public void canHandleWhenIsMultipleOfThreeSpecialNumbers() throws Exception {
        simpleRules.add(new SimpleRule(2, "Fizz"));
        simpleRules.add(new SimpleRule(5, "Buzz"));
        simpleRules.add(new SimpleRule(7, "Whizz"));
        combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));
        assertTrue(combineRule.canHandle(70));
    }

    @Test
    public void cannotHandleWhenIsMultipleOfOnlyOneSpecialNumber() throws Exception {
        simpleRules.add(new SimpleRule(3, "Fizz"));
        simpleRules.add(new SimpleRule(5, "Buzz"));
        simpleRules.add(new SimpleRule(7, "Whizz"));
        combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));
        assertFalse(combineRule.canHandle(24));
    }

    @Test
    public void cannotHandleWhenIsNotMultipleOfAnySpecialNumber() throws Exception {
        simpleRules.add(new SimpleRule(3, "Fizz"));
        simpleRules.add(new SimpleRule(5, "Buzz"));
        simpleRules.add(new SimpleRule(7, "Whizz"));
        combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));
        assertFalse(combineRule.canHandle(26));
    }

    @Test
    public void testHandle() throws Exception {
        simpleRules.add(new SimpleRule(2, "Fizz"));
        simpleRules.add(new SimpleRule(5, "Buzz"));
        simpleRules.add(new SimpleRule(7, "Whizz"));
        combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));

        assertEquals(combineRule.handle(10), "FizzBuzz");
        assertEquals(combineRule.handle(14), "FizzWhizz");
        assertEquals(combineRule.handle(35), "BuzzWhizz");
        assertEquals(combineRule.handle(70), "FizzBuzzWhizz");
    }
}
