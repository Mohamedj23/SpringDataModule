package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.BuyerBidProduct;
import com.iti.spring.generic.model.entity.BuyerBidProductId;
import com.iti.spring.generic.model.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuyerBidProductDAO extends CrudRepository<BuyerBidProduct, BuyerBidProductId> {

    List<BuyerBidProduct> findBuyerBidProductsByProduct(Product product);
}
