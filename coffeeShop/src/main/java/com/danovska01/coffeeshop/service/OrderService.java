package com.danovska01.coffeeshop.service;


import com.danovska01.coffeeshop.model.service.OrderServiceModel;
import com.danovska01.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
