import java.util.Date;

public class DTOClass implements DTOInterface{

    private int id =0;
    private String makeOfCar = null;
    private String modelOfCar = null;
    private Integer yearOfMake = null;
    private String colorOfCar = null;
    private String vinNumber = null;

    public DTOClass(int id, String makeOfCar, String modelOfCar, Integer yearOfMake, String colorOfCar, String vinNumber) {
        this.id = id;
        this.makeOfCar = makeOfCar;
        this.modelOfCar = modelOfCar;
        this.yearOfMake = yearOfMake;
        this.colorOfCar = colorOfCar;
        this.vinNumber = vinNumber;
    }

    public DTOClass(String makeOfCar, String modelOfCar, Integer yearOfMake, String colorOfCar, String vinNumber) {
        this.makeOfCar = makeOfCar;
        this.modelOfCar = modelOfCar;
        this.yearOfMake = yearOfMake;
        this.colorOfCar = colorOfCar;
        this.vinNumber = vinNumber;
    }

    public DTOClass() {

    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakeOfCar() {
        return makeOfCar;
    }

    public void setMakeOfCar(String makeOfCar) {
        this.makeOfCar = makeOfCar;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }

    public Integer getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(Integer yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getColorOfCar() {
        return colorOfCar;
    }

    public void setColorOfCar(String colorOfCar) {
        this.colorOfCar = colorOfCar;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String toString() {
        return "DTOClass{" +
                "id=" + id +
                ", makeOfCar='" + makeOfCar + '\'' +
                ", modelOfCar='" + modelOfCar + '\'' +
                ", yearOfMake=" + yearOfMake +
                ", colorOfCar='" + colorOfCar + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                '}';
    }
}
