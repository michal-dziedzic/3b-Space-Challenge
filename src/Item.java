public class Item {
    private String name;
    private int weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWeight(String s) {
        this.weight= Integer.parseInt(s);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
