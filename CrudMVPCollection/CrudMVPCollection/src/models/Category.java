package models;

public class Category {
    // Data Member
    private int id;
    private String name;
    private String nameKh;
    private String status;

    // Constructor

    public Category() {
    }

    public Category(int id, String name, String nameKh, String status) {
        this.id = id;
        this.name = name;
        this.nameKh = nameKh;
        this.status = status;
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

    public void setName(String name) {this.name = name;}

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameKh='" + nameKh + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
