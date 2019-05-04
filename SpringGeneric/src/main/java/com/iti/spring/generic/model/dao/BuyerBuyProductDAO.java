package com.iti.spring.generic.model.dao;

import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.BuyerBuyProduct;
import com.iti.spring.generic.model.entity.BuyerBuyProductId;
import com.iti.spring.generic.model.entity.Product;

import java.util.Date;
import java.util.List;

public interface BuyerBuyProductDAO extends CommonDAO<BuyerBuyProduct, BuyerBuyProductId> {

    List<BuyerBuyProduct> retrieveBuyerBuyProductListByProduct(Product product);

    List<BuyerBuyProduct> retrieveBuyerBuyProductListByBuyer(Buyer buyer);

    List<BuyerBuyProduct> retrieveBuyerBuyProductListByPaymentDate(Date date);


}
