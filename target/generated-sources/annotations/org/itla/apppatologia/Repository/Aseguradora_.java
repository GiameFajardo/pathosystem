package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Caso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Aseguradora.class)
public class Aseguradora_ { 

    public static volatile CollectionAttribute<Aseguradora, Caso> casoCollection;
    public static volatile SingularAttribute<Aseguradora, Integer> idaseguradora;
    public static volatile SingularAttribute<Aseguradora, String> direccion;
    public static volatile SingularAttribute<Aseguradora, String> telefono;
    public static volatile SingularAttribute<Aseguradora, String> nombre;

}