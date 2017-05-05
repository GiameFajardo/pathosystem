package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Fragmento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(TipoFragmento.class)
public class TipoFragmento_ { 

    public static volatile SingularAttribute<TipoFragmento, String> nombre;
    public static volatile CollectionAttribute<TipoFragmento, Fragmento> fragmentoCollection;
    public static volatile SingularAttribute<TipoFragmento, Integer> idtipoFragmento;

}