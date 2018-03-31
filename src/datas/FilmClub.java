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
public class FilmClub
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DAO<Film> filmDao = new FilmDAO();
        
        listFilm(filmDao);
        
        Film film = new  Film(0,"lalalalala", "1998-08-25", "It's good");
        
        filmDao.create(film);
        
        listFilm(filmDao);
        
    }
    
    public static void listFilm(DAO obj)
    {
        for(int i = 3; i <= 20; i++)
        {
            System.out.println(obj.find(i));
        }
    }
    
}
