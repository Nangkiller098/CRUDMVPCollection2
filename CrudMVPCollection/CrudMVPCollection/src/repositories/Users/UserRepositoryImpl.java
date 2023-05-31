package repositories.Users;

import models.Users;
import repositories.Base.BaseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl implements UserRepository {

    @Override
    public List<Users> FindAllData() {
        List<Users> list = new ArrayList<>();
        String sql = "SELECT * FROM \"Users\"";
        try {
            statement = dbConnection.conn().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Users users = new Users();
                users.setId(resultSet.getInt("Id"));
                users.setFirstname(resultSet.getString("Firstname"));
                users.setLastName(resultSet.getString("LastName"));
                users.setEmail(resultSet.getString("Email"));
                users.setAddress(resultSet.getString("Address"));
                list.add(users);
            }
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
        return list;
    }

    @Override
    public void insert(Users users)
    {
        String sql="INSERT INTO \"Users\"(\"Firstname\", \"LastName\", \"Email\", \"Address\") VALUES (?, ?, ?, ?);;";
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            preparedStatement.setString(1,users.getFirstname());
            preparedStatement.setString(2,users.getLastName());
            preparedStatement.setString(3,users.getEmail());
            preparedStatement.setString(4,users.getAddress());
            int result  =preparedStatement.executeUpdate();
            if (result>0)
            {
                System.out.println("Insert User success:");
            }
            dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all Users "+e.getMessage());
        }
    }

    @Override
    public Users findById(Integer id) {
        Users users = new Users();
        String sql = "SELECT * FROM \"Users\" where id="+id;
        try {
            statement = dbConnection.conn().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                users.setId(resultSet.getInt("Id"));
                users.setFirstname(resultSet.getString("Firstname"));
                users.setLastName(resultSet.getString("LastName"));
                users.setEmail(resultSet.getString("Email"));
                users.setAddress(resultSet.getString("Address"));
            }
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
        return  users;
    }

    @Override
    public void update(Users users, Integer id)
    {
        String sql = "UPDATE \"Users\" SET \"Firstname\"=?, \"LastName\"=?, \"Email\"=?, \"Address\"=? WHERE id="+id;
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            preparedStatement.setString(1,users.getFirstname());
            preparedStatement.setString(2,users.getLastName());
            preparedStatement.setString(3,users.getEmail());
            preparedStatement.setString(4,users.getAddress());
            int result  =preparedStatement.executeUpdate();
            if (result>0)
            {
                System.out.println("Update User success:");
            }
            else
            {
                System.out.println("Something went wrong:");
            }
            dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all User "+e.getMessage());
        }
    }

    @Override
    public void delete(Integer id)
    {
        Users users = new Users();
        String sql = "DELETE FROM \"Users\" WHERE Id="+id;
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            int result  =preparedStatement.executeUpdate();
            if (result>0)
            {
                System.out.println("Delete User success:");
            }
            dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all User "+e.getMessage());
        }
    }
}
