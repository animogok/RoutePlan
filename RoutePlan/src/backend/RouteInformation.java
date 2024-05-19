package backend;

public class RouteInformation extends Route{

    private int average_vehicleSpeed = 60;

    public RouteInformation(int IdVehicle, int IdCity1, int IdCity2) {
        super(IdVehicle, IdCity1, IdCity2);
    }

    public RouteInformation(int IdVehicle, int IdCity1, int IdCity2, int Idcity3) {
        super(IdVehicle, IdCity1, IdCity2, Idcity3);
    }
    
    
}
