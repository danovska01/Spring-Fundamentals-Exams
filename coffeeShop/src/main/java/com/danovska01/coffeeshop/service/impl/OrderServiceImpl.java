package com.danovska01.coffeeshop.service.impl;

import com.danovska01.coffeeshop.model.entity.Order;
import com.danovska01.coffeeshop.model.service.OrderServiceModel;
import com.danovska01.coffeeshop.model.view.OrderViewModel;
import com.danovska01.coffeeshop.repository.OrderRepository;
import com.danovska01.coffeeshop.sec.CurrentUser;
import com.danovska01.coffeeshop.service.CategoryService;
import com.danovska01.coffeeshop.service.OrderService;
import com.danovska01.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }
    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc().stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
