package org.itla.apppatologia.Repository;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Entrega;
import org.itla.apppatologia.Repository.Estudio;
import org.itla.apppatologia.Repository.Observacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Resultado.class)
public class Resultado_ { 

    public static volatile SingularAttribute<Resultado, String> etiologia;
    public static volatile CollectionAttribute<Resultado, Observacion> observacionCollection;
    public static volatile SingularAttribute<Resultado, String> patogenia;
    public static volatile SingularAttribute<Resultado, Boolean> isActivo;
    public static volatile SingularAttribute<Resultado, Estudio> idestudioEstudio;
    public static volatile SingularAttribute<Resultado, Short> idmetodo;
    public static volatile SingularAttribute<Resultado, String> recomendacion;
    public static volatile SingularAttribute<Resultado, Date> fecha;
    public static volatile SingularAttribute<Resultado, Short> idestudio;
    public static volatile SingularAttribute<Resultado, String> manifestacionClinica;
    public static volatile SingularAttribute<Resultado, Entrega> entrega;
    public static volatile SingularAttribute<Resultado, Integer> idresultado;
    public static volatile SingularAttribute<Resultado, String> cambioMorfologico;
    public static volatile SingularAttribute<Resultado, Short> idempleado;
    public static volatile SingularAttribute<Resultado, String> aviso;

}