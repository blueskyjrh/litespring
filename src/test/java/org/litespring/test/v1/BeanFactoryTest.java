package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import org.litespring.service.v1.PetStoreService;

import java.rmi.registry.Registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BeanFactoryTest {

    @Test
    public void testGetBean() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        reader.loadBeanDefinition("petstore-v1.xml");
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("except BeanCreationException! ");
    }

    @Test
    public void testInvalidXML() {
        try {
            DefaultBeanFactory factory = new DefaultBeanFactory();
            XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
            reader.loadBeanDefinition("xxxx.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("except BeanDefinitionStoredException! ");
    }
}
