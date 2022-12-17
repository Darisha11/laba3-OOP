public class Coffee implements Printable {
    protected static int n;
    private int id;
    private int cost;
    private int water;
    private int zerna;
    private int zakaz;

    public Coffee(int cost, int water, int zerna, int zakaz){
        this.id = ++n;
        this.cost = cost;
        this.water = water;
        this.zerna = zerna;
        this.zakaz = zakaz;

    }

    protected Coffee() {
    }

    @Override
    public String getInfo() {
        return "Кофе " + id + ": стоимость - " + cost + ", вода - " + water + ", зёрна - " + zerna + ", заказы - " + zakaz;
    }

    public int getCost() {
        return cost;
    }
    public int getWater() {
        return water;
    }
    public int getZerna() {
        return zerna;
    }
    public int getZakaz() {
        return zakaz;
    }
    public int getId() {
        return id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public void setZerna(int zerna) {
        this.zerna = zerna;
    }
    public void setZakaz(int zakaz) {
        this.zakaz = zakaz;
    }
}

