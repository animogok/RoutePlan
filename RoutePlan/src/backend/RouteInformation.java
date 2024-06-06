package backend;

import java.util.HashMap;
import java.util.Map;
public class RouteInformation {

    /*
     * Generamos los atributos, recalco que la velocidad promedio fue obtenidad de internet para generar una uniformidad
     */

    private final Map<String, Integer> routes_Bog = new HashMap<>(Map.of("ibague",198,"armenia",283,"pereira",321,"manizales",308,"medellin",430,"tunja", 148));
    private final Map<String, Integer> routes_Iba = new HashMap<>(Map.of("bogota",198,"armenia",86,"pereira",129,"manizales",180,"medellin",410,"tunja", 343));
    private final Map<String, Integer> routes_Arm = new HashMap<>(Map.of("ibague",86,"bogota",275,"pereira",47,"manizales",106,"medellin",281,"tunja", 422));
    private final Map<String, Integer> routes_Per = new HashMap<>(Map.of("ibague",130,"armenia",48,"bogota",321,"manizales",52,"medellin",220,"tunja", 461));
    private final Map<String, Integer> routes_Man = new HashMap<>(Map.of("ibague",180,"armenia",102,"pereira",52,"bogota",308,"medellin",205,"tunja", 430));
    private final Map<String, Integer> routes_Med = new HashMap<>(Map.of("ibague",415,"armenia",280,"pereira",215,"manizales",197,"bogota",430,"tunja", 421));
    private final Map<String, Integer> routes_Tun = new HashMap<>(Map.of("ibague",343,"armenia",422,"pereira",461,"manizales",422,"medellin",421,"bogota", 148));

 
    private final double average_vehicleSpeed = 60; //The average speed for Colombia
    private double total_distance;
    private String max_time;
    private double neededFuel;
    private String message_refuel;
    private String message_activePause;
    //Estos dos atributos seran para poder seleccionar entre dos modalidades de rutas dentro de la app
    //Polimorfismo por sobrecarga donde se podra seleccionar entre 3 ciudades o 2 para poder generar el recorrido

    public RouteInformation() {
       
    }

    public void set_totalTime(String city1, String city2) {
        double distance_city2;
        switch (city1.toLowerCase()) {
            case "bogotá" -> {
                this.total_distance = routes_Bog.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Bog.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "ibagué" -> {
                this.total_distance = routes_Iba.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Iba.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "armenia" -> {
                this.total_distance = routes_Arm.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Arm.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "pereira" -> {
                this.total_distance = routes_Per.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Per.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "manizales" -> {
                this.total_distance = routes_Man.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Man.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "medellín" -> {
                this.total_distance = routes_Med.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Med.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            case "tunja" -> {
                this.total_distance = routes_Tun.get(city2.toLowerCase());
                if (this.total_distance < 150){
                    this.message_refuel = "You need 0 refuels";
                } else if(this.total_distance > 150 & this.total_distance < 300){
                    this.message_refuel = "You need 1 refuel in your way";
                } else if( this.total_distance > 300){
                    this.message_refuel = "You will need 2 refuel in your way";
                }
                distance_city2 = routes_Tun.get(city2.toLowerCase())/average_vehicleSpeed;
                convertDoubleToTime(distance_city2);
            }
            default -> distance_city2 = 1;
        }
    }


    private void convertDoubleToTime(double timeValue){
        int hours = (int) timeValue;
        double minutesDouble = (timeValue-hours) * 60;
        int minutes = (int) Math.round(minutesDouble);

        if (hours >= 3){
            this.message_activePause = "You will need atleast " + (Math.round(hours/3)) + " active pauses";
            minutes += 10;
        } else {
            this.message_activePause = "You will need 0 active pauses, be safe";
        }

        this.max_time = String.format("%d:%02d", hours,minutes);
    }
    /*
     * Estos metodos son generales para poder obtener la informacion que puede ser mostrada al usuario dentro de el aplicativo dado el caso no lineal
     */

    public String get_time(){
        return max_time;
    }

    public double get_speed(){
        return average_vehicleSpeed;
    }

    public double get_totaldistance(){
        return total_distance;
    }

    public String get_refuelMessage(){
        return message_refuel;
    }

    public double get_neededFuel(){
        return neededFuel;
    }

    public String get_activePauses(){
        return message_activePause;
    }

    public void set_fuel(String vehicle){
        double averageFuelCapacity;
        double averageAutonomy; //how much distance the vehicle will travel with a full gas tank
        switch (vehicle.toLowerCase()) {
            case "car" -> {
                averageFuelCapacity = 55;
                averageAutonomy = averageFuelCapacity*12;
                this.neededFuel = (total_distance/averageAutonomy)*100;
            }
            case "motorbike" -> {
                averageFuelCapacity = 18;
                averageAutonomy = averageFuelCapacity*10;
                this.neededFuel = (total_distance/averageAutonomy)*100;
            }
            case "passenger bus", "heavy vehicle" -> {
                averageFuelCapacity = 100;
                averageAutonomy = averageFuelCapacity*4;
                this.neededFuel = (total_distance/averageAutonomy)*100;
            }
            default -> {
            }
        }
        

    }

    public static void main(String[] args) {
        RouteInformation rt = new RouteInformation();
        rt.set_totalTime("Bogota", "Armenia");
        System.err.println(rt.get_time());
    }
}
