package backend;

public class Route {

    /*
     * Declaro los atributos que usaremos, genero los array para poder manejar mejor a la hora de seleccionar con radio buttons o seleccion por marcador, entonces
     * pues al ser enteros se puede indexar rapidamente las ciudades etc, mismo con los vehiculos
     * 
     * Genero que la ruta tenga dos constructores, aqui aplico polimorfismo por sobrecarga donde dado el caso que el usuario quiera hacer un recorrido de 
     * 3 ciudades, pues lo genere
     */

    private String vehicle = "";
    private String city1 = "";
    private String city2 = "";

    public Route(String vehicle, String city1, String city2){
        this.vehicle = vehicle;
        this.city1 = city1;
        this.city2 = city2;
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
}
