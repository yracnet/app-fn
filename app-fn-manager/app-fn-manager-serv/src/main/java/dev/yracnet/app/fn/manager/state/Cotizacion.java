package dev.yracnet.app.fn.manager.state;


import java.io.Serializable;
public class Cotizacion implements Serializable {

   public Long cotizacionId; //[access:null, attributeType:Long, column:[table:null, unique:false, length:null, updatable:true, scale:null, precision:null, columnDefinition:null, insertable:true, name:ID_COTIZACION, nullable:false], temporal:null, generatedValue:[strategy:TABLE, generator:CAP_COTIZACIONES], sequenceGenerator:null, tableGenerator:[table:CAP_SEQUENCE, index:[], uniqueConstraint:[], pkColumnValue:null, pkColumnName:null, schema:CAP, initialValue:null, valueColumnName:null, description:null, allocationSize:null, catalog:null, name:CAP_COTIZACIONES], name:cotizacionId]

   public String tipo; //[access:null, enumerated:null, convert:null, attributeType:String, column:[table:null, unique:false, length:255, updatable:false, scale:null, precision:null, columnDefinition:null, insertable:true, name:TIPO_REGISTRO, nullable:false], fetch:null, temporal:null, optional:false, lob:null, name:tipo]

   public String estado; //[access:null, enumerated:null, convert:null, attributeType:String, column:[table:null, unique:false, length:255, updatable:true, scale:null, precision:null, columnDefinition:null, insertable:true, name:ESTADO, nullable:false], fetch:null, temporal:null, optional:false, lob:null, name:estado]

   public java.util.Date fecha; //[access:null, enumerated:null, convert:null, attributeType:java.util.Date, column:[table:null, unique:false, length:null, updatable:false, scale:null, precision:null, columnDefinition:null, insertable:true, name:FECHA_COTIZACION, nullable:false], fetch:null, temporal:DATE, optional:false, lob:null, name:fecha]

   public Double valorUfv; //[access:null, enumerated:null, convert:null, attributeType:Double, column:[table:null, unique:false, length:null, updatable:false, scale:null, precision:5, columnDefinition:null, insertable:true, name:VALOR_UFV, nullable:false], fetch:null, temporal:null, optional:false, lob:null, name:valorUfv]

   public Double valorInteres; //[access:null, enumerated:null, convert:null, attributeType:Double, column:[table:null, unique:false, length:null, updatable:false, scale:null, precision:5, columnDefinition:null, insertable:true, name:VALOR_INTERES, nullable:false], fetch:null, temporal:null, optional:false, lob:null, name:valorInteres]

   public String createdBy; //[access:null, enumerated:null, convert:null, attributeType:String, column:[table:null, unique:false, length:15, updatable:false, scale:null, precision:null, columnDefinition:null, insertable:true, name:CREATED_BY, nullable:false], fetch:null, temporal:null, optional:null, lob:null, name:createdBy]

   public java.util.Date createdAt; //[access:null, enumerated:null, convert:null, attributeType:java.util.Date, column:[table:null, unique:false, length:null, updatable:false, scale:null, precision:null, columnDefinition:null, insertable:true, name:CREATED_AT, nullable:false], fetch:null, temporal:TIMESTAMP, optional:null, lob:null, name:createdAt]

}

    