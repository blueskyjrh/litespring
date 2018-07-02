package org.litespring.beans;

public interface TypeConverter {

    public <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
