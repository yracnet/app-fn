package org.jwr.model;

import java.util.List;

/**
 *
 * @author yracnet
 */
public interface FilterBuilder<T> {

    public static <T> FilterBuilder<T> create() {
        return new FilterBuilderImpl();
    }

    public static <T> FilterBuilder<T> create(Class<T> aEntity) {
        String name = FilterHelp.getEntityName(aEntity);
        return create(name, null);
    }

    public static <T> FilterBuilder<T> create(String name) {
        return create(name, null);
    }

    public static <T> FilterBuilder<T> create(Class<T> aEntity, Object oFilter) {
        String name = FilterHelp.getEntityName(aEntity);
        return create(name, oFilter);
    }

    public static <T> FilterBuilder<T> create(String name, Object oFilter) {
        FilterBuilder<T> builder = new FilterBuilderImpl(name);
        if (oFilter != null) {
            Class cFilter = oFilter.getClass();
            //FilterHelp.forEach
            List<FilterHelp.FilterItem> items = FilterHelp.createFilter(cFilter);
            items.stream()
                    .forEach(item -> {
                        Filter filter = item.invokeMethod(oFilter);
                        builder.appendEntry(item.param, item.names, filter);
                    });
            Config config = FilterHelp.createConfig(oFilter);
            builder.config(config);
        }
        return builder;
    }

    public FilterBuilder<T> appendEntry(String param, String[] names, Filter filter);

    public FilterBuilder<T> config(Config config);

    public String createQuery();

    public String createQueryCount();

}
