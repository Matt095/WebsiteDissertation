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
@Table(name = "TYPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Types.findAll", query = "SELECT t FROM Types t")
    , @NamedQuery(name = "Types.findByTypeNo", query = "SELECT t FROM Types t WHERE t.typeNo = :typeNo")
    , @NamedQuery(name = "Types.findByItemType", query = "SELECT t FROM Types t WHERE t.itemType = :itemType")})
public class Types implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE_NO")
    private Integer typeNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeNo")
    private Collection<Items> itemsCollection;

    public Types() {
    }

    public Types(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public Types(Integer typeNo, String itemType) {
        this.typeNo = typeNo;
        this.itemType = itemType;
    }

    public Integer getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @XmlTransient
    public Collection<Items> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<Items> itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeNo != null ? typeNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Types)) {
            return false;
        }
        Types other = (Types) object;
        if ((this.typeNo == null && other.typeNo != null) || (this.typeNo != null && !this.typeNo.equals(other.typeNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Types[ typeNo=" + typeNo + " ]";
    }
    
}
