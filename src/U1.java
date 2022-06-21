public class U1 extends Rocket{
    public U1() {
        this.cost= 100000000;
        this.rocketWeight=10000;
        this.maxWeight=18000;
    }

    @Override
    public boolean launch() {
        double calculation = 0.05 * ((double) (this.rocketWeight-10000))/(18000-10000);
        return isRandomBiggerThenCalculation(calculation);
    }
    @Override
    public boolean land() {
        double calculation = 0.01 * ((double) (this.rocketWeight-10000))/(18000-10000);
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
