import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("phase-1.txt");
        Scanner phase1scanner = new Scanner(file);
        ArrayList<Item> loadedItemsPhase1 = loadItems(phase1scanner);
        for (Item item : loadedItemsPhase1) {
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
    }

    private static ArrayList<Item> loadItems (Scanner phaseScanner){
        ArrayList<Item> loadedItems = new ArrayList<>();
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
        ArrayList<Rocket> rocketCargo = new ArrayList<>();
        return rocketCargo;
    }

}
