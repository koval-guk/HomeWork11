import java.util.Random;

public class PetrolStation {
    private volatile static double amount = 0;
    private static final int numOfFuelDispensers = 3;


    public static Runnable doRefuel(double refuel) {
        int timeOfRefuel = (new Random().nextInt(8) + 3) * 1000;
        return () -> {
            try {
                Thread.sleep(timeOfRefuel);
                amount = amount - refuel;
                System.out.println("refuel: " + refuel + "; amount: " + amount + "; time: " + timeOfRefuel / 1000 + "sek");
            } catch (InterruptedException e) {
                System.out.println("Fuel Dispenser Explosion.");
            }
        };
    }

    public static double getAmount() {
        return amount;
    }

    public static void addAmount(double amount) {
        PetrolStation.amount += amount;
    }

    public static int getNumOfFuelDispensers() {
        return numOfFuelDispensers;
    }
}
