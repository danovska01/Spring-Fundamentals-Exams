package project.service;


import project.model.entity.Ship;
import project.model.service.ShipServiceModel;

import java.util.List;
import java.util.Set;

public interface ShipService {
    void add(ShipServiceModel map);

    Set<Ship> getAllShipsOwnedByUserId(String id);

    Set<Ship> getAllOtherShipsNotOwnedByUserId(String id);

    List<Ship> getAllShips();

    Ship findByName(String name);

    void deleteById(String id);

    void attack(Ship attackShip, Ship defendShip);
}
