
package mainPack;
import datas.*;
import java.util.Date;


public class FilmClub
{

    
    public static void main(String[] args)
    {
        //DAO<Film> filmDao = new FilmDAO();
        
        /*listFilm(filmDao);
        
        Film film = new  Film(0,"lalalalala", "1998-08-25", "It's good");
        
        filmDao.create(film);
        
        listFilm(filmDao);
        */
        int id_client = 1;
        int id_film = 3;
        int rent_days = 2;
        Clients clients = new ClientsDAO().find(id_client);
        Film film = new FilmDAO().find(id_film);
        
        Dates dates = new Dates(rent_days);
        
        Date rent_date = dates.getRentDate();
        Date dev_date = dates.getDevDate();
        
        RentFilm rentFilm = new RentFilm(
                clients,
                film,
                rent_date,
                dev_date);
        
        DAO<RentFilm> rentDao = new RentFilmDAO();

        rentDao.create(rentFilm);
        
        listFilm(rentDao);
        
        
        
        //listFilm(rentDao); 
    }
    
    public static void listFilm(DAO obj)
    {
        for(int i = 1; i <= 15; i++)
        {
            System.out.println(obj.find(i));
        }
    }
    
}
