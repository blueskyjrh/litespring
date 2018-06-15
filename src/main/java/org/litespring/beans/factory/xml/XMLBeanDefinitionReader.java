package org.litespring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.support.BeanDefinitionRegistry;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.GenericBeanDefinition;
import org.litespring.utils.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XMLBeanDefinitionReader {

    public static final String ID_ARRTIBUTE = "id";

    public static final String CLASS_ARRTIBUTE = "class";

    private BeanDefinitionRegistry registry;

    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinition(String configFile) {
        InputStream is = null;
        try {
            ClassLoader c1 = ClassUtils.getDefaultClassLoader();
            is = c1.getResourceAsStream(configFile);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ARRTIBUTE);
                String className = ele.attributeValue(CLASS_ARRTIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, className);
                registry.registerBeanDefinition(id, bd);
            }
        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
