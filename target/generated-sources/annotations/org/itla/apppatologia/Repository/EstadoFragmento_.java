package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Fragmento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(EstadoFragmento.class)
public class EstadoFragmento_ { 

    public static volatile SingularAttribute<EstadoFragmento, String> nombre;
    public static volatile CollectionAttribute<EstadoFragmento, Fragmento> fragmentoCollection;
    public static volatile SingularAttribute<EstadoFragmento, Integer> idestadoFragmento;

}