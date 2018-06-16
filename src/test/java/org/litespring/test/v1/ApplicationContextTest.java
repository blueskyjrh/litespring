package org.litespring.test.v1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathApplicationContext;
import org.litespring.context.support.FileSystemApplicationContext;
import org.litespring.service.v1.PetStoreService;
import org.litespring.utils.ClassUtils;

public class ApplicationContextTest {

    ApplicationContext ctx = null;

    @Test
    public void testGetBean() {
        ctx = new ClassPathApplicationContext("petstore-v1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        String path = ClassUtils.getDefaultClassLoader().getResource("petstore-v1.xml").getPath().replaceFirst("/", "");
        ctx = new FileSystemApplicationContext(path);
    }

    @After
    public void tearDown() throws Exception {
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
}
