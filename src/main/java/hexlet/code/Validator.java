package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    /**
     * Returns new StringSchema.
     * @return new StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Returns new NumberSchema.
     * @return new NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Returns new MapSchema.
     * @return new NumberSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
