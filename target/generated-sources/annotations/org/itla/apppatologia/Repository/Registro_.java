package org.itla.apppatologia.Repository;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Caso;
import org.itla.apppatologia.Repository.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Registro.class)
public class Registro_ { 

    public static volatile SingularAttribute<Registro, String> descripcion;
    public static volatile SingularAttribute<Registro, Date> fecha;
    public static volatile SingularAttribute<Registro, Integer> idregistro;
    public static volatile SingularAttribute<Registro, String> tabla;
    public static volatile SingularAttribute<Registro, Caso> idcasoCaso;
    public static volatile SingularAttribute<Registro, Empleado> idempleadoEmpleado;

}