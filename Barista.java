public class Barista implements Printable {
    private static int n;
    private final int id;
    private String name;

    public Barista(String name) {
        this.id = ++n;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return "Бариста № " + id + ". Имя бариста: " + name;
    }
}

