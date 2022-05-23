package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        super.addRule(p -> p instanceof String && !String.valueOf(p).isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        required();
        super.addRule(p -> String.valueOf(p).length() >= length);
        return this;
    }

    public final StringSchema contains(String s) {
        super.addRule(p -> p instanceof String && String.valueOf(p).contains(s));
        return this;
    }
}
