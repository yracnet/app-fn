package dev.yracnet.app.fn.manager;


import dev.yracnet.app.fn.manager.state.Cotizacion;
import dev.yracnet.app.fn.manager.state.CotizacionFilter;
import com.github.yracnet.state.ResultNon;
import com.github.yracnet.state.ResultSet;
interface CotizacionServ {
  ResultSet<Cotizacion> cotizacionFilter(CotizacionFilter cotizacionFilter);
  ResultNon<Cotizacion> cotizacionCreate(Cotizacion cotizacion);
  ResultNon<Cotizacion> cotizacionUpdate(Cotizacion cotizacion);
  ResultNon<Cotizacion> cotizacionRemove(Cotizacion cotizacion);
}
