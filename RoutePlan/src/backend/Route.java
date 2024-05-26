package backend;

public class Route {

    /*
     * Declaro los atributos que usaremos, genero los array para poder manejar mejor a la hora de seleccionar con radio buttons o seleccion por marcador, entonces
     * pues al ser enteros se puede indexar rapidamente las ciudades etc, mismo con los vehiculos
     * 
     * Genero que la ruta tenga dos constructores, aqui aplico polimorfismo por sobrecarga donde dado el caso que el usuario quiera hacer un recorrido de 
     * 3 ciudades, pues lo genere
     */

    private String[] vehicles = {"Plane", "Car", "Motorbike", "Passenger bus", "Heavy vehicles"};
    private String[] cities = {"Bogotá", "Ibagué", "Armenia", "Pereira", "Manizales", "Medellín", "Tunja"};
    private String vehicle = "";
    private String city1 = "";
    private String city2 = "";
    private String city3 = "";

    public Route(int IdVehicle, int IdCity1, int IdCity2){
        this.vehicle = vehicles[IdVehicle];
        this.city1 = cities[IdCity1];
        this.city2 = cities[IdCity2];
    }

    public Route(int IdVehicle, int IdCity1, int IdCity2, int Idcity3){
        this.vehicle = vehicles[IdVehicle];
        this.city1 = cities[IdCity1];
        this.city2 = cities[IdCity2];
        this.city3 = cities[Idcity3];
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getCity3() {
        return city3;
    }

    public void setCity3(String city3) {
        this.city3 = city3;
    }
}
