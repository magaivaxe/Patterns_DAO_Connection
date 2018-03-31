/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

/**
 *
 * @author mpgsa
 */
public class RentFilm
{
    private int id_rent;
    private String id_client, id_film, rent_date, dev_date;
    
    //Constructors =====================================================

    public RentFilm()
    {
    }

    public RentFilm(int id_rent, String id_client,
                    String id_film, String rent_date, String dev_date)
    {
        this.id_rent = id_rent;
        this.id_client = id_client;
        this.id_film = id_film;
        this.rent_date = rent_date;
        this.dev_date = dev_date;
    }
    
    //Setters and getters =============================================

    public int getId_rent()
    {
        return id_rent;
    }

    public void setId_rent(int id_rent)
    {
        this.id_rent = id_rent;
    }

    public String getId_client()
    {
        return id_client;
    }

    public void setId_client(String id_client)
    {
        this.id_client = id_client;
    }

    public String getId_film()
    {
        return id_film;
    }

    public void setId_film(String id_film)
    {
        this.id_film = id_film;
    }

    public String getRent_date()
    {
        return rent_date;
    }

    public void setRent_date(String rent_date)
    {
        this.rent_date = rent_date;
    }

    public String getDev_date()
    {
        return dev_date;
    }

    public void setDev_date(String dev_date)
    {
        this.dev_date = dev_date;
    }
    
    //ToString

    @Override
    public String toString()
    {
        return "RentFilm{" 
                + "id_rent=" + id_rent 
                + ", id_client=" + id_client 
                + ", id_film=" + id_film
                + ", rent_date=" + rent_date 
                + ", dev_date=" + dev_date + '}';
    }
    
    
}
