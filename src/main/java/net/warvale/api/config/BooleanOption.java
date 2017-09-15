package net.warvale.api.config;

import net.warvale.api.config.Option;

public class BooleanOption extends Option {

    public BooleanOption(String key, String niceName, Object value, boolean required) {
        super(key, niceName, value, required);
    }

    @Override
    public String setIfValidOption(Object value) {
        if (!(value instanceof Boolean)) {
            return "Can only specify \"true\" or \"false\" for value";
        }

        // No need to cast here, we cast in the getter
        this.value = value;

        return null;
    }

    @Override
    public Boolean getValue() {
        return (Boolean) this.value;
    }

}
