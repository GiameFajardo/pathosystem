package org.itla.apppatologia.Repository;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Observacion;
import org.itla.apppatologia.Repository.Patologo;
import org.itla.apppatologia.Repository.Resultado;
import org.itla.apppatologia.Repository.TipoEstudio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Estudio.class)
public class Estudio_ { 

    public static volatile SingularAttribute<Estudio, Date> fecha;
    public static volatile SingularAttribute<Estudio, Fragmento> idfragmentoFragmento;
    public static volatile SingularAttribute<Estudio, Integer> idestudio;
    public static volatile CollectionAttribute<Estudio, Observacion> observacionCollection;
    public static volatile SingularAttribute<Estudio, Resultado> resultado;
    public static volatile SingularAttribute<Estudio, Boolean> isActivo;
    public static volatile SingularAttribute<Estudio, Patologo> idpatologoPatologo;
    public static volatile SingularAttribute<Estudio, TipoEstudio> idtipoEstudioTipoEstudio;
    public static volatile SingularAttribute<Estudio, String> numReclamacion;

}