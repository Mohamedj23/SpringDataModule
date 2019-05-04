package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.BuyerBuyProduct;
import com.iti.spring.generic.model.entity.BuyerBuyProductId;
import org.springframework.data.repository.CrudRepository;

public interface BuyerBuyProductDAO extends CrudRepository<BuyerBuyProduct, BuyerBuyProductId> {

}
