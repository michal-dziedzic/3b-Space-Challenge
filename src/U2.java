public class U2 extends Rocket{
    public U2() {
        this.cost= 12000000;
        this.rocketWeight=18000;
        this.maxWeight=29000;
    }
    @Override
    public boolean launch() {
        double calculation = 0.04 * ((double) (this.rocketWeight-18000))/(29000-18000);
        return isRandomBiggerThenCalculation(calculation);
    }
    @Override
    public boolean land() {
        double calculation = 0.08 * ((double) (this.rocketWeight-18000))/(29000-18000);
        return isRandomBiggerThenCalculation(calculation);
    }
    public boolean isRandomBiggerThenCalculation (double calculation) {
        double random = Math.random();
        if(random<=calculation){
            System.out.println("niepowodzenie " +random);
            return false;
        } else {
            return true;
        }
    }
}
