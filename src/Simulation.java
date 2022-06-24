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
            U1 rocketU1 = new U1();
            rocketArrayList.add(loadRocket(loadItems, rocketU1));
        }
        return rocketArrayList;
    }

    public ArrayList<Rocket> loadU2 (ArrayList<Item> loadItems) {
        ArrayList<Rocket> rocketArrayList = new ArrayList<>();
        while (!isItemListEmpty(loadItems)) {
            U2 rocketU2 =new U2();
            rocketArrayList.add(loadRocket(loadItems, rocketU2));
        }
        return rocketArrayList;
    }

    private static Rocket loadRocket (ArrayList<Item> loadItems, Rocket rocket){
        for (int i = 0; i < loadItems.size(); i++) {
            if (rocket.canCarry(loadItems.get(i))) {
                rocket.carry(loadItems.get(i));
                loadItems.remove(i);
                i--;
            }
        }
        return rocket;
    }

    private static boolean isItemListEmpty (ArrayList<Item> loadItems) {
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

    private static boolean isRocketListEmpty (ArrayList<Rocket> rocketArrayList) {
        return rocketArrayList.size() == 0;
    }


}
