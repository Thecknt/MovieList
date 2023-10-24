import Service.FileMovieService;
import Service.IMovieService;
import Service.ServiceMovieList;

public class MovieCatalog {
    public static void main(String[] args) {

        ServiceMovieList movie = new ServiceMovieList();
        //IMovieService movie = new FileMovieService();
        System.out.println();
        movie.menu();
        }
    }
