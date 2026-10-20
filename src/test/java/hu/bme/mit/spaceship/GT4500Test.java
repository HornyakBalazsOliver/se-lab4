package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireLaser_ReturnsFalse() {
        boolean result = ship.fireLaser(FiringMode.SINGLE);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_Single_PrimaryEmpty_FiresSecondary() {
        GT4500 testShip = new GT4500(0, 0.0, 1, 0.0);
        boolean result = testShip.fireTorpedo(FiringMode.SINGLE);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_BothEmpty() {
        GT4500 testShip = new GT4500(0, 0.0, 0, 0.0);
        boolean result = testShip.fireTorpedo(FiringMode.ALL);
        assertEquals(false, result);
    }

    @Test
    void fireTorpedo_All_PrimaryEmpty() {
        GT4500 testShip = new GT4500(0, 0.0, 1, 0.0);
        boolean result = testShip.fireTorpedo(FiringMode.ALL);
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_SecondaryEmpty() {
        GT4500 testShip = new GT4500(1, 0.0, 0, 0.0);
        boolean result = testShip.fireTorpedo(FiringMode.ALL);
        assertEquals(true, result);
    }
}