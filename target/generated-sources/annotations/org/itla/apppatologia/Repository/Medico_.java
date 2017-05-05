package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.CentroMedico;
import org.itla.apppatologia.Repository.Especialidad;
import org.itla.apppatologia.Repository.Fragmento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, Boolean> isActivo;
    public static volatile SingularAttribute<Medico, String> apellido;
    public static volatile SingularAttribute<Medico, CentroMedico> idcentroMedicoCentroMedico;
    public static volatile SingularAttribute<Medico, Especialidad> idespecialidadEspecialidad;
    public static volatile SingularAttribute<Medico, Boolean> isBorrado;
    public static volatile SingularAttribute<Medico, Integer> idmedico;
    public static volatile SingularAttribute<Medico, String> nombre;
    public static volatile CollectionAttribute<Medico, Fragmento> fragmentoCollection;

}