package org.netdata.automationtesting.cucumber.context;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {

    Map<StorageKey, Object> storage;

    public ScenarioContext() {
        storage = new HashMap<>();
    }

    public void addToStorage(StorageKey key, Object toAdd) {
        storage.put(key, toAdd);
    }

    public <T> T getFromStorage(StorageKey key, Class<T> clazz) {
        return clazz.cast(storage.get(key));
    }

}
