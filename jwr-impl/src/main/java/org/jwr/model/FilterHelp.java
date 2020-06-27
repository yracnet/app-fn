/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwr.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jwr.annotation.FilterElement;

/**
 *
 * @author yracnet
 */
class FilterHelp {

    static class MethodItem<T> {

        Method method;

        public T invokeMethod(Object aInstance) {
            if (method == null) {
                return null;
            }
            try {
                return (T) method.invoke(aInstance);
            } catch (Exception e) {
                e = null;
            }
            return null;
        }
    }

    @lombok.ToString
    static class FilterItem extends MethodItem<Filter> {

        String param;
        String[] names;
    }

    @lombok.ToString
    static class ConfigItem extends MethodItem<Config> {
    }

    private static final Map<Class, List<FilterItem>> CACHE_CLASS_ITEM = new HashMap<>();
    private static final Map<Class, ConfigItem> CACHE_CLASS_CONFIG = new HashMap<>();
    //private static final Method NONE = Method.;

    static String getEntityName(Class aEntity) {
        //aEntity.getAnnotation(aEntity)
        return aEntity.getSimpleName();
    }

    public static Config createConfig(Object aInstance) {
        if (aInstance instanceof Config) {
            Config other = (Config) aInstance;
            return new Config(other);
        } else if (aInstance == null) {
            return new Config();
        } else {
            Class aClass = aInstance.getClass();
            ConfigItem item = CACHE_CLASS_CONFIG.get(aClass);
            if (item == null) {
                item = new ConfigItem();
                CACHE_CLASS_CONFIG.put(aClass, item);
                for (Field field : aClass.getDeclaredFields()) {
                    if (field.getType().isAssignableFrom(Config.class)) {
                        item.method = assertGetter(field, aClass);
                        break;
                    }
                }
            }
            return item.invokeMethod(aInstance);
        }
    }

    public static List<FilterItem> createFilter(Class<?> aClass) {
        List<FilterItem> items = CACHE_CLASS_ITEM.get(aClass);
        if (items == null) {
            items = new ArrayList<>();
            CACHE_CLASS_ITEM.put(aClass, items);
            for (Field field : aClass.getDeclaredFields()) {
                FilterElement element = field.getAnnotation(FilterElement.class);
                if (element != null) {
                    FilterItem item = new FilterItem();
                    item.param = assertParamName(element.param(), field.getName());
                    item.names = assertAttrNames(element.name(), field.getName());
                    item.method = assertGetter(field, aClass);
                    items.add(item);
                }
            }
        }
        return items;
    }

    private static String assertParamName(String param, String paramDefault) {
        if("#default".equals(param) || param == null || param.isEmpty()){
            param = paramDefault;
        }
        return param;
    }

    private static String[] assertAttrNames(String[] name, String nameDefault) {
        String resp[] = new String[name.length];
        for (int i = 0; i < name.length; i++) {
            resp[i] = name[i];
            if ("#default".equals(resp[i])) {
                resp[i] = nameDefault;
            }
        }
        return resp;
    }

    private static Method assertGetter(Field field, Class aClass) {
        Method method;
        try {
            String nameMethod = "get" + field.getName().toUpperCase().charAt(0) + field.getName().substring(1);
            method = aClass.getMethod(nameMethod);
        } catch (NoSuchMethodException | SecurityException e) {
            method = null;
        }
        return method;
    }

}
