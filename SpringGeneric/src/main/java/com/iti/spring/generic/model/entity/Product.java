package com.iti.spring.generic.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
        ,catalog="biddingschema"
)
public class Product  implements java.io.Serializable {


    private Integer id;
    private Seller seller;
    private String name;
    private String description;
    private String manufacturingName;
    private Date manufacturingDate;
    private Date expirationDate;
    private int quantity;
    private Date offeredDate;
    private Date finishDate;
    private Set<Category> categories = new HashSet<Category>(0);
    private Set<BuyerBidProduct> buyerBidProducts = new HashSet<BuyerBidProduct>(0);
    private Set<BuyerBuyProduct> buyerBuyProducts = new HashSet<BuyerBuyProduct>(0);

    public Product() {
    }


    public Product(String name, String manufacturingName, Date manufacturingDate, int quantity, Date offeredDate, Date finishDate) {
        this.name = name;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
    }
    public Product(Seller seller, String name, String description, String manufacturingName, Date manufacturingDate, Date expirationDate, int quantity, Date offeredDate, Date finishDate, Set<Category> categories, Set<BuyerBidProduct> buyerBidProducts, Set<BuyerBuyProduct> buyerBuyProducts) {
        this.seller = seller;
        this.name = name;
        this.description = description;
        this.manufacturingName = manufacturingName;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.offeredDate = offeredDate;
        this.finishDate = finishDate;
        this.categories = categories;
        this.buyerBidProducts = buyerBidProducts;
        this.buyerBuyProducts = buyerBuyProducts;
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)


    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="seller_id")
    public Seller getSeller() {
        return this.seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }


    @Column(name="name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name="description", length=150)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name="manufacturing_name", nullable=false, length=100)
    public String getManufacturingName() {
        return this.manufacturingName;
    }

    public void setManufacturingName(String manufacturingName) {
        this.manufacturingName = manufacturingName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="manufacturing_date", nullable=false, length=10)
    public Date getManufacturingDate() {
        return this.manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date", length=10)
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="offered_date", nullable=false, length=10)
    public Date getOfferedDate() {
        return this.offeredDate;
    }

    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="finish_date", nullable=false, length=10)
    public Date getFinishDate() {
        return this.finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="product_has_category", catalog="biddingschema", joinColumns = {
            @JoinColumn(name="product_id", nullable=false, updatable=false) }, inverseJoinColumns = {
            @JoinColumn(name="category_id", nullable=false, updatable=false) })
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<BuyerBidProduct> getBuyerBidProducts() {
        return this.buyerBidProducts;
    }

    public void setBuyerBidProducts(Set<BuyerBidProduct> buyerBidProducts) {
        this.buyerBidProducts = buyerBidProducts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    public Set<BuyerBuyProduct> getBuyerBuyProducts() {
        return this.buyerBuyProducts;
    }

    public void setBuyerBuyProducts(Set<BuyerBuyProduct> buyerBuyProducts) {
        this.buyerBuyProducts = buyerBuyProducts;
    }




}


