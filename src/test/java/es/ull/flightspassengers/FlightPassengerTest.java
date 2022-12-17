package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightPassengerTest {

    @Test
    @DisplayName("Método addPassenger de Flight")
    public void addPassengerTest(){
        Flight vuelo = new Flight("AB1234",2);
        //Pasajero 1
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        vuelo.addPassenger(pasajero);
        assertEquals(vuelo.getNumberOfPassengers(),1);
        //Pasajero 2
        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        vuelo.addPassenger(pasajero2);
        assertEquals(vuelo.getNumberOfPassengers(),2);
        //Pasajero 3, dará error por sobrepasar los asientos
        Passenger pasajero3 = new Passenger("6161616U","David","AF");
        assertThrows(RuntimeException.class,()->{vuelo.addPassenger(pasajero3);} );
    }

    @Test
    @DisplayName("Método removePassenger de Flight")
    public void removePassengerTest(){
        Flight vuelo = new Flight("AB1234",3);
        //Pasajero 1
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        vuelo.addPassenger(pasajero);
        //Pasajero 2
        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        vuelo.addPassenger(pasajero2);
        //Pasajero 3, dará error por sobrepasar los asientos
        Passenger pasajero3 = new Passenger("6161616U","David","AF");
        vuelo.addPassenger(pasajero3);
        assertEquals(vuelo.getNumberOfPassengers(),3);

        //Pasajero 1 eliminado
        vuelo.removePassenger(pasajero);
        assertEquals(vuelo.getNumberOfPassengers(),2);
        //Pasajero 3 eliminado
        vuelo.removePassenger(pasajero3);
        assertEquals(vuelo.getNumberOfPassengers(),1);
        //Casos no correctos
        assertNotEquals(vuelo.getNumberOfPassengers(),2);
        assertNotEquals(vuelo.getNumberOfPassengers(),3);
    }

    @Test
    @DisplayName("Método getFlight de Passenger")
    public void getFlightTest(){
        Flight vuelo = new Flight("AB1234",3);
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        pasajero.setFlight(vuelo);
        //Casos correctos
        assertEquals(pasajero.getFlight().getFlightNumber(),"AB1234");
        assertEquals(pasajero.getFlight().getNumberOfPassengers(),0);
        //Casos no correctos
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"AB");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"1234");
        assertNotEquals(pasajero.getFlight().getNumberOfPassengers(),1);
        assertNotEquals(pasajero.getFlight().getNumberOfPassengers(),2);
    }

    @Test
    @DisplayName("Método setFlight de Passenger")
    public void setFlightTest(){
        Flight vuelo = new Flight("AB1234",3);
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        pasajero.setFlight(vuelo);
        //Casos correctos
        assertEquals(pasajero.getFlight().getFlightNumber(),"AB1234");
        //Casos no correctos
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"AB");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"1234");

        Flight vuelo2 = new Flight("BC5678",3);
        pasajero.setFlight(vuelo2);
        //Casos correctos
        assertEquals(pasajero.getFlight().getFlightNumber(),"BC5678");
        //Casos no correctos
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"AB1234");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"BC");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"5678");
    }

    @Test
    @DisplayName("Método joinFlight de Passenger")
    public void joinFlightTest(){
        Flight vuelo = new Flight("AB1234",1);
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        pasajero.joinFlight(null);
        //Casos correctos
        assertEquals(pasajero.getFlight(),null);
        //Casos no correctos
        assertNotEquals(pasajero.getFlight(),"AB1234");
        assertNotEquals(pasajero.getFlight(),"");
        assertNotEquals(pasajero.getFlight(),1);
        assertNotEquals(pasajero.getFlight(),"1234");

        pasajero.joinFlight(vuelo);
        //Casos correctos
        assertEquals(pasajero.getFlight().getFlightNumber(),"AB1234");
        //Casos no correctos
        assertNotEquals(pasajero.getFlight().getFlightNumber(),null);
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"AB");
        assertNotEquals(pasajero.getFlight().getFlightNumber(),"1234");
    }

}
