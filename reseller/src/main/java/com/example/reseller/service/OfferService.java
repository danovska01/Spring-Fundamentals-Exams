package com.example.reseller.service;


import com.example.reseller.model.entity.Offer;
import com.example.reseller.model.service.OfferServiceModel;

import java.util.List;
import java.util.Set;

public interface OfferService {
    void add(OfferServiceModel offerServiceModel);

    List<Offer> getAllOffers();

    Set<Offer> getOwnOffers();

    void deleteById(String id);

    Set<Offer> getBoughtOffers();

    Offer findById(String id);


    void buyOfferWithId(String id, String id1);
}
