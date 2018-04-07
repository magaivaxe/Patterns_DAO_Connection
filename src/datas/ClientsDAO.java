/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            PreparedStatement prepare =
                    this.connect
                        .prepareStatement(
                            "insert into "
                            + "clients (nom_client,"
                                    + " cell_client, email_client) "
                                + "values (?, ?, ?)"
                                         ,Statement.RETURN_GENERATED_KEYS);
                prepare.setString(1, obj.getNom_client());
                prepare.setString(2, obj.getCell_client());
                prepare.setString(3, obj.getEmail_client());
                
                prepare.executeUpdate();
                ResultSet rs = prepare.getGeneratedKeys();
                
                if (rs.next())
                {
                    obj.setId_client(rs.getInt(1));
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
