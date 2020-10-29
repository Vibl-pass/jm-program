package serice;

import model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService{

    @Override
    public List<Cars> getCars() {
        Cars cars = new Cars(1L, "BMW", "3");
        Cars cars1 = new Cars(2L, "Reno", "Duster");
        Cars cars2 = new Cars(3L, "KIA", "K5");
        Cars cars3 = new Cars(4L, "LADA", "Vesta");
        Cars cars4 = new Cars(5L, "Toyota", "Camry");
        List<Cars> carsList = new ArrayList<>();
        carsList.add(cars);
        carsList.add(cars1);
        carsList.add(cars2);
        carsList.add(cars3);
        carsList.add(cars4);
        return carsList;
    }
}
