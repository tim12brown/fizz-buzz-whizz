package ruleTest;

import org.junit.Test;
import rule.ContainRule;
import rule.SimpleRule;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ContainRuleTest {
    private SimpleRule simpleRule;
    private ContainRule containRule;

    @Test
    public void canHandleWhenContainASpecialNumber() throws Exception {
        simpleRule = new SimpleRule(3, "Fizz");
        containRule = new ContainRule(3, simpleRule);

        assertTrue(containRule.canHandle(31));
    }

    @Test
    public void cannotHandleWhenNotContainASpecialNumber() throws Exception {
        simpleRule = new SimpleRule(3, "Fizz");
        containRule = new ContainRule(3, simpleRule);

        assertFalse(containRule.canHandle(41));
    }

    @Test
    public void testHandle() throws Exception {
        simpleRule = new SimpleRule(3, "Fizz");
        containRule = new ContainRule(3, simpleRule);

        assertEquals(containRule.handle(31), "Fizz");
    }
}
