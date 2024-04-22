public class Libro {
    private String name;
    private String author;
    private float cost;
    private int units;

    public Libro(String name, String author, float cost, int units) {
        this.name = name;
        this.author = author;
        this.cost = cost;
        this.units = units;
    }

    public Libro() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
