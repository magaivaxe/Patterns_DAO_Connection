/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mpgsa
 */
public class ClientsDAO extends DAO<Clients>
{

    @Override
    public Clients find(int id)
    {
        Clients c = new Clients();
        try
        {
            ResultSet result = this.connect
                        .createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
                        ).executeQuery(
                                "select * from clients where id_client = " + id
                        );
            if(result.first())
            {
                c = new Clients(id,
                                result.getString("nom_client"),
                                result.getString("cell_client"),
                                result.getString("email_client"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Clients create(Clients obj)
    {
        try
        {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select nextval('id_client') as id"
                    );
            if (result.first())
            {
                int id = result.getInt("id_client");
                PreparedStatement prepare =
                    this.connect
                        .prepareStatement(
                            "insert into "
                            + "clients (id_client, nom_client,"
                                    + " cell_client, email_client) "
                                + "values (?, ?, ?, ?)"
                                         );
                prepare.setInt(1, id);
                prepare.setString(2, obj.getNom_client());
                prepare.setString(3, obj.getCell_client());
                prepare.setString(4, obj.getEmail_client());
                
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
    public Clients upDate(Clients obj)
    {
        try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "update clients set cell_client = ' " 
                            + obj.getCell_client() + "'" 
                            + "where id_client = " + obj.getId_client()
                );
            obj = this.find(obj.getId_client());
            
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Clients obj)
    {
        try
        {
            this.connect
                .createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "delete from clients where id_client = " 
                        + obj.getId_client()
                );
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
