package com.github.yracnet.oper;

import com.github.yracnet.state.Filter;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QueryFilter<R> {
    
    public QueryFilter(){}
    public QueryFilter(String title){}

    public<T> void append(String literal, Filter<T> filter) {
        
    }

    public Query createJpql(String select, EntityManager em) {
        return em.createQuery(select );
    }
    
}
