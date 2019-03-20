package ee.taltech.iti0202.tk4.parking;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ParkingLot {

    public int size;
    public static List<Car> cars = new ArrayList<>();
    public Car car;

    public ParkingLot(int size) {
        this.size = size;
    }

    public boolean parkCar(Car car) {
        if (!cars.contains(car) && car.getSize() > 0 && size - car.getSize() >= 0) {
            cars.add(car);
            size = size - car.getSize();
            return true;
        } else {
            return false;
        }
    }

    public Optional<Car> unpark(String model) {
        if (cars.contains(car)) {
            cars.remove(car);
            return Optional.ofNullable(car);
        } else {
            return Optional.empty();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
