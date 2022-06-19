public class Rocket implements SpaceShip{
    int cost;
    int rocketWeight;
    int maxWeight;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (this.rocketWeight + item.getWeight()) <= this.maxWeight;

    }
    @Override
    public int carry(Item item) {
        return this.rocketWeight+item.getWeight();
    }
}
