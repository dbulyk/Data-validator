package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> rules = new ArrayList<>();

    /**
     * @param predicate - predicate to added in list of predicates
     */
    public void addRule(Predicate<Object> predicate) {
        rules.add(predicate);
    }

    /**
     * @param o - Checked string
     * @return boolean
     */
    public boolean isValid(Object o) {
        for (Predicate<Object> p : rules) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }
}
