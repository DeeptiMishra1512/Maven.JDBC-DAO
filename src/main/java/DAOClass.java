import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DAOClass implements DAOInterface {
/* Fields used to set car

    private int id =0;
    private String makeOfCar = null;
    private String modelOfCar = null;
    private Date yearOfMake = null;
    private String colorOfCar = null;
    private String vinNumber = null;

  */
    private DTOClass extractCarDetailsFromResultSet(ResultSet rs) throws SQLException {
        DTOClass cars = new DTOClass();

        cars.setId( rs.getInt("Id") );
        cars.setMakeOfCar( rs.getString("Make") );
        cars.setModelOfCar( rs.getString("Model") );
        cars.setYearOfMake( rs.getDate("Year") );
        cars.setColorOfCar(rs.getString("Color"));
        cars.setVinNumber(rs.getString("Vin Number"));

        return cars;
    }

    @Override
    public Object findById(int id) {

       // ConnectionFactory connector = new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);

            if(rs.next())
            {
                return extractCarDetailsFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List findAll() {

       // ConnectionFactory connector = new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            List users = new ArrayList();

            while(rs.next())
            {
                DTOClass car = extractCarDetailsFromResultSet(rs);
                users.add(car);
            }

            return users;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

     //   return Collections.emptyList();
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public Object create(Object dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
