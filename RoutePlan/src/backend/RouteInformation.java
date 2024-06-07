package backend;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.RouteInfo;
public class RouteInformation {

    /*
     * Generamos los atributos, recalco que la velocidad promedio fue obtenidad de internet para generar una uniformidad
     */

    private final Map<String, Integer> routes_Bog = new HashMap<>(Map.of("ibagué",198,"armenia",283,"pereira",321,"manizales",308,"medellín",430,"tunja", 148));
    private final Map<String, Integer> routes_Iba = new HashMap<>(Map.of("bogoté",198,"armenia",86,"pereira",129,"manizales",180,"medellín",410,"tunja", 343));
    private final Map<String, Integer> routes_Arm = new HashMap<>(Map.of("ibagué",86,"bogotá",275,"pereira",47,"manizales",106,"medellín",281,"tunja", 422));
    private final Map<String, Integer> routes_Per = new HashMap<>(Map.of("ibagué",130,"armenia",48,"bogotá",321,"manizales",52,"medellín",220,"tunja", 461));
    private final Map<String, Integer> routes_Man = new HashMap<>(Map.of("ibagué",180,"armenia",102,"pereira",52,"bogotá",308,"medellín",205,"tunja", 430));
    private final Map<String, Integer> routes_Med = new HashMap<>(Map.of("ibagué",415,"armenia",280,"pereira",215,"manizales",197,"bogotá",430,"tunja", 421));
    private final Map<String, Integer> routes_Tun = new HashMap<>(Map.of("ibagué",343,"armenia",422,"pereira",461,"manizales",422,"medellín",421,"bogotá", 148));

 
    private final double average_vehicleSpeed = 60; //The average speed for Colombia
    private double total_distance = 0;
    private String max_time;
    private double neededFuel = 0;
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

    public void view(JFrame planificator, String vehicle, String city1, String city2){

        set_totalTime(city1, city2);
        set_fuel(vehicle);
        
        switch (vehicle) {
            case "car", "motorbike", "passenger bus", "heavy vehicle":
                
                switch (city1) {

                    case "bogotá":
                        switch (city2) {
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-IBG_IBG-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-ARM_ARM-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-PER_PER-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-MAN_MAN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-MED_MED-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-TUN_TUN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "ibagué":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-IBG_IBG-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-IBG_IBG-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-PER_PER-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-MAN_MAN-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-MED_MED-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-IBG_IBG-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "armenia":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-ARM_ARM-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-IBG_IBG-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-PER_PER-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-MAN_MAN-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-MED_MED-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-ARM_ARM-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "pereira":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-PER_PER-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-PER_PER-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-PER_PER-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/MAN-PER_PER-MAN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/PER-MED_MED-PER.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-PER_PER-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "manizales":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-MAN_MAN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-MAN_MAN-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-MAN_MAN-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/MAN-PER_PER-MAN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/MAN-MED_MED-MAN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-MAN_MAN-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "medellín":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-MED_MED-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/IBG-MED_MED-IBG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/ARM-MED_MED-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/PER-MED_MED-PER.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/MAN-MED_MED-MAN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-MED_MED-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "tunja":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/BOG-TUN_TUN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-IBG_IBG-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-ARM_ARM-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-PER_PER-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-MAN_MAN-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-carretera/TUN-MED_MED-TUN.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;

                }
                break;

            case "plane":
                
                switch (city1) {

                    case "bogotá":
                        switch (city2) {
                            case "ibagué":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-IBG_IBG-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-ARM_ARM-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-PER_PER-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-MAN_MAN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-MED_MED-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-TUN_TUN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            default:
                                break;
                        }
                        break;
                    case "ibagué":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-IBG_IBG-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "armenia":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "pereira":
                            JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "manizales":
                            JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "medellín":
                            JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "tunja":
                            JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "armenia":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-ARM_ARM-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "pereira":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "manizales":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/ARM-MED_MED-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "pereira":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-PER_PER-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "armenia":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "manizales":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "medellín":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/PER-MED_MED-PER.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "tunja":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "manizales":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-MAN_MAN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "armenia":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "pereira":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "medellín":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "tunja":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "medellín":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-MED_MED-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "armenia":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/ARM-MED_MED-ARM.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "pereira":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/PER-MED_MED-PER.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "manizales":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "tunja":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "tunja":
                        switch (city2) {
                            case "bogotá":
                                new RouteInfo(planificator, "/archivos/images/trayecto-avion/BOG-TUN_TUN-BOG.png", vehicle, city1, city2, 
                                get_totaldistance(), get_time(), get_speed(), get_refuelMessage(), get_neededFuel(), get_activePauses());
                                break;
                            case "ibagué":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "armenia":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "pereira":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "manizales":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            case "medellín":
                                JOptionPane.showMessageDialog(null, "No es posible este viaje, requiere de escala en bogotá", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;

                }
                break;
        
            default:
                break;
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
