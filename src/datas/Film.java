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
public class Film
{
    //Fields
    private int id_film;
    private String nom_film, year_film, desc_film;
    
    //Constructors =============================================
    public Film()
    {
    }
    
    public Film(int id_film, String nom_film, String year_film, String desc_film)
    {
        this.id_film = id_film;
        this.nom_film = nom_film;
        this.year_film = year_film;
        this.desc_film = desc_film;
    }
    
    //Setters and getters =======================================

    public int getId_film()
    {
        return id_film;
    }

    public void setId_film(int id_film)
    {
        this.id_film = id_film;
    }

    public String getNom_film()
    {
        return nom_film;
    }

    public void setNom_film(String nom_film)
    {
        this.nom_film = nom_film;
    }

    public String getYear_film()
    {
        return year_film;
    }

    public void setYear_film(String year_film)
    {
        this.year_film = year_film;
    }

    public String getDesc_film()
    {
        return desc_film;
    }

    public void setDesc_film(String desc_film)
    {
        this.desc_film = desc_film;
    }
    
    //ToString ================================================

    @Override
    public String toString()
    {
        return "Films{" +
                "id_film=" + id_film + 
                ", nom_film=" + nom_film + 
                ", year_film=" + year_film + 
                ", desc_film=" + desc_film + '}';
    }
    
    
}
