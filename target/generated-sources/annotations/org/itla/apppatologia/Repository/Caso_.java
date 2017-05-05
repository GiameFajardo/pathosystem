package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Aseguradora;
import org.itla.apppatologia.Repository.Paciente;
import org.itla.apppatologia.Repository.Registro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Caso.class)
public class Caso_ { 

    public static volatile SingularAttribute<Caso, Float> porciento_cobertura;
    public static volatile SingularAttribute<Caso, Aseguradora> idaseguradoraAseguradora;
    public static volatile SingularAttribute<Caso, String> estado;
    public static volatile SingularAttribute<Caso, Integer> idfragmento;
    public static volatile SingularAttribute<Caso, String> numeroPoliza;
    public static volatile SingularAttribute<Caso, String> numeroReclamacion;
    public static volatile SingularAttribute<Caso, Boolean> isActivo;
    public static volatile CollectionAttribute<Caso, Registro> registroCollection;
    public static volatile SingularAttribute<Caso, Paciente> idpacientePaciente;
    public static volatile SingularAttribute<Caso, Integer> idcaso;

}