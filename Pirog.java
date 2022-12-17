public class Pirog extends Coffee {
    private final int id;
    private int cost;
    private int zakaz;

    public Pirog(int cost, int zakaz) {
        this.id = ++n;
        this.cost = cost;
        this.zakaz = zakaz;
    }

    @Override
    public String getInfo() {
        return "Пирог " + id + ": стоимость - " + cost + ", заказы - " + zakaz;
    }

    @Override
    public int getCost() {
        return cost;
    }
    public int getZakaz() {
        return zakaz;
    }

    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setZakaz(int zakaz) {
        this.zakaz = zakaz;
    }
}

