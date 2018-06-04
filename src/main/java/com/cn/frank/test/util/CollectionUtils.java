package com.cn.frank.test.util;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Author: frank_du
 * Time : 2017/3/12 上午10:32
 */
public class CollectionUtils {

    private static final Logger LOG = Logger.getLogger(CollectionUtils.class);


    /**
     * 将数组元素用分隔符连接起来，构成一个字符串
     * @param objects
     * @param separator
     * @return
     */
    public static String join(Object[] objects, String separator) {
        StringBuilder builder = new StringBuilder();
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                builder.append(objects[i]).append(separator);
            }
        }
        return builder.substring(0, builder.length() - 1).toString();
    }


    /**
     * 将集合元素用分隔符连接起来，构成一个字符串
     * @param collection
     * @param separator
     * @return
     */
    public static String join(Collection<?> collection, String separator) {
        Object[] objects = new Object[collection.size()];
        collection.toArray(objects);
        return join(objects,separator);
    }

    /**
     * 根据属性名和值查找对象
     *
     * @param collection
     * @param propertyName
     * @param propertyValue
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> collection, String propertyName, Object propertyValue) {
        if (collection == null || collection.size() == 0) {
            return null;
        }

        return (T) org.apache.commons.collections.CollectionUtils.find(collection, new BeanPropertyValueEqualsPredicate(propertyName, propertyValue));
    }

    /**
     * 根据属性名和属性值查找 （多个属性值）
     * @param collection
     * @param propertyNameValueMap
     * @param <T>
     * @return
     */
    public static <T> T find(Collection<T> collection, Map<String, Object> propertyNameValueMap) {
        Predicate[] predicates = new Predicate[propertyNameValueMap.size()];
        Set<String> propertyNameSet = propertyNameValueMap.keySet();
        int index = 0;
        for(String propertyName : propertyNameSet) {
            predicates[index] = new BeanPropertyValueEqualsPredicate(propertyName,propertyNameValueMap.get(propertyName));
            index ++;
        }

        Predicate allPredicate = new AllPredicate(predicates);

        return (T) org.apache.commons.collections.CollectionUtils.find(collection,allPredicate);
    }

    /**
     * 将集合中指定的属性名的值拿出来构成一个集合
     * @param collection
     * @param propertyName
     * @param <T>
     * @param <PropType>
     * @return
     */
    public static <T, PropType> Collection<PropType> collect(Collection<T> collection, String propertyName) {
        Transformer transformer = new BeanToPropertyValueTransformer(propertyName);

        return org.apache.commons.collections.CollectionUtils.collect(collection,transformer);
    }



}
