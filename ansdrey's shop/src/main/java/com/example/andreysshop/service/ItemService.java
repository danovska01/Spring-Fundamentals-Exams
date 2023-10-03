package com.example.andreysshop.service;

import com.example.andreysshop.domain.serviceModel.ItemServiceModel;
import com.example.andreysshop.domain.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(Long id);

    void delete(Long id);
}
