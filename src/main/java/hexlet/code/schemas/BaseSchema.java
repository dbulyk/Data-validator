package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private final List<Predicate<T>> rules = new ArrayList<>();

    /**
     * @param predicate - predicate to added in list of predicates
     */
    public void addRule(Predicate<T> predicate) {
        rules.add(predicate);
    }

    /**
     * @param parameter - Checked string
     * @return boolean
     */
    public boolean isValid(Object parameter) {
        for (Predicate rule : rules) {
            if (!rule.test(parameter)) {
                return false;
            }
        }
        return true;
    }
}
