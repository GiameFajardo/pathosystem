package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Registro;
import org.itla.apppatologia.Repository.TipoCargo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> pass;
    public static volatile SingularAttribute<Empleado, Boolean> isActivo;
    public static volatile CollectionAttribute<Empleado, Registro> registroCollection;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> sexo;
    public static volatile SingularAttribute<Empleado, Boolean> isBorrado;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, Integer> idempleado;
    public static volatile SingularAttribute<Empleado, TipoCargo> idtipoCargoTipoCargo;

}