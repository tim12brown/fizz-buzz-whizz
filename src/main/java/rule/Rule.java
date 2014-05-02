package rule;

public interface Rule {
    boolean canHandle(int n);

    String handle(int n);
}
