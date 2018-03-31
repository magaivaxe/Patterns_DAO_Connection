
package datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
                                 result.getString("id_client"),
                                 result.getString("id_film"),
                                 result.getString("rent_date"),
                                 result.getString("dev_date"));
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
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select nextval('id_rent') as id"
                    );
            if (result.first())
            {
                int id = result.getInt("id_rent");
                PreparedStatement prepare =
                    this.connect
                        .prepareStatement(
                            "insert into "
                            + "films (id_rent, id_client,"
                                    + " id_film, rent_date, dev_date) "
                                + "values (?, ?, ?, ?, ?)"
                                         );
                prepare.setInt(1, id);
                prepare.setString(2, obj.getId_client());
                prepare.setString(3, obj.getId_film());
                prepare.setString(4, obj.getRent_date());
                prepare.setString(5, obj.getDev_date());
                
                prepare.executeUpdate();
                obj = this.find(id);
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
                            + obj.getDev_date() + "'" 
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
