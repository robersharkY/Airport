package es.ull.flights;

import org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class FlightTest {

    @Test
    @DisplayName("Constructor de Flight")
    public void contructorTest(){
        //Constructores válidos por su número de vuelo, LLNNN o LLNNNN
        Flight vuelo = new Flight("AB1234",50);
        assertEquals(vuelo.getFlightNumber(),"AB1234");
        Flight vuelo2 = new Flight("CD456",50);
        assertEquals(vuelo2.getFlightNumber(),"CD456");

        //Constructores no válidos por su número de vuelo
        assertThrows(RuntimeException.class,()->{new Flight("A1234",65);} );
        assertThrows(RuntimeException.class,()->{new Flight("123456",65);} );
        assertThrows(RuntimeException.class,()->{new Flight("ab3456",65);} );
        assertThrows(RuntimeException.class,()->{new Flight("A456",65);} );
    }

    @Test
    @DisplayName("Método getFlightNumber de Flight")
    public void getFlightNumberTest(){
        Flight vuelo = new Flight("AB1234",50);
        //Casos correctos
        assertEquals(vuelo.getFlightNumber(),"AB1234");
        //Casos no correctos
        assertNotEquals(vuelo.getFlightNumber(),"");
        assertNotEquals(vuelo.getFlightNumber(),"1234");
        assertNotEquals(vuelo.getFlightNumber(),"AB");

        Flight vuelo2 = new Flight("CD344",50);
        //Casos correctos
        assertEquals(vuelo2.getFlightNumber(),"CD344");
        //Casos no correctos
        assertNotEquals(vuelo2.getFlightNumber(),"");
        assertNotEquals(vuelo2.getFlightNumber(),"344");
        assertNotEquals(vuelo2.getFlightNumber(),"CD");
    }
}
