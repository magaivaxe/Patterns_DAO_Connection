
package datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FilmDAO extends DAO<Film>
{
    
    @Override
    public Film find(int id)
    {
        Film f = new Film();
        try
        {
            ResultSet result = this.connect.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
            ).executeQuery(
                                "select * from films where id_film = " + id
                        );
            
            
            if(result.first())
            {
                f = new Film(id,
                                result.getString("nom_film"),
                                result.getString("year_film"),
                                result.getString("desc_film"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public Film create(Film obj)
    {
        try
        {
                PreparedStatement prepare =
                    this.connect
                        .prepareStatement(
                            "insert into "
                            + "films (nom_film,"
                                    + " year_film, desc_film) "
                                + "values (?, ?, ?)"
                                         , Statement.RETURN_GENERATED_KEYS);
                prepare.setString(1, obj.getNom_film());
                prepare.setString(2, obj.getYear_film());
                prepare.setString(3, obj.getDesc_film());
                
                prepare.executeUpdate();
                ResultSet rs = prepare.getGeneratedKeys();
                if (rs.next())
                {
                obj.setId_film(rs.getInt(1)); 
                }
                //obj = this.find(obj.getId_film());
                //System.out.println("ESSSSSSSEEEE AAQQQQQQQQUI" + obj.getId_film());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  obj;
    }

    @Override
    public Film upDate(Film obj)
    {
        try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "update films set nom_film = ' " 
                            + obj.getNom_film()+ "'" 
                            + "where id_film = " + obj.getId_film()
                );
            obj = this.find(obj.getId_film());
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Film obj)
    {
        try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "delete from films where id_film = " 
                        + obj.getId_film()
                );
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
