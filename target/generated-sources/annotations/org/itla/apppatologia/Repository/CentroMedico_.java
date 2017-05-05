package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Medico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(CentroMedico.class)
public class CentroMedico_ { 

    public static volatile SingularAttribute<CentroMedico, Boolean> isActivo;
    public static volatile CollectionAttribute<CentroMedico, Medico> medicoCollection;
    public static volatile SingularAttribute<CentroMedico, Integer> idcentroMedico;
    public static volatile SingularAttribute<CentroMedico, String> direccion;
    public static volatile SingularAttribute<CentroMedico, String> telefono;
    public static volatile SingularAttribute<CentroMedico, Boolean> isBorrado;
    public static volatile SingularAttribute<CentroMedico, String> nombre;

}