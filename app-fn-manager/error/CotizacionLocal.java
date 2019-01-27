package dev.yracnet.app.fn.manager;


import com.github.yracnet.oper.QueryFilter;
import com.github.yracnet.fn.FnMapper;
import com.github.yracnet.fn.FnValidate;
import dev.yracnet.app.model.CapCotizacion;

public class CotizacionLocal {
    EntityManager em;
    public FnCallSet<QueryFilter, CapCotizacion> filter = (queryFilter) -> {
        Query query = queryFilter.createJpql("SELECT o FROM CapCotizacion o", em);
        return query.getResultList();
    };
    public FnCallNon<CapCotizacion, CapCotizacion> create = (capCotizacion) -> {
        em.persist(capCotizacion);
        return capCotizacion;
    };
    public FnCallNon<CapCotizacion, CapCotizacion> merge = (capCotizacion) -> {
        capCotizacion = em.merge(capCotizacion);
        return capCotizacion;
    };
    public FnCallNon<CapCotizacion, CapCotizacion> remove = (capCotizacion) -> {
        capCotizacion = em.remove(capCotizacion);
        return capCotizacion;
    };
}
