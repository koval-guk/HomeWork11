import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GazStationApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(PetrolStation.getNumOfFuelDispensers());

        PetrolStation.addAmount(5000);

        executorService.submit(PetrolStation.doRefuel(Math.ceil(Math.random()*10000)/100));
        executorService.submit(PetrolStation.doRefuel(Math.ceil(Math.random()*10000)/100));
        executorService.submit(PetrolStation.doRefuel(Math.ceil(Math.random()*10000)/100));
        executorService.submit(PetrolStation.doRefuel(Math.ceil(Math.random()*10000)/100));
        executorService.submit(PetrolStation.doRefuel(Math.ceil(Math.random()*10000)/100));

        executorService.shutdown();

    }
}
