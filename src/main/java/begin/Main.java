package begin;

import input.SpecialNumbersProducer;
import rule.CombineRule;
import rule.ContainRule;
import rule.Rule;
import rule.SimpleRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> echos = Arrays.asList("Fizz", "Buzz", "Whizz");

    public static void main(String[] args) {
        List<Integer> specialNumbers = SpecialNumbersProducer.produceSpecialNumbers();
        System.out.println(String.format("Special numbers:%d  %d  %d",
                specialNumbers.get(0), specialNumbers.get(1), specialNumbers.get(2)));


        List<Rule> simpleRules = new ArrayList<Rule>();
        for (int index = 0; index < specialNumbers.size(); index++) {
            if (index == echos.size()) {
                break;
            }
            simpleRules.add(new SimpleRule(specialNumbers.get(index), echos.get(index)));
        }
        Rule combineRule = new CombineRule(simpleRules.toArray(new Rule[0]));
        Rule containRule = new ContainRule(specialNumbers.get(0), simpleRules.get(0));


        List<Rule> ruleEngine = new ArrayList<Rule>();
        ruleEngine.add(containRule);
        ruleEngine.add(combineRule);
        ruleEngine.addAll(simpleRules);


        for (int i = 1; i <= 100; i++) {
            String result = null;
            for (Rule rule : ruleEngine) {
                if (rule.canHandle(i)) {
                    result = rule.handle(i);
                    break;
                }
            }
            System.out.println(result == null ? Integer.toString(i) : result);
        }
    }
}
