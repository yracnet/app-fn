package dev.yracnet.app.fn.manager;


import dev.yracnet.app.fn.manager.state.Cotizacion;
import dev.yracnet.app.fn.manager.state.CotizacionFilter;
import dev.yracnet.app.fn.manager.CotizacionLocal;
import com.github.yracnet.state.ResultNon;
import com.github.yracnet.state.ResultSet;
public class CotizacionImpl implements CotizacionServ {

    private CotizacionLocal local = new CotizacionLocal();

    @Override
  public ResultSet<Cotizacion> cotizacionFilter(CotizacionFilter filter){
        ResultNon<CotizacionFilter> result = new ResultNon<>(filter);
        ResultSet<Cotizacion> resultSet = result.validate(CotizacionFunc.validateFilter)
                .mapper(CotizacionFunc.mapperQuery)
                .callSet(local.filter)
                .mapper(CotizacionFunc.mapperData);
        return resultSet;
  }
    @Override
  public ResultNon<Cotizacion> cotizacionCreate(Cotizacion value){
        ResultNon<Cotizacion> result = new ResultNon<>(value);
        ResultNon<Cotizacion> resultNon = result.validate(CotizacionFunc.validateCreate)
                .mapper(CotizacionFunc.mapperEntity)
                .callNon(local.create)
                .mapper(CotizacionFunc.mapperData);
        return resultNon;
  }
    @Override
  public ResultNon<Cotizacion> cotizacionUpdate(Cotizacion value){
        ResultNon<Cotizacion> result = new ResultNon<>(value);
        ResultNon<Cotizacion> resultNon = result.validate(CotizacionFunc.validateCreate)
                .mapper(CotizacionFunc.mapperEntity)
                .callNon(local.update)
                .mapper(CotizacionFunc.mapperData);
        return resultNon;
  }
    @Override
  public ResultNon<Cotizacion> cotizacionRemove(Cotizacion value){
        ResultNon<Cotizacion> result = new ResultNon<>(value);
        ResultNon<Cotizacion> resultNon = result.validate(CotizacionFunc.validateCreate)
                .mapper(CotizacionFunc.mapperEntity)
                .callNon(local.remove)
                .mapper(CotizacionFunc.mapperData);
        return resultNon;
  }
}
