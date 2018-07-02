package org.litespring.beans.propertyeditors;

import java.beans.PropertyEditor;

public interface TypeConverter extends PropertyEditor {

    public <T> T convertIfNecessary(Object value, Class<T> requiredType);
}
