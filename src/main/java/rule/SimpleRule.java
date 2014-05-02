package rule;

public class SimpleRule implements Rule {
    private int number;
    private String echo;

    public SimpleRule(int number, String echo) {
        this.number = number;
        this.echo = echo;
    }

    @Override
    public boolean canHandle(int n) {
        return n % number == 0;
    }

    @Override
    public String handle(int n) {
        return echo;
    }
}
