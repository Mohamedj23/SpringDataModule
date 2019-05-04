package com.iti.spring.hibernate.model.dao.impl;

import com.iti.spring.generic.model.dao.BuyerBuyProductDAO;
import com.iti.spring.generic.model.entity.Buyer;
import com.iti.spring.generic.model.entity.BuyerBuyProduct;
import com.iti.spring.generic.model.entity.BuyerBuyProductId;
import com.iti.spring.generic.model.entity.Product;

import java.util.Date;
import java.util.List;

public class BuyerBuyProductDAOImpl extends CommonDAOImpl<BuyerBuyProduct, BuyerBuyProductId> implements BuyerBuyProductDAO {
    @Override
    public List<BuyerBuyProduct> retrieveBuyerBuyProductListByProduct(Product product) {
        return super.retrieveByProperty("product", product);
    }

    @Override
    public List<BuyerBuyProduct> retrieveBuyerBuyProductListByBuyer(Buyer buyer) {
        return super.retrieveByProperty("buyer", buyer);
    }

    @Override
    public List<BuyerBuyProduct> retrieveBuyerBuyProductListByPaymentDate(Date date) {
        return super.retrieveByProperty("paymentDate", date);
    }
}
