import java.util.List;

public class App {

    public static void main(String[] args) {
        DAOClass carDAO = new DAOClass();

        // Create
        DTOClass newCar = new DTOClass(0, "Hyundai", "Elantra", 2022, "Gray", "1HGCM82633A444444");
        newCar = carDAO.create(newCar);
        System.out.println("Created: " + newCar);

        // Find All
        List<DTOClass> cars = carDAO.findAll();
        System.out.println("All Cars: " + cars);

        // Find By ID
        DTOClass car = carDAO.findById(newCar.getId());
        System.out.println("Found by ID: " + car);

        // Update
        car.setColorOfCar("Black");
        carDAO.update(car);
        System.out.println("Updated: " + car);

        // Delete
        carDAO.delete(car.getId());
        System.out.println("Deleted car with ID: " + car.getId());
    }
}


