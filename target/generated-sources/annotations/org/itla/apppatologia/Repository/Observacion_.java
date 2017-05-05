package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.Repository.TipoObservacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Observacion.class)
public class Observacion_ { 

    public static volatile SingularAttribute<Observacion, String> descripcion;
    public static volatile SingularAttribute<Observacion, Integer> idobservacion;
    public static volatile SingularAttribute<Observacion, Estudio> idestudioEstudio;
    public static volatile SingularAttribute<Observacion, TipoObservacion> idtipoObservacionTipoObservacion;
    public static volatile SingularAttribute<Observacion, Resultado> idresultadoResultado;

}