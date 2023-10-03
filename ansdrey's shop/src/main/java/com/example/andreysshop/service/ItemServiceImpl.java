package com.example.andreysshop.service;

import com.example.andreysshop.domain.entity.ItemEntity;
import com.example.andreysshop.domain.serviceModel.ItemServiceModel;
import com.example.andreysshop.domain.view.ItemViewModel;
import com.example.andreysshop.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ItemServiceImpl(ItemRepository itemRepository,
                           ModelMapper modelMapper,
                           CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        ItemEntity item = modelMapper.map(itemServiceModel, ItemEntity.class);

        item.setCategory(categoryService.findByCategoryNameEnum(itemServiceModel.getCategory()));

        itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository
                .findAll()
                .stream()
                .map(itemEntity -> {
                    ItemViewModel itemViewModel =
                            modelMapper.map(itemEntity, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.
                            format("/img/%s-%s.jpg", itemEntity.getGender(),
                                    itemEntity.getCategory().getCategoryNameEnum().name()));
                    return itemViewModel;
                }).collect(Collectors.toList());

    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository.findById(id)
                .map(itemEntity -> {
                    ItemViewModel itemViewModel =
                            modelMapper.map(itemEntity, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.
                            format("/img/%s-%s.jpg", itemEntity.getGender(),
                                    itemEntity.getCategory().getCategoryNameEnum().name()));
                    return itemViewModel;
                }).orElse(null);

    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

}

