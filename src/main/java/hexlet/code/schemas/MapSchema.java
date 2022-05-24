package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {
    @Override
    public boolean isValid(Object parameter) {
        return (parameter == null || parameter instanceof Map) && super.isValid(parameter);
    }

    public MapSchema required() {
        super.addRule(p -> p != null);
        return this;
    }

    public MapSchema sizeof(int count) {
        super.addRule(p -> p != null && p.size() == count);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schema) {
        addRule(p -> {
            for (Object key: p.keySet()) {
                if (!schema.get(key).isValid(p.get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}