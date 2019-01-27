package dev.yracnet.app.fn.manager.state;


import java.io.Serializable;
import com.github.yracnet.state.Filter;
public class CotizacionFilter implements Serializable {

   public Filter<Long> cotizacionId;

   public Filter<String> tipo;

   public Filter<String> estado;

   public Filter<java.util.Date> fecha;

   public Filter<Double> valorUfv;

   public Filter<Double> valorInteres;

   public Filter<String> createdBy;

   public Filter<java.util.Date> createdAt;

}

    