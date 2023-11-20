package project.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.Ship;
import project.model.entity.User;
import project.model.service.ShipServiceModel;
import project.repository.CategoryRepository;
import project.repository.ShipRepository;
import project.repository.UserRepository;
import project.util.CurrentUser;

import java.util.List;
import java.util.Set;


@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void add(ShipServiceModel shipServiceModel) {

        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setCategory(categoryRepository.findByName(shipServiceModel.getCategory()));
        User user = userRepository.findById(currentUser.getId()).orElse(null);
        ship.setUser(user);
        shipRepository.save(ship);
    }

    @Override
    public Set<Ship> getAllShipsOwnedByUserId(String id) {
        return shipRepository.getAllOwnShips(id);
    }

    @Override
    public Set<Ship> getAllOtherShipsNotOwnedByUserId(String id) {
        return shipRepository.getAllOtherShips(id);
    }

    @Override
    public List<Ship> getAllShips() {
        return shipRepository.findAllOrderByNameAndHealthAndPower();
    }

    @Override
    public Ship findByName(String name) {
        return shipRepository.findByName(name).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        shipRepository.deleteById(id);
    }

    @Override
    public void attack(Ship attackShip, Ship defendShip) {
        Integer power = attackShip.getPower();
        Integer health = defendShip.getHealth();

        defendShip.setHealth(health - power);
        shipRepository.save(defendShip);

        if(defendShip.getHealth() <= 0){
            shipRepository.deleteById(defendShip.getId());
        }


    }
}
