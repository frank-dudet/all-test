package com.cn.frank.test.annotation;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;


/**
 * Author: frank_du
 * Time : 2017/4/5 下午7:21
 */
public abstract class Code {

    private static final Logger LOGGER = Logger.getLogger(Code.class);

    protected static Map<String, Map<Integer, String>> values = new HashMap<String, Map<Integer, String>>();

    public static String displayValue(Class<? extends Code> clazz, int intValue) {
        if(clazz != null) {
            return values.get(getClassName(clazz)).get(intValue);
        } else {
            return null;
        }
    }

    private static String getClassName(Class<? extends Code> clazz) {
        String className = clazz.getName();
        if(!values.containsKey(className)) {
            try {
                init(clazz);
            } catch (IllegalAccessException e) {
                LOGGER.error(e);
                return null;

            }
        }
        return className;
    }


    private static synchronized void init(Class<? extends Code> clazz) throws IllegalAccessException {
        if(!values.containsKey(clazz.getName())) {
            Map<Integer, String> map = new HashMap<Integer, String>();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields) {
                if(Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()) && field.isAnnotationPresent(Display.class)) {
                    Display annotation = field.getAnnotation(Display.class);
                    map.put(field.getInt((Object) null),annotation.value());
                }
            }
            values.put(clazz.getName(),map);
        }
    }

}
