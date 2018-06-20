package entity;

import entity.Purchases;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-19T20:23:37")
@StaticMetamodel(Items.class)
public class Items_ { 

    public static volatile SingularAttribute<Items, Integer> itemId;
    public static volatile SingularAttribute<Items, String> itemType;
    public static volatile SingularAttribute<Items, Double> cost;
    public static volatile CollectionAttribute<Items, Purchases> purchasesCollection;
    public static volatile SingularAttribute<Items, String> description;
    public static volatile SingularAttribute<Items, Boolean> inStock;
    public static volatile SingularAttribute<Items, Integer> noSold;

}