package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {

    public void setBeanClassLoader(ClassLoader classLoader);

    public ClassLoader getBeanClassLoader();
}
