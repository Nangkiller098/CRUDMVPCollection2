package models;

public class Users
{
    private int Id;
    private String Firstname;
    private String LastName;
    private String Email;
    private String Address;

    public Users()
    {

    }
    public Users(int id, String firstname, String lastName, String email, String address) {
        this.Id = id;
        Firstname = firstname;
        LastName = lastName;
        Email = email;
        Address = address;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public String getFirstname() {
        return Firstname;
    }
    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastName() {return LastName;}
    public void setLastName(String lastName) {this.LastName = lastName;}

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAddress(){return Address;}
    public void  setAddress(String address){this.Address=address;}

    @Override
    public String toString() {
        return "Users{" +
                "id=" + Id +
                ", firstName='" + Firstname + '\'' +
                ", lastName='" + LastName + '\'' +
                ", email='" + Email + '\'' +
                ", address='" + Address + '\'' +

                '}';
    }

}
