package org.itla.apppatologia.Repository;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Frasco;
import org.itla.apppatologia.Repository.TipoPaciente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Short> idtipoPaciente;
    public static volatile SingularAttribute<Paciente, TipoPaciente> idtipoPacienteTipoPaciente;
    public static volatile SingularAttribute<Paciente, Date> fechaNacimiento;
    public static volatile SingularAttribute<Paciente, Boolean> isActivo;
    public static volatile SingularAttribute<Paciente, String> direccion;
    public static volatile SingularAttribute<Paciente, Boolean> isBorrado;
    public static volatile SingularAttribute<Paciente, Integer> idpaciente;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile CollectionAttribute<Paciente, Caso> casoCollection;
    public static volatile CollectionAttribute<Paciente, Frasco> frascoCollection;
    public static volatile SingularAttribute<Paciente, String> apellido;
    public static volatile SingularAttribute<Paciente, String> telefono;
    public static volatile SingularAttribute<Paciente, String> sexo;

}