import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("phase-1.txt");
        File file2 = new File("phase-2.txt");
        Scanner phase1scanner = new Scanner(file);
        Scanner phase2scanner = new Scanner(file2);
        ArrayList<Item> loadedItemsPhase1AndPhase2 = new ArrayList<>();
        loadedItemsPhase1AndPhase2 = loadItems(phase1scanner, loadedItemsPhase1AndPhase2);
        loadedItemsPhase1AndPhase2 = loadItems(phase2scanner, loadedItemsPhase1AndPhase2);
        for (Item item : loadedItemsPhase1AndPhase2) {
            System.out.println(item.getName() + "=" + item.getWeight());
        }
        U1 u1 =new U1();
        u1.launch();
        for (int i = 0; i < 100; i++) {
           u1.launch();
        }
        Item bigitem = new Item();
        bigitem.setName("biitema");
        bigitem.setWeight(3000);
        System.out.println(u1.canCarry(bigitem));
        u1.carry(bigitem);
        System.out.println(u1.rocketWeight);
        u1.carry(bigitem);
        System.out.println(u1.rocketWeight);
        Simulation simulation = new Simulation();
//        System.out.println(simulation.runSimulation(simulation.loadU1(loadedItemsPhase1)));
        System.out.println(simulation.runSimulation(simulation.loadU2(loadedItemsPhase1AndPhase2)));

    }

    private static ArrayList<Item> loadItems (Scanner phaseScanner, ArrayList<Item> loadedItems){
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

    private ArrayList<Rocket> loadU1 (ArrayList<Item> loadItems) {
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

    private ArrayList<Rocket> loadU2 (ArrayList<Item> loadItems) {
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

    private static boolean isItemListEmpty (ArrayList<Item> loadItems) {
        return loadItems.size() == 0;
    }

    private int runSimulation (ArrayList<Rocket> rocketArrayList) {
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
