/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwr.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yracnet
 */
public class FilterBuilderImpl<T> implements FilterBuilder<T> {

    static class Entry {

        final String param;
        final String[] names;
        final Filter value;

        Entry(String param, String names[], Filter value) {
            this.param = param;
            this.names = names;
            this.value = value;
        }
    }

    private String source;
    private Config config;
    private String alias = "o";
    private final List<Entry> entries = new ArrayList<>();

    public FilterBuilderImpl() {
        source = "DUAL";
    }

    public FilterBuilderImpl(String name) {
        this.source = name;
    }

    @Override
    public FilterBuilder<T> appendEntry(String param, String[] names, Filter filter) {
        if (filter != null) {
            Entry entry = new Entry(param, names, filter);
            entries.add(entry);
        }
        return this;
    }

    @Override
    public FilterBuilder<T> config(Config config) {
        this.config = config;
        return this;
    }

    @Override
    public String createQuery() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT ").append(alias)
                .append("\n  FROM ").append(source).append(" ").append(alias);
        appendWhere(queryString);
        if (config != null && config.hasSort()) {
            Config.Sort sort = config.getSort();
            queryString.append("\nORDER BY ").append(alias).append(".").append(config.getAttr()).append(" ").append(sort);
        }
        return queryString.toString();
    }

    @Override
    public String createQueryCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void appendWhere(StringBuilder queryString) {
        if (!entries.isEmpty()) {
            queryString.append("\n WHERE");
            for (Entry entry : entries) {
                Filter filter = entry.value;
                Filter.Expr expr = filter.getExpr();
                if (expr.isSkip()) {
                    continue;
                }
                queryString.append(" (");
                for (String name : entry.names) {
                    queryString.append("\n   ")
                            .append(alias).append(".").append(name)
                            .append(" ").append(expr.getOper());
                    if (expr.getParams() == 1) {
                        queryString.append(" :").append(entry.param);
                    }
                    queryString.append("\n  OR ");
                }
                queryString.setLength(queryString.length() - 6); // remove last OR
                queryString.append("\n ) AND");
            }
            queryString.setLength(queryString.length() - 4); // remove last AND
        }
    }

//    private void appendParameter(Query query) {
//        for (Entry entry : entries) {
//            Filter filter = entry.value;
//            Filter.Expr expr = filter.getExpr();
//            if (expr == null || expr.isSkip() || expr.isWithoutParam()) {
//                continue;
//            }
//            switch (expr) {
//                case like:
//                    query.setParameter(entry.param, "%" + filter.getValue() + "%");
//                    break;
//                default:
//                    query.setParameter(entry.param, filter.getValue());
//                    break;
//            }
//        }
//    }

}
