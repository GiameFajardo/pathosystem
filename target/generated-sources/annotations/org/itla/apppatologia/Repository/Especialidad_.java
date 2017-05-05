package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Medico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Especialidad.class)
public class Especialidad_ { 

    public static volatile CollectionAttribute<Especialidad, Medico> medicoCollection;
    public static volatile SingularAttribute<Especialidad, Integer> idespecialidad;
    public static volatile SingularAttribute<Especialidad, String> nombre;

}