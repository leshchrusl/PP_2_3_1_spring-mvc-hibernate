package web.service;

import web.dao.CarsDAO;
import web.dao.CarsDAOImpl;
import web.models.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarServiceImpl implements CarService {

    CarsDAO carsDAO = new CarsDAOImpl();

    @Override
    public List<Car> getCars(int count) {
        return carsDAO.getCars(count);
    }
}
