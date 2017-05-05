package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Observacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(TipoObservacion.class)
public class TipoObservacion_ { 

    public static volatile CollectionAttribute<TipoObservacion, Observacion> observacionCollection;
    public static volatile SingularAttribute<TipoObservacion, String> nombre;
    public static volatile SingularAttribute<TipoObservacion, Integer> idtipoObservacion;

}