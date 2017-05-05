package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(TipoCargo.class)
public class TipoCargo_ { 

    public static volatile SingularAttribute<TipoCargo, Integer> idtipoCargo;
    public static volatile CollectionAttribute<TipoCargo, Empleado> empleadoCollection;
    public static volatile SingularAttribute<TipoCargo, String> nombre;

}