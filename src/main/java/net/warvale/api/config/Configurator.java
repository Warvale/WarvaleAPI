package net.warvale.api.config;

import net.warvale.api.config.BooleanOption;
import net.warvale.api.config.IntegerOption;
import net.warvale.api.config.Option;
import net.warvale.api.exceptions.NoSuchKeyExistsException;

import java.util.*;

public class Configurator {


    private Map<String, net.warvale.api.config.Option> options = new LinkedHashMap<>();

    public Configurator() {

    }

    /**
     * By default all new options are required
     */
    public void addNewOption(String key, String niceName) {
        this.addNewOption(key, niceName, true);
    }

    /**
     * By default all new options are null
     */
    public void addNewOption(String key, String niceName, boolean required) {
        this.addNewOption(key, niceName, null, required);
    }

    /**
     * By default all new options are required
     */
    public void addNewOption(String key, String niceName, Object value) {
        this.addNewOption(key, niceName, value, true);
    }

    public void addNewOption(String key, String niceName, Object value, boolean required) {
        if (this.options.containsKey(key.toLowerCase())) {
            throw new RuntimeException("Key already exists");
        }

        net.warvale.api.config.Option option = new net.warvale.api.config.Option(key.toLowerCase(), niceName, value, required);
        this.options.put(key.toLowerCase(), option);
    }

    public void addNewOption(String key, String niceName, Object value, boolean required, Object[] validValues) {
        if (this.options.containsKey(key.toLowerCase())) {
            throw new RuntimeException("Key already exists");
        }

        Set<Object> validSet = new HashSet<>();
        Collections.addAll(validSet, validValues);

        net.warvale.api.config.Option option = new net.warvale.api.config.Option(key.toLowerCase(), niceName, value, required, validSet);
        this.options.put(key.toLowerCase(), option);
    }

    public void addNewBooleanOption(String key, String niceName, Object value, boolean required) {
        if (this.options.containsKey(key.toLowerCase())) {
            throw new NoSuchKeyExistsException("Key already exists");
        }

        net.warvale.api.config.Option option = new BooleanOption(key.toLowerCase(), niceName, value, required);
        this.options.put(key.toLowerCase(), option);
    }

    public void addNewIntegerOption(String key, String niceName, Object value, boolean required, int min, int max) {
        if (this.options.containsKey(key.toLowerCase())) {
            throw new NoSuchKeyExistsException("Key already exists");
        }

        // Old School logic fixes tho
        int tmp;
        if (min > max) {
            tmp = min;
            max = min;
            min = tmp;
        }

        net.warvale.api.config.Option option = new IntegerOption(key.toLowerCase(), niceName, value, required, min, max);
        this.options.put(key.toLowerCase(), option);
    }

    public Object updateOption(String key, String value) {
        Object obj = value;

        if (value.equalsIgnoreCase("t") || value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("f") || value.equalsIgnoreCase("false")) {
            obj = Boolean.valueOf(value);
        } else {
            try {
                obj = Integer.valueOf(value);
            } catch (NumberFormatException e) {

            }
        }

        return this.updateOption(key, obj);
    }

    public Object updateOption(String key, Object value) {
        if (!this.options.containsKey(key.toLowerCase())) {
            throw new NoSuchKeyExistsException("No key exists.");
        }

        return this.options.get(key.toLowerCase()).setValue(value);
    }

    public List<String> getOptionValues() {
        List<String> optionValues = new ArrayList<String>();

        for (Map.Entry<String, net.warvale.api.config.Option> entry : this.options.entrySet()) {
            optionValues.add(entry.getValue().toString());
        }

        return Collections.unmodifiableList(optionValues);
    }

    public net.warvale.api.config.Option getOption(String key) {
        return this.options.get(key.toLowerCase());
    }

    public IntegerOption getIntegerOption(String key) {
        return (IntegerOption) this.options.get(key.toLowerCase());
    }

    public BooleanOption getBooleanOption(String key) {
        return (BooleanOption) this.options.get(key.toLowerCase());
    }

    public List<net.warvale.api.config.Option> unconfiguredOptions() {
        List<net.warvale.api.config.Option> unconfiguredOptions = new ArrayList<>();

        for (Map.Entry<String, net.warvale.api.config.Option> entry : this.options.entrySet()) {
            if (entry.getValue().isRequired() && entry.getValue().getValue() == null) {
                unconfiguredOptions.add(entry.getValue());
            }
        }

        return unconfiguredOptions;
    }

    public boolean checkIfAllOptionsSet() {
        for (Map.Entry<String, Option> entry : this.options.entrySet()) {
            if (entry.getValue().isRequired() && entry.getValue().getValue() == null) {
                return false;
            }
        }

        return true;
    }

}
