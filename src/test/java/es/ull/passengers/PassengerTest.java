package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerTest {

    @Test
    @DisplayName("Constructor de Passenger")
    public void constructorTest() {
        //Constructor funcional por su countrycode, código de 2 dígitos
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        assertEquals(pasajero.getCountryCode(),"ES");

        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        assertEquals(pasajero2.getCountryCode(),"US");

        //Constructor no funcional por su countrycode
        assertThrows(RuntimeException.class,()->{new Passenger("6234825F","Charlie","USA");} );
        assertThrows(RuntimeException.class,()->{new Passenger("6234825F","Charlie","840");} );
        assertThrows(RuntimeException.class,()->{new Passenger("6234825F","Charlie","Cualquier cosa");} );
    }

    @Test
    @DisplayName("Método getIdentifier de Passenger")
    public void getIdentifierTest(){
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        //Casos correctos
        assertEquals(pasajero.getIdentifier(),"5324334D");
        //Casos no correctos
        assertNotEquals(pasajero.getIdentifier(),"");
        assertNotEquals(pasajero.getIdentifier(),"Daniel");
        assertNotEquals(pasajero.getIdentifier(),"ES");

        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        //Casos correctos
        assertEquals(pasajero2.getIdentifier(),"6767676D");
        //Casos no correctos
        assertNotEquals(pasajero2.getIdentifier(),"");
        assertNotEquals(pasajero2.getIdentifier(),"Charlie");
        assertNotEquals(pasajero2.getIdentifier(),"US");
    }

    @Test
    @DisplayName("Método getName de Passenger")
    public void getNameTest(){
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        //Casos correctos
        assertEquals(pasajero.getName(),"Daniel");
        //Casos no correctos
        assertNotEquals(pasajero.getName(),"");
        assertNotEquals(pasajero.getName(),"5324334D");
        assertNotEquals(pasajero.getName(),"ES");

        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        //Casos correctos
        assertEquals(pasajero2.getName(),"Charlie");
        //Casos no correctos
        assertNotEquals(pasajero2.getName(),"");
        assertNotEquals(pasajero2.getName(),"6767676D");
        assertNotEquals(pasajero2.getName(),"US");
    }

    @Test
    @DisplayName("Método getCountryCode de Passenger")
    public void getCountryCodeTest(){
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        //Casos correctos
        assertEquals(pasajero.getCountryCode(),"ES");
        //Casos no correctos
        assertNotEquals(pasajero.getCountryCode(),"");
        assertNotEquals(pasajero.getCountryCode(),"5324334D");
        assertNotEquals(pasajero.getCountryCode(),"Daniel");

        Passenger pasajero2 = new Passenger("6767676D","Charlie","US");
        //Casos correctos
        assertEquals(pasajero2.getCountryCode(),"US");
        //Casos no correctos
        assertNotEquals(pasajero2.getCountryCode(),"");
        assertNotEquals(pasajero2.getCountryCode(),"6767676D");
        assertNotEquals(pasajero2.getCountryCode(),"Charlie");
    }

    @Test
    @DisplayName("Método toString de Passenger")
    public void toStringTest(){
        Passenger pasajero = new Passenger("5324334D","Daniel","ES");
        //Casos correctos
        assertEquals(pasajero.toString(),"Passenger Daniel with identifier: 5324334D from ES");
        //Casos no correctos
        assertNotEquals(pasajero.toString(),"");
        assertNotEquals(pasajero.toString(),"5324334D");
        assertNotEquals(pasajero.toString(),"Daniel");
        assertNotEquals(pasajero.toString(),"ES");
    }
}
