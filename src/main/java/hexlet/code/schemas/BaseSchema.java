package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> predicates = new ArrayList<>();

    /**
     * @param predicate - predicate to added in list of predicates
     */
    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    /**
     * @param o - Checked string
     * @return boolean
     */
    public boolean isValid(Object o) {
        for (Predicate<Object> p : predicates) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }
}
