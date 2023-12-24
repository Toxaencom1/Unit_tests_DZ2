import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;

    @BeforeEach
    void setup() {
        car = new Car("Honda", "CR-V", 2008);
        moto = new Motorcycle("Honda", "CB-400", 2004);
    }

    //     - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    void carIsVehicle() {
        //Assert
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    //    - проверка того, объект Car создается с 4-мя колесами
    @Test
    void carHaveFourWheels() {
        //Assert
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    //    - проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motorcycleHaveTwoWheels() {
        //Assert
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    //    - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void carTestDriveWith60kph() {
        // Act (Выполнение)
        car.testDrive();
        //Assert
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    //    - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void motorcycleTestDriveWith75kph() {
        // Act (Выполнение)
        moto.testDrive();
        //Assert
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    //    - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта)
    //    машина останавливается (speed = 0)
    @Test
    void carDriveAndParkTestSpeedTo0() {
        // Act (Выполнение)
        car.testDrive();
        car.park();
        //Assert
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    //    - проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта)
    //    мотоцикл останавливается (speed = 0)
    @Test
    void motorcycleDriveAndParkTestSpeedTo0() {
        // Act (Выполнение)
        moto.testDrive();
        moto.park();
        //Assert
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}