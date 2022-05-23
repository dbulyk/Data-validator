package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public final NumberSchema required() {
        super.addRule(p -> p instanceof Integer);
        return this;
    }

    public final NumberSchema positive() {
        required();
        super.addRule(p -> (Integer) p > 0);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        super.addRule(p -> (Integer) p >= start && (Integer) p <= end);
        return this;
    }
}
