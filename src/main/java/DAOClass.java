import java.sql.*;
import java.util.*;
import java.util.Date;

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

        cars.setId( rs.getInt("id") );
        cars.setMakeOfCar( rs.getString("Make") );
        cars.setModelOfCar( rs.getString("Model") );
        cars.setYearOfMake( rs.getInt("year") );
        cars.setColorOfCar(rs.getString("Color"));
        cars.setVinNumber(rs.getString("Vin"));

        return cars;
    }

    @Override
    public DTOClass findById(int id) {

       // ConnectionFactory connector = new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM car WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractCarDetailsFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<DTOClass> findAll() {

       // ConnectionFactory connector = new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        List<DTOClass> cars = new ArrayList<>();
        try {
            String query = "SELECT * FROM car";
            PreparedStatement stmt = connection.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cars.add(extractCarDetailsFromResultSet(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cars;

     //   return Collections.emptyList();
    }



    @Override
    public DTOClass update(Object dto) {
        DTOClass car = (DTOClass) dto;
        Connection connection = ConnectionFactory.getConnection();
        try {
            String query = "UPDATE car SET make = ?, model = ?, year = ?, color = ?, vin = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, car.getMakeOfCar());
            ps.setString(2, car.getModelOfCar());
            ps.setInt(3, car.getYearOfMake());
            ps.setString(4, car.getColorOfCar());
            ps.setString(5, car.getVinNumber());
            ps.setInt(6, car.getId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                return car;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }



    /*
    @Override
    public Object update(DTOClass dto) {
        //extractCarDetailsFromResultSet
      //  ConnectionFactory connector = new ConnectionFactory();
        /* Fields used to set car

    private int id =0;
    private String makeOfCar = null;
    private String modelOfCar = null;
    private Date yearOfMake = null;
    private String colorOfCar = null;
    private String vinNumber = null;

  */


 /*
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET Make=?, Model=?, year=? ,Color =?, Vin=? WHERE id=?");
            ps.setString(1, dto.getMakeOfCar());
            ps.setString(2, dto.getModelOfCar());
            ps.setDate(3, dto.getYearOfMake());
            ps.setString(4, user.getId());
            ps.setString(5, user.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }
*/


    @Override
    public DTOClass create(Object dto) {

        DTOClass car = (DTOClass) dto;
        Connection connection = ConnectionFactory.getConnection();
        try {
            String query = "INSERT INTO car (make, model, year, color, vin) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, car.getMakeOfCar());
            ps.setString(2, car.getModelOfCar());
            ps.setInt(3, car.getYearOfMake());
            ps.setString(4, car.getColorOfCar());
            ps.setString(5, car.getVinNumber());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    car.setId(rs.getInt(1));
                }
                return car;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            String query = "DELETE FROM car WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }
}
}
