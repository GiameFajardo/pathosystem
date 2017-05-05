package org.itla.apppatologia.Repository;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itla.apppatologia.Repository.Estudio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-11T16:08:45")
@StaticMetamodel(Patologo.class)
public class Patologo_ { 

    public static volatile SingularAttribute<Patologo, Boolean> isActivo;
    public static volatile SingularAttribute<Patologo, String> apellido;
    public static volatile SingularAttribute<Patologo, Integer> idpatologo;
    public static volatile CollectionAttribute<Patologo, Estudio> estudioCollection;
    public static volatile SingularAttribute<Patologo, Boolean> isBorrado;
    public static volatile SingularAttribute<Patologo, String> nombre;

}