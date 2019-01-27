package dev.yracnet.app.fn.manager;


import dev.yracnet.app.fn.manager.state.Cotizacion;
import dev.yracnet.app.fn.manager.state.CotizacionFilter;
import com.github.yracnet.state.Message;
import com.github.yracnet.oper.QueryFilter;
import com.github.yracnet.fn.FnMapper;
import com.github.yracnet.fn.FnValidate;
import dev.yracnet.app.model.CapCotizacion;

public class CotizacionFunc {
  
    static FnValidate<CotizacionFilter> validateFilter = (filter) -> {
        Message message = new Message("Filter Allowed");
        //message.required(filter, "Filter Cotizacion");
        
        message.required(filter.cotizacionId, "Required Cotizacion Id");
        message.required(filter.tipo, "Required Tipo");
        message.required(filter.estado, "Required Estado");
        message.required(filter.fecha, "Required Fecha");
        message.required(filter.valorUfv, "Required Valor Ufv");
        message.required(filter.valorInteres, "Required Valor Interes");
        message.required(filter.createdBy, "Required Created By");
        message.required(filter.createdAt, "Required Created At");
        return message;
    };

    static FnValidate<Cotizacion> validateCreate = (value) -> {
        Message message = new Message("Create Cotizacion");
        //message.required(value, "Required Filter");
        
        message.required(value.cotizacionId, "Required Cotizacion Id");
        message.required(value.tipo, "Required Tipo");
        message.required(value.estado, "Required Estado");
        message.required(value.fecha, "Required Fecha");
        message.required(value.valorUfv, "Required Valor Ufv");
        message.required(value.valorInteres, "Required Valor Interes");
        message.required(value.createdBy, "Required Created By");
        message.required(value.createdAt, "Required Created At");
        return message;
    };

    static FnMapper<CotizacionFilter, QueryFilter> mapperQuery = (filter) -> {
        QueryFilter query = new QueryFilter("Query Cotizacion");
        
        query.append("o.cotizacionId", filter.cotizacionId);
        query.append("o.tipo", filter.tipo);
        query.append("o.estado", filter.estado);
        query.append("o.fecha", filter.fecha);
        query.append("o.valorUfv", filter.valorUfv);
        query.append("o.valorInteres", filter.valorInteres);
        query.append("o.createdBy", filter.createdBy);
        query.append("o.createdAt", filter.createdAt);
        return query;
    };

    static FnMapper<Cotizacion, CapCotizacion> mapperEntity = (value) -> {
        CapCotizacion entity = new CapCotizacion();
        
        entity.setCotizacionId(value.cotizacionId);
        entity.setTipo(value.tipo);
        entity.setEstado(value.estado);
        entity.setFecha(value.fecha);
        entity.setValorUfv(value.valorUfv);
        entity.setValorInteres(value.valorInteres);
        entity.setCreatedBy(value.createdBy);
        entity.setCreatedAt(value.createdAt);
        return entity;
    };

    static FnMapper<CapCotizacion, Cotizacion> mapperData = (entity) -> {
        Cotizacion value = new Cotizacion();
        
        value.cotizacionId = entity.getCotizacionId();
        value.tipo = entity.getTipo();
        value.estado = entity.getEstado();
        value.fecha = entity.getFecha();
        value.valorUfv = entity.getValorUfv();
        value.valorInteres = entity.getValorInteres();
        value.createdBy = entity.getCreatedBy();
        value.createdAt = entity.getCreatedAt();
        return value;
    };
}
