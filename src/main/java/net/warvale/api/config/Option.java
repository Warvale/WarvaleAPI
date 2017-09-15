package net.warvale.api.config;

import java.util.Set;

public class Option {

    protected String key;
    protected String niceName;
    protected Object value;
    protected boolean required;
    protected Set<Object> validValues;

    public Option(String key, String niceName, Object value, boolean required) {
        this.key = key;
        this.niceName = niceName;
        this.value = value;
        this.required = required;
        this.validValues = null;
    }

    public Option(String key, String niceName, Object value, boolean required, Set<Object> validValues) {
        this.key = key;
        this.niceName = niceName;
        this.value = value;
        this.required = required;
        this.validValues = validValues;
    }

    public String getKey() {
        return key;
    }

    public String getNiceName() {
        return niceName;
    }

    public Object getValue() {
        return value;
    }

    public boolean isRequired() {
        return required;
    }

    /**
     * Return null if we had a good value (weird right?)
     */
    public String setIfValidOption(Object value) {
        if (this.validValues == null || this.validValues.contains(value)) {
            this.value = value;
            return null;
        }

        return "Invalid Option Provided";
    }

    public Object setValue(Object value) {
        return this.setIfValidOption(value);
    }

    @Override
    public String toString() {
        if (this.value == null) {
            return this.niceName + " - Not Set";
        }

        return this.niceName + " - " + this.value;
    }

}
