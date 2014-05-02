package rule;

public class ContainRule implements Rule {
    private int number;
    private Rule rule;

    public ContainRule(int number, Rule rule) {
        this.number = number;
        this.rule = rule;
    }

    @Override
    public boolean canHandle(int n) {
        String value = Integer.toString(n);
        return value.contains(Integer.toString(number));
    }

    @Override
    public String handle(int n) {
        return rule.handle(n);
    }
}
