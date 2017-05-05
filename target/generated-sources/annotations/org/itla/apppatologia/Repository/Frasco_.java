package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Fragmento;
import org.itla.apppatologia.Repository.Paciente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Frasco.class)
public class Frasco_ { 

    public static volatile SingularAttribute<Frasco, Short> idfragmento;
    public static volatile SingularAttribute<Frasco, Boolean> isActivo;
    public static volatile SingularAttribute<Frasco, Fragmento> fragmento;
    public static volatile SingularAttribute<Frasco, Paciente> idpacientePaciente;
    public static volatile SingularAttribute<Frasco, Integer> idfrasco;

}