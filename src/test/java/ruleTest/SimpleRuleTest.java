package ruleTest;

import org.junit.Test;
import rule.SimpleRule;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SimpleRuleTest {
    private SimpleRule simpleRule;
    int number;
    String echo = "aaa";

    @Test
    public void canHandleWhenMultiple() throws Exception {
        simpleRule = new SimpleRule(3, echo);
        assertTrue(simpleRule.canHandle(9));
    }

    @Test
    public void cannotHandleWhenNotMultiple() throws Exception {
        simpleRule = new SimpleRule(3, echo);
        assertFalse(simpleRule.canHandle(10));
    }

    @Test
    public void testHandle() throws Exception {
        simpleRule = new SimpleRule(3, echo);
        assertEquals(simpleRule.handle(9), "aaa");
    }

}
