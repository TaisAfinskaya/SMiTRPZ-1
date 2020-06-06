import exceptions.NoFreePlaceException;
import exceptions.NotFoundCarException;
import exceptions.NotFoundPassengerException;
import passengers.Human;
import passengers.Policeman;
import typepassenger.PoliceTypePassenger;
import vehicles.Bus;
import vehicles.PoliceCar;
import vehicles.Taxi;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoadTest {
    Road road;


    @Before
    public void setUp() throws Exception {
        road = new Road();
        Taxi taxi = new Taxi("car-1", 4);
        taxi.download(new Human("Ivan", "Ivanov", 33));
        road.addCarToRoad(taxi);
    }

    @Test
    public void testGetCountOfHumans() {
        assertEquals(1, road.getCountOfHumans());
        assertNotEquals(3, road.getCountOfHumans());
    }

    @Test(expected = NotFoundCarException.class)
    public void testRemoveVehicle() throws Exception {
        road.removeCarOfRoad(new Taxi("car-2", 4));
    }

    @Test(expected = NotFoundPassengerException.class)
    public void unloadPassenger() throws Exception {
        Bus bus = new Bus("car-3", 32);
        Human human = new Human("Fedor", "Fedorov", 37);
        bus.unload(human);
    }

    @Test(expected = NoFreePlaceException.class)
    public void testFreePlaces() throws Exception {
        PoliceCar policeCar;
        policeCar = new PoliceCar("car-4", 2);
        policeCar.download(new Policeman("Petya", "Petrov", 25, PoliceTypePassenger.PRIVATE));
        policeCar.download(new Policeman("Stepan", "Stepanov", 29, PoliceTypePassenger.CORPORAL));
        policeCar.download(new Policeman("Sydor", "Sydorov", 30, PoliceTypePassenger.PRIVATE));
    }

    @Test
    public void testAddVehicle() {
    }

    @After
    public void tearDown() throws Exception {
        road = null;
    }

}