package org.itla.apppatologia.Repository;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.EstadoFragmento;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Frasco;
import org.itla.apppatologia.Repository.Medico;
import org.itla.apppatologia.Repository.TipoFragmento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Fragmento.class)
public class Fragmento_ { 

    public static volatile SingularAttribute<Fragmento, String> descripcion;
    public static volatile SingularAttribute<Fragmento, String> color;
    public static volatile SingularAttribute<Fragmento, String> peso;
    public static volatile SingularAttribute<Fragmento, Boolean> isActivo;
    public static volatile SingularAttribute<Fragmento, Frasco> idfrascoFrasco;
    public static volatile SingularAttribute<Fragmento, String> origen;
    public static volatile SingularAttribute<Fragmento, String> forma;
    public static volatile SingularAttribute<Fragmento, Date> fecha;
    public static volatile SingularAttribute<Fragmento, Integer> idfragmento;
    public static volatile SingularAttribute<Fragmento, EstadoFragmento> idestadoFragmentoEstadoFragmento;
    public static volatile SingularAttribute<Fragmento, String> diagnostico;
    public static volatile SingularAttribute<Fragmento, Estudio> estudio;
    public static volatile SingularAttribute<Fragmento, TipoFragmento> idtipoFragmentoTipoFragmento;
    public static volatile SingularAttribute<Fragmento, String> estructura;
    public static volatile SingularAttribute<Fragmento, Medico> idmedicoMedico;
    public static volatile SingularAttribute<Fragmento, String> dimension;

}