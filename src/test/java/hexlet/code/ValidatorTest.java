package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {
    @Test
    void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));

        schema.required();
        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertTrue(schema.isValid("hexlet"));
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid(""));

        final int minLength = 5;
        schema.minLength(minLength);
        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertFalse(schema.isValid("wha"));

        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        Assertions.assertFalse(schema.isValid("what does the fox say"));
    }

    @Test
    void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        final int intervalEnd = 10;

        Assertions.assertTrue(schema.isValid(null));

        schema.required();
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(intervalEnd));
        Assertions.assertFalse(schema.isValid("1"));

        schema.positive();
        Assertions.assertTrue(schema.isValid(intervalEnd));

        schema.range(1, intervalEnd);
        Assertions.assertTrue(schema.isValid(1));
        Assertions.assertTrue(schema.isValid(intervalEnd));
        Assertions.assertFalse(schema.isValid(0));
    }

    @Test
    void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, String> data = new HashMap<>();
        Assertions.assertTrue(schema.isValid(null));

        schema.required();
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap()));

        data.put("key1", "value1");
        Assertions.assertTrue(schema.isValid(data));
        schema.sizeof(2);
        Assertions.assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));
    }

    @Test
    void testMapSchemaShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        final int number1 = 100;
        final int number2 = -5;

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", number1);
        Assertions.assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", number2);
        Assertions.assertFalse(schema.isValid(human4));
    }
}
