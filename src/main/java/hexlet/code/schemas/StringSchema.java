package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {
    @Override
    public boolean isValid(Object parameter) {
        return (parameter == null || parameter instanceof String) && super.isValid(parameter);
    }

    public StringSchema required() {
        addRule(p -> (p != null && !(Objects.equals(p, ""))));
        return this;
    }

    public StringSchema contains(String strToCompare) {
        addRule(p -> (p != null && p.contains(strToCompare)));
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRule(p -> (p != null && p.length() >= minLength));
        return this;
    }
}