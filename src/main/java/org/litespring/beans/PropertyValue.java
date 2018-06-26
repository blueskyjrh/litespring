package org.litespring.beans;

public class PropertyValue {
    private final String name;

    private final Object value;

    private boolean converted = false;

    private Object convertedValue;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public synchronized void setConvertedValue(Object convertedValue) {
        this.convertedValue = convertedValue;
        this.converted = true;
    }

    public synchronized Object getConvertedValue() {
        return this.convertedValue;
    }
}
