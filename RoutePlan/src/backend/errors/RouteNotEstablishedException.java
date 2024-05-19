package backend.errors;

public class RouteNotEstablishedException extends Exception {
    public RouteNotEstablishedException(){
        super("The route has not been established");
    }
}