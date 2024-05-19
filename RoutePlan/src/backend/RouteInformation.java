package backend;

import java.time.Duration;
import backend.errors.*;;
public class RouteInformation extends Route{

    private StringBuilder message = new StringBuilder();
    private int average_vehicleSpeed = 60; //The average speed for Colombia
    private double total_distance;
    private Duration min_time;
    private Duration max_time;
    private boolean routeReady = false;
    private int totalFuel;

    private boolean routeType1 = false; //Direct route, no stops and everything related, just going to the city
    private boolean routeType2 = false; //Route with stops and other things the app should pop out

    public RouteInformation(int IdVehicle, int IdCity1, int IdCity2) {
        super(IdVehicle, IdCity1, IdCity2);
    }

    public RouteInformation(int IdVehicle, int IdCity1, int IdCity2, int Idcity3) {
        super(IdVehicle, IdCity1, IdCity2, Idcity3);
    }
    
    public void set_route(int idRouteType){
        routeReady = true;
        if (idRouteType == 0){
            routeType1 = true;
        } else {
            routeType2 = true;
        }
    }

    private void set_totalDistance(){
        /*
         * Encontrar la forma de generar las distancias que hay entre las ciudades, esto por carretera
         */
    }

    public void set_times(){
        set_totalDistance();
        try{
            if (!routeReady){
                throw new RouteNotEstablishedException();
            }
            /*
            * Idea para poder generar un establecimiento claro con respecto a las distancias entre las ciudades, luego generar dos tipos
            * de promedios, el del tiempo minimo el cual va a ser con una velocidad promedio mayor, a su vez se le restara algunos minutos
            * el tiempo maximo todo lo contrario
            */ 
        } catch (RouteNotEstablishedException rne){
            rne.getMessage();
        }
    }

    public String get_mintime(){
        return min_time.toString();
    }

    public String get_maxtime(){
        return max_time.toString();
    }

    public void set_routeType(){
        double averageFuelCapacity = 55;
        double averageAutonomy = 10 * averageFuelCapacity; //how much distance the vehicle will travel with a full gas tank 

        if (routeType1){
            if ((total_distance/averageAutonomy) > 1){
                message.append("You will need a refuel in the travel");
            }
        }

        if (routeType2){
            long refuelFuel = Math.round(total_distance/averageAutonomy);
            double activePauses = (total_distance/average_vehicleSpeed)/3;
            if ((total_distance/averageAutonomy) > 1){
                message.append("You will need " + refuelFuel);
                if (activePauses > 1){
                    message.append(" and " + Math.round(activePauses) + " active pauses");
                }
            }
        }
    }
}
