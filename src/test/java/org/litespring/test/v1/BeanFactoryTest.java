package org.litespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;
import org.litespring.service.v1.PetStoreService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XMLBeanDefinitionReader reader = null;
    Resource resource = null;

    @Before
    public void setUp() throws Exception {
        factory = new DefaultBeanFactory();
        reader = new XMLBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {
        resource = new ClassPathResource("petstore-v1.xml");
        reader.loadBeanDefinition(resource);
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        resource = new ClassPathResource("petstore-v1.xml");
        reader.loadBeanDefinition(resource);
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("except BeanCreationException! ");
    }

    @Test
    public void testInvalidXML() {
        resource = new ClassPathResource("xxxx.xml");
        try {
            reader.loadBeanDefinition(resource);
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("except BeanDefinitionStoredException! ");
    }
}
