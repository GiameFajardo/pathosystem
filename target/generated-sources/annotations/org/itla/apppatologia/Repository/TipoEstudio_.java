package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.AccionTipoEstudio;
import org.itla.apppatologia.Repository.Estudio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(TipoEstudio.class)
public class TipoEstudio_ { 

    public static volatile SingularAttribute<TipoEstudio, Float> precio;
    public static volatile SingularAttribute<TipoEstudio, Integer> idtipoEstudio;
    public static volatile SingularAttribute<TipoEstudio, AccionTipoEstudio> idaccionTipoEstudioAccionTipoEstudio;
    public static volatile CollectionAttribute<TipoEstudio, Estudio> estudioCollection;
    public static volatile SingularAttribute<TipoEstudio, String> nombre;

}