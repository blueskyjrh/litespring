package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import org.litespring.context.ApplicationContext;

public class ClassPathApplicationContext implements ApplicationContext {

    DefaultBeanFactory factory = null;

    public ClassPathApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition(configFile);
    }

    @Override
    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }
}