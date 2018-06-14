package org.litespring.beans.factory;


import org.litespring.beans.BeanDefinition;

public interface BeanFactory {
    public BeanDefinition getBeanDefinition(String petStore);

    Object getBean(String beanName);
}
