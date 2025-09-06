package utils;


import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<String, Object> data;

    public ScenarioContext() {
        data = new HashMap<>();
    }

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key) {
        return (T) data.get(key);
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }
}