package web.dao;

import web.models.Car;

import java.util.List;

public interface CarsDAO {
    List<Car> getCars(int count);
}
