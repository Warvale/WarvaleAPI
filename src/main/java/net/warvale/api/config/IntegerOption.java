package net.warvale.api.config;


import net.warvale.api.config.Option;

public class IntegerOption extends Option {

    private int min;
    private int max;

    public IntegerOption(String key, String niceName, Object value, boolean required, int min, int max) {
        super(key, niceName, value, required);
        this.min = min;
        this.max = max;
    }

    @Override
    public String setIfValidOption(Object value) {
        if (!(value instanceof Integer)) {
            return "Value must be number between " + this.min + " and " + this.max;
        }

        Integer num = ((Integer) value);

        if (num >= this.min && num <= this.max) {
            this.value = value;
            return null;
        }

        return "Value must be number between " + this.min + " and " + this.max;
    }

    @Override
    public Integer getValue() {
        return (Integer) this.value;
    }

}