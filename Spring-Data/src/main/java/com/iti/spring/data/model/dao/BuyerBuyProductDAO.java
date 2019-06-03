package com.iti.spring.data.model.dao;

import com.iti.spring.generic.model.entity.BuyerBuyProduct;
import com.iti.spring.generic.model.entity.BuyerBuyProductId;
import com.iti.spring.generic.model.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BuyerBuyProductDAO extends CrudRepository<BuyerBuyProduct, BuyerBuyProductId> {

    @Query("select sum(b.amount*b.quantity) from BuyerBuyProduct b where b.product = :product")
    long findTotalAmountByProduct(@Param("product") Product product);

}
