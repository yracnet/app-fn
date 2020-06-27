package org.jwr.model;

/**
 *
 * @author yracnet
 */
public class FilterFactory {

    public static <T> FilterQuery create(String name) {
        FilterQuery query = new FilterQuery();
        query.setSource(name);
        return query;
    }
    public static <T> FilterQuery create(String name, Class<T> aClass, T oInstance) {
        FilterQuery query = new FilterQuery();
        query.setSource(name);
        return query;
    }
}
