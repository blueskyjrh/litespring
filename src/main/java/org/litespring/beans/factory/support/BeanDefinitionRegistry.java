package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {

    public BeanDefinition getBeanDefinition(String petStore);

    public void registerBeanDefinition(String beanID, BeanDefinition bd);
}
