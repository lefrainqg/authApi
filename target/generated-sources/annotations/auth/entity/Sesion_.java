package auth.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-17T19:45:12")
@StaticMetamodel(Sesion.class)
public class Sesion_ { 

    public static volatile SingularAttribute<Sesion, String> sesUsername;
    public static volatile SingularAttribute<Sesion, Boolean> sesState;
    public static volatile SingularAttribute<Sesion, Integer> sesId;
    public static volatile SingularAttribute<Sesion, String> sesPassword;
    public static volatile SingularAttribute<Sesion, Date> sesLastAccess;
    public static volatile SingularAttribute<Sesion, String> sesUser;

}