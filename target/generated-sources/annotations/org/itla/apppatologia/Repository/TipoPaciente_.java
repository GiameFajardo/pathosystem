package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Paciente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(TipoPaciente.class)
public class TipoPaciente_ { 

    public static volatile SingularAttribute<TipoPaciente, Integer> idtipoPaciente;
    public static volatile CollectionAttribute<TipoPaciente, Paciente> pacienteCollection;
    public static volatile SingularAttribute<TipoPaciente, String> nombre;

}