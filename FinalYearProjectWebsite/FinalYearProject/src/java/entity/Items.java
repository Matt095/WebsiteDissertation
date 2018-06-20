/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpmchad
 */
@Entity
@Table(name = "ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i")
    , @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId")
    , @NamedQuery(name = "Items.findByCost", query = "SELECT i FROM Items i WHERE i.cost = :cost")
    , @NamedQuery(name = "Items.findByDescription", query = "SELECT i FROM Items i WHERE i.description = :description")
    , @NamedQuery(name = "Items.findByNoSold", query = "SELECT i FROM Items i WHERE i.noSold = :noSold")
    , @NamedQuery(name = "Items.findByInStock", query = "SELECT i FROM Items i WHERE i.inStock = :inStock")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST")
    private double cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_SOLD")
    private int noSold;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IN_STOCK")
    private Boolean inStock;
    @JoinColumn(name = "TYPE_NO", referencedColumnName = "TYPE_NO")
    @ManyToOne(optional = false)
    private Types typeNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<Purchases> purchasesCollection;

    public Items() {
    }

    public Items(Integer itemId) {
        this.itemId = itemId;
    }

    public Items(Integer itemId, double cost, String description, int noSold, Boolean inStock) {
        this.itemId = itemId;
        this.cost = cost;
        this.description = description;
        this.noSold = noSold;
        this.inStock = inStock;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoSold() {
        return noSold;
    }

    public void setNoSold(int noSold) {
        this.noSold = noSold;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Types getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Types typeNo) {
        this.typeNo = typeNo;
    }

    @XmlTransient
    public Collection<Purchases> getPurchasesCollection() {
        return purchasesCollection;
    }

    public void setPurchasesCollection(Collection<Purchases> purchasesCollection) {
        this.purchasesCollection = purchasesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Items[ itemId=" + itemId + " ]";
    }
    
}
