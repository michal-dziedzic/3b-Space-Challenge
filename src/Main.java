import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("phase-1.txt");
        File file2 = new File("phase-2.txt");
        Scanner phase1scanner = new Scanner(file);
        Scanner phase2scanner = new Scanner(file2);
        Simulation simulation = new Simulation();
        ArrayList<Item> loadedItemsPhase1AndPhase2 = new ArrayList<>();
        loadedItemsPhase1AndPhase2 = simulation.loadItems(phase1scanner, loadedItemsPhase1AndPhase2);
        loadedItemsPhase1AndPhase2 = simulation.loadItems(phase2scanner, loadedItemsPhase1AndPhase2);
        ArrayList<Item> loadedItemsPhase1AndPhase2Copy = new ArrayList<>(loadedItemsPhase1AndPhase2);
        System.out.println("Simulation U1:");
        System.out.println("U1 rocket fleet budget required " + simulation.runSimulation(simulation.loadU1(loadedItemsPhase1AndPhase2)));
        System.out.println("Simulation U2:");
        System.out.println("U2 rocket fleet budget required " + simulation.runSimulation(simulation.loadU2(loadedItemsPhase1AndPhase2Copy)));
    }
}