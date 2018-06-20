package entity;

import entity.Items;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-19T20:23:37")
@StaticMetamodel(Purchases.class)
public class Purchases_ { 

    public static volatile SingularAttribute<Purchases, Items> itemId;
    public static volatile SingularAttribute<Purchases, Date> purchaseDate;
    public static volatile SingularAttribute<Purchases, Integer> purchaseId;
    public static volatile SingularAttribute<Purchases, Users> email;

}