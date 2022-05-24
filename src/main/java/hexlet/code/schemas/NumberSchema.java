package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {
    @Override
    public boolean isValid(Object parameter) {
        return (parameter == null || parameter instanceof Integer) && super.isValid(parameter);
    }

    public NumberSchema required() {
        super.addRule(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        super.addRule(p -> p == null || p > 0);
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        super.addRule(p -> p >= min && p <= max);
        return this;
    }
}