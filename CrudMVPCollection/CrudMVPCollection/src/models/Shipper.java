package models;

public class Shipper {
    // Field Or Data member
    private int id;
    private String name;
    // Default constructor

    public Shipper() {
    }

    // Constructor have parameter
    public Shipper(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString


    @Override
    public String toString() {
        return "Shipper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
