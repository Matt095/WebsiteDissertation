package entity;

import entity.Purchases;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-19T20:23:37")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Purchases> purchasesCollection;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, String> email;

}