import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems (Scanner phaseScanner, ArrayList<Item> loadedItems){
        String nameAndWeight;
        String [] splitNameAndWeightFromFile;
        while (phaseScanner.hasNextLine()){
            Item item = new Item();
            nameAndWeight = phaseScanner.nextLine();
            splitNameAndWeightFromFile = nameAndWeight.split("=");
            item.setName(splitNameAndWeightFromFile[0]);
            item.setWeight(splitNameAndWeightFromFile[1]);
            loadedItems.add(item);
        }
        return loadedItems;
    }

    public ArrayList<Rocket> loadU1 (ArrayList<Item> loadItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        while (!isItemListEmpty(loadItems)) {
            U1 rocketU1 =new U1();
            while (!isItemListEmpty(loadItems) && rocketU1.canCarry(loadItems.get(0))){
                rocketU1.carry(loadItems.get(0));
                loadItems.remove(0);
            }
            rocketArrayList.add(rocketU1);
        }
        return rocketArrayList;
    }

    public ArrayList<Rocket> loadU2 (ArrayList<Item> loadItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        while (!isItemListEmpty(loadItems)) {
            U2 rocketU2 =new U2();
            while (!isItemListEmpty(loadItems) && rocketU2.canCarry(loadItems.get(0))){
                rocketU2.carry(loadItems.get(0));
                loadItems.remove(0);
            }
            rocketArrayList.add(rocketU2);
        }
        return rocketArrayList;
    }

    public static boolean isItemListEmpty (ArrayList<Item> loadItems) {
        return loadItems.size() == 0;
    }

    public int runSimulation (ArrayList<Rocket> rocketArrayList) {
        int totalBudget = 0;
        while (!isRocketListEmpty(rocketArrayList)){
            totalBudget=totalBudget+rocketArrayList.get(0).cost;
            if (rocketArrayList.get(0).launch() && rocketArrayList.get(0).land()) {
                rocketArrayList.remove(0);
            }
        }
        return totalBudget;
    }

    public static boolean isRocketListEmpty (ArrayList<Rocket> rocketArrayList) {
        return rocketArrayList.size() == 0;
    }
}
