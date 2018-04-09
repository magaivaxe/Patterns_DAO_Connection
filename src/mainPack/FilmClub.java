
package mainPack;
import datas.*;
import java.util.Date;


public class FilmClub
{

    
    public static void main(String[] args)
    {
        testUpdate();
        
        
    }
    
    public static void testUpdate()
    {
        int id_rentFilm = 8;
        int newDevDate = 6;
        
        RentFilm rfd = new RentFilmDAO().find(id_rentFilm);
        
        Dates newdates = new Dates(newDevDate);
        
        rfd.setDev_date(newdates.getDevDate());
        
        RentFilmDAO rfdao = new RentFilmDAO();
        
        rfdao.upDate(rfd);
        
        DAO<RentFilm> rentDao = new RentFilmDAO();
        
        listFilm(rentDao); 
        
    }
    
    public static void testFilm()
    {
        DAO<Film> filmDao = new FilmDAO();
        
        listFilm(filmDao);
        
        Film film = new  Film(0,"lalalalala", "1998-08-25", "It's good");
        
        filmDao.create(film);
        
        listFilm(filmDao);
    }
    
    public static void testRentFilm()
    {
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
    }
    
    public static void listFilm(DAO obj)
    {
        for(int i = 1; i <= 15; i++)
        {
            System.out.println(obj.find(i));
        }
    }
    
}
