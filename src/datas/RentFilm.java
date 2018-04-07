/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

import java.util.Date;

/**
 *
 * @author mpgsa
 */
public class RentFilm
{
    private int id_rent = 0;
    private Date rent_date, dev_date;
    
    private Film film;
    private Clients clients;
    //Constructors =====================================================

    public RentFilm()
    {
    }
    //Constructor to insert
    public RentFilm(
            Clients clients,
            Film film, Date rent_date, Date dev_date)
    {
        this.rent_date = rent_date;
        this.dev_date = dev_date;
        this.film = film;
        this.clients = clients;
    }
    //Constructor to get values
    public RentFilm(int id_rent, Clients clients,
                    Film film, Date rent_date, Date dev_date)
    {
        this.clients = clients;
        this.film = film;
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

    public Clients getId_client()
    {
        return clients;
    }

    public void setId_client(Clients clients)
    {
        this.clients = clients;
    }

    public Film getId_film()
    {
        return film;
    }

    public void setId_film(Film film)
    {
        this.film = film;
    }

    public Date getRent_date()
    {
        return rent_date;
    }

    public void setRent_date(Date rent_date)
    {
        this.rent_date = rent_date;
    }

    public Date getDev_date()
    {
        return dev_date;
    }

    public void setDev_date(Date dev_date)
    {
        this.dev_date = dev_date;
    }
    
    //ToString

    @Override
    public String toString()
    {
        return "RentFilm{" 
                + "id_rent=" + id_rent 
                + ", id_client=" + clients 
                + ", id_film=" + clients
                + ", rent_date=" + rent_date 
                + ", dev_date=" + dev_date + '}';
    }
    
    
}
