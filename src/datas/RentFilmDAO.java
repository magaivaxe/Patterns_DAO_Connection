
package datas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RentFilmDAO extends DAO<RentFilm>
{

    @Override
    public RentFilm find(int id)
    {
        RentFilm r = new RentFilm();
        try
        {
            ResultSet result = this.connect
                        .createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
                        ).executeQuery(
                                "select * from rentfilm where id_rent = " + id
                        );
            if(result.first())
            {
                r = new RentFilm(id,
                                 new ClientsDAO().find(result.getInt("id_client")),
                                 new FilmDAO().find(result.getInt("id_film")),
                                 result.getDate("rent_date"),
                                 result.getDate("dev_date"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public RentFilm create(RentFilm obj)
    {
        try
        {
            PreparedStatement prepare =
                    this.connect
                        .prepareStatement(
                            "insert into "
                            + "rentfilm (id_client,"
                            + " id_film, rent_date, dev_date) "
                            + "values (?, ?, ?, ?)"
                            , Statement.RETURN_GENERATED_KEYS);
            
                prepare.setInt(1, obj.getId_client().getId_client());
                prepare.setInt(2, obj.getId_film().getId_film());
                //Convert util.date to sql.date
                prepare.setDate(3, new Date(obj.getRent_date().getTime()));
                prepare.setDate(4, new Date(obj.getDev_date().getTime()));
                
                prepare.executeUpdate();
                ResultSet rs = prepare.getGeneratedKeys();
                if (rs.next()) 
                {
                    obj.setId_rent(rs.getInt(1));
                }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return  obj;
    }

    @Override
    public RentFilm upDate(RentFilm obj)
    {
        try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "update rentfilm set dev_date = ' " 
                            + new Date(obj.getDev_date().getTime()) + "'" 
                            + " where id_film = " + obj.getId_rent()
                );
            obj = this.find(obj.getId_rent());
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(RentFilm obj)
    {
         try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "delete from rentfilm where id_rent = " 
                        + obj.getId_rent()
                );
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

   
    
}
