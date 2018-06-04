package util;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.AllPredicate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: frank_du
 * Time : 2018/3/19 上午10:27
 */
public class FCollectionUtils {

    /**
     * 查询集合中某一参数为某一固定值的对象
     *
     * @param collection
     * @param propertyName
     * @param propertyValue
     * @param <T>
     * @return
     */
    public static <T> T findByPropertyValue(List<T> collection, String propertyName, Object propertyValue) {
        return (T) CollectionUtils.find(collection, new BeanPropertyValueEqualsPredicate(propertyName, propertyValue));
    }

    /**
     * 查询集合中某几个参数为某几个固定值的对象
     *
     * @param collection
     * @param propertyValueMap
     * @param <T>
     * @return
     */
    public static <T> T findByPropertyValue(List<T> collection, Map<String, Object> propertyValueMap) {
        Predicate[] predicates = new BeanPropertyValueEqualsPredicate[propertyValueMap.size()];
        Set<String> propertyNameSet = propertyValueMap.keySet();
        int index = 0;
        for (String propertyName : propertyNameSet) {
            predicates[index] = new BeanPropertyValueEqualsPredicate(propertyName, propertyValueMap.get(propertyName));
            index++;
        }
        Predicate allPredicate = new AllPredicate(predicates);
        return (T) CollectionUtils.find(collection, allPredicate);
    }

    public static <T> void filterByPropertyValue(List<T> collection, String propertyName, Object propertyValue) {
        CollectionUtils.filter(collection, new BeanPropertyValueEqualsPredicate(propertyName, propertyValue));
    }

    /**
     * 选择集合中参数为某固定值的对象集合
     *
     * @param collection
     * @param propertyName
     * @param propertyValue
     * @param <T>
     * @return
     */
    public static <T> List<T> select(List<T> collection, String propertyName, Object propertyValue) {
        return (List<T>) CollectionUtils.select(collection, new BeanPropertyValueEqualsPredicate(propertyName, propertyValue));
    }
    /**
     * 把对象集合转换称某一Property的集合
     *
     * @param collection
     * @param property
     * @param <T>
     * @return
     */
    public static <T> List<String> collect(List<T> collection, String property) {
        return (List<String>) CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(property));
    }
}
