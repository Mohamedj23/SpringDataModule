package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.BuyerBidProduct;
import com.iti.spring.generic.model.entity.BuyerBidProductId;
import com.iti.spring.generic.model.entity.Product;

import java.util.Date;
import java.util.List;

public interface BuyerBidProductDAO extends CommonDAO<BuyerBidProduct, BuyerBidProductId> {

    List<BuyerBidProduct> retrieveBuyerBidProductListByProduct(Product product);

    List<BuyerBidProduct> retrieveBuyerBidProductListByBuyer(Buyer buyer);

    List<BuyerBidProduct> retrieveBuyerBidProductListByDate(Date date);
}
