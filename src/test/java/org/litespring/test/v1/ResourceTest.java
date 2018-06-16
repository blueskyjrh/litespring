package org.litespring.test.v1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;
import org.litespring.utils.ClassUtils;

import java.io.InputStream;

public class ResourceTest {

    private InputStream is = null;
    private Resource r = null;

    @Test
    public void classPathResourceTest() throws Exception {
        r = new ClassPathResource("petstore-v1.xml");
    }

    @Test
    public void fileSystemResourceTest() throws Exception {
        String path = ClassUtils.getDefaultClassLoader().getResource("petstore-v1.xml").getPath();
        r = new FileSystemResource(path);
    }

    @After
    public void tearDown() throws Exception {
        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
