
package mainPack;
import datas.*;
import java.sql.Date;
import java.time.LocalDate;
import rentShop.RentShop;


public class FilmClub
{
    public static void main(String[] args)
    {
        //DAO<Film> filmDao = new FilmDAO();
        
        /*
        listFilm(filmDao);
        
        Film film = new  Film(0,"lalalalala", "1998-08-25", "It's good");
        
        filmDao.create(film);
        
        listFilm(filmDao);
        int id_client = 1;
        int id_film = 3;
        long rent_days = 2;
        Clients clients = new ClientsDAO().find(id_client);
        Film film = new FilmDAO().find(id_film);
        
        LocalDate localDate_rent = LocalDate.now();
        LocalDate localDate_dev = LocalDate.now().plusDays(rent_days);
        
        Date rent_date = Date.valueOf(localDate_rent);
        Date dev_date = Date.valueOf(localDate_dev);
        
        RentFilm rentFilm = new RentFilm(
                clients,
                film,
                rent_date, 
                dev_date);
        
        DAO<RentFilm> rentDao = new RentFilmDAO();

        rentDao.create(rentFilm);
        
        listFilm(rentDao);
        
        RentShop rentShop = new RentShop();
        */
        //listFilm(rentDao); 
    }
    
    public static void listFilm(DAO obj)
    {
        for(int i = 1; i <= 7; i++)
        {
            System.out.println(obj.find(i));
        }
    }
    
}
