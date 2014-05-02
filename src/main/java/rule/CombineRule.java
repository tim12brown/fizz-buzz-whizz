package rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineRule implements Rule {
    private List<Rule> rules;

    public CombineRule(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    @Override
    public boolean canHandle(int n) {
        int count = 0;
        for (Rule rule : rules) {
            if (rule.canHandle(n)) {
                count++;
            }
        }
        return count > 1;
    }

    @Override
    public String handle(int n) {
        StringBuilder sb = new StringBuilder();
        for (Rule rule : rules) {
            if (rule.canHandle(n)) {
                sb.append(rule.handle(n));
            }
        }
        return sb.toString();
    }
}
