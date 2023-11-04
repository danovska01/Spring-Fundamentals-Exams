package com.danovska01.shoppinglist.service;

import com.danovska01.shoppinglist.model.entity.enums.CategoryName;
import com.danovska01.shoppinglist.model.service.ProductServiceModel;
import com.danovska01.shoppinglist.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyById(String id);

    void buyAll();
}
