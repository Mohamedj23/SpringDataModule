package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.BuyerBidProductDAO;
import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.BuyerBidProduct;
import com.iti.spring.generic.model.entity.BuyerBidProductId;
import com.iti.spring.generic.model.entity.Product;

import java.util.Date;
import java.util.List;

public class BuyerBidProductDAOImpl extends CommonDAOImpl<BuyerBidProduct, BuyerBidProductId> implements BuyerBidProductDAO {
    @Override
    public List<BuyerBidProduct> retrieveBuyerBidProductListByProduct(Product product) {
        return super.retrieveByProperty("product", product);
    }

    @Override
    public List<BuyerBidProduct> retrieveBuyerBidProductListByBuyer(Buyer buyer) {
        return super.retrieveByProperty("buyer", buyer);
    }

    @Override
    public List<BuyerBidProduct> retrieveBuyerBidProductListByDate(Date date) {
        return super.retrieveByProperty("date", date);
    }
}
