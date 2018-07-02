package org.litespring.test.v2;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathApplicationContext;
import org.litespring.dao.v2.AccountDao;
import org.litespring.dao.v2.ItemDao;
import org.litespring.service.v2.PetStoreService;

import static org.junit.Assert.*;


public class ApplicationContextTestV2 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathApplicationContext("petstore-v2.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());
        assertNotNull(petStore.getName());
        assertNotNull(petStore.getAge());
        assertTrue(petStore.getAccountDao() instanceof AccountDao);
        assertTrue(petStore.getItemDao() instanceof ItemDao);
        assertEquals("Jane", petStore.getName());
        assertEquals(18, petStore.getAge());
    }
}
