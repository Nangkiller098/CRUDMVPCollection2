package repositories.Base;

import db.DbConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseRepositoryImpl
{
    public final DbConnection dbConnection = new DbConnection();
    public Statement statement = null;
    public ResultSet resultSet = null;
    public PreparedStatement preparedStatement =null;

}
