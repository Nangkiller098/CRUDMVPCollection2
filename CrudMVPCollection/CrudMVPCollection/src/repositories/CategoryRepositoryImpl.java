package repositories;

import db.DbConnection;
import models.Category;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final DbConnection dbConnection = new DbConnection();
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement =null;

    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "select * from categories where status  = 'ACT'";
        try {
            statement = dbConnection.conn().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setNameKh(resultSet.getString("name_kh"));
                category.setStatus(resultSet.getString("status"));
                categoryList.add(category);
            }
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
        return categoryList;
    }

    @Override
    public void insert(Category category)
    {
        String sql="INSERT INTO categories(name, name_kh, status) VALUES(?,?,?)";
        category.setStatus("ACT");
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getNameKh());
            preparedStatement.setString(3,category.getStatus());
        int result  =preparedStatement.executeUpdate();
        if (result>0)
        {
            System.out.println("Insert category success:");
        }
        dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
    }

    @Override
    public Category findById(Integer id)
    {
        Category category = new Category();
        String sql = "select * from categories where status='ACT' and id="+id;
        try {
            statement = dbConnection.conn().createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setNameKh(resultSet.getString("name_kh"));
            }
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
        return  category;
    }

    @Override
    public void update(Category category,Integer id)
    {
        String sql = "UPDATE categories SET name=?, name_kh=?, status=? WHERE id="+id;
        category.setStatus("ACT");
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getNameKh());
            preparedStatement.setString(3,category.getStatus());
            int result  =preparedStatement.executeUpdate();
            if (result>0)
            {
                System.out.println("Update category success:");
            }
            dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
    }

    @Override
    public void delete(Integer id)
    {
        Category category = new Category();
        category.setStatus("DEL");
        String sql = "UPDATE public.categories SET status='DEL' WHERE id="+id;
        try
        {
            preparedStatement= dbConnection.conn().prepareStatement(sql);
            int result  =preparedStatement.executeUpdate();
            if (result>0)
            {
                System.out.println("Delete category success:");
            }
            dbConnection.conn().close();
        } catch (Throwable e) {
            System.out.println("Error get all category "+e.getMessage());
        }
    }
}
