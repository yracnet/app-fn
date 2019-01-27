package dev.yracnet.app.fn.manager;


import dev.yracnet.app.model.CapCotizacion;
import com.github.yracnet.fn.FnCallNon;
import com.github.yracnet.fn.FnCallSet;
import com.github.yracnet.oper.QueryFilter;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CotizacionLocal {
    private EntityManager em;
    public FnCallSet<QueryFilter, CapCotizacion> filter = (queryFilter) -> {
        Query query = queryFilter.createJpql("SELECT o FROM CapCotizacion o", em);
        return query.getResultList();
    };
    public FnCallNon<CapCotizacion, CapCotizacion> create = (capCotizacion) -> {
        em.persist(capCotizacion);
        return capCotizacion;
    };
    public FnCallNon<CapCotizacion, CapCotizacion> update = (capCotizacion) -> {
        capCotizacion = em.merge(capCotizacion);
        return capCotizacion;
    };
    public FnCallNon<CapCotizacion, CapCotizacion> remove = (capCotizacion) -> {
        em.remove(capCotizacion);
        return capCotizacion;
    };
}