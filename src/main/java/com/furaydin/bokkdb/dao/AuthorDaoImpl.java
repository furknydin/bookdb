package com.furaydin.bokkdb.dao;

import com.furaydin.bokkdb.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class AuthorDaoImpl implements AuthorDao {

    private final DataSource dataSource;
    @Autowired
    public AuthorDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    @Override
    public Author getById(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM author where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Author author = new Author();
                author.setId(id);
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));

                return author;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (resultSet != null)
                    resultSet.close();
                if (connection !=null)
                    connection.close();
                if(preparedStatement !=null)
                    preparedStatement.close();

            }catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return null;
    }

    public Author getByName(String firstName, String lastName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM author where first_name = ? and last_name = ?");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setFirstName(firstName);
                author.setLastName(lastName);

                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (connection != null)
                    connection.close();
                if (preparedStatement != null)
                    preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return null;
    }
}
