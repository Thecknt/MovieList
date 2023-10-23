package Service;

import domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceMovieList implements IMovieService {
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    Movie movie;
    FileMovieService files;

    private final List<Movie> movies = new ArrayList<>();

    public void saveMovie() {
        movie = new Movie();
        System.out.print("Ingrese el nombre de la Pelicula: ");
        String name = input.next();
        movie.setName(name);
        System.out.print("Ingrese la duracion de la misma en minutos: ");
        int duration = input.nextInt();
        movie.setDuration(duration);
        System.out.print("Ingrese el genero de " + movie.getName() + ": ");
        String gender = input.next();
        movie.setGender(gender);
        System.out.print("Ingrese el nombre del Director: ");
        String director = input.next();
        movie.setDirector(director);
        System.out.print("Ingrese el nombre y apellido del actor/actriz principal: ");
        String act = input.next();
        movie.setPrincActors(act);

        //System.out.println(movie);
        addMovie(movie);
        System.out.println();
    }

    @Override
    public void showMovieList() {
        for (Movie e : movies) {
            System.out.println(e.toString());
        }
        System.out.println();
    }

    @Override
    public void addMovie(Movie movie) {

        movies.add(movie);
        System.out.println(" La Pelicula de "+ movie.getName() + "\nha sido agregada a la Biblioteca satisfactoriamente!");
    }

    @Override
    public void movieSearch(Movie movie) {
        System.out.println("Ingrese el nombre de la Pelicula");
        boolean flag = false;
        String nameMovie = input.next();
        int shelf =movie.getName().indexOf(nameMovie);
        for (Movie e : movies) {
            if (e.getName().equalsIgnoreCase(nameMovie)) {
                flag = true;
            }
            System.out.println();
        }
        if (!flag) {
            System.out.println("La pelicula no se encuentra en la biblioteca");
            System.out.println();
        } else {
            System.out.println("La pelicula " + nameMovie + ", se encuentra alojada en la biblioteca. " +
                    "\nPuede ubicarla en el Estante " + shelf + " de la biblioteca.");
        }
    }

    public void menu() {
       files = new FileMovieService();
        int option;
        boolean exit = false;

            do {
                try {
                System.out.println("Ingrese la opcion deseada: ");
                    System.out.println();
                System.out.println("1) Agregar Pelicula.");
                System.out.println("""
                    2) Mostrar Listado de Peliculas.
                    3) Buscar una Pelicula por Titulo.
                    4) Salir.
                    """);

                    option = input.nextInt();

                switch (option) {
                    case 1 -> saveMovie();
                    case 2 -> showMovieList();
                    case 3 -> movieSearch(movie);
                    case 4 -> {
                        System.out.println("Gracias por utilizar la APP :) ");
                        exit = true;
                    }
                    default -> {
                        System.out.println("Opcion invalida, reintente nuevamente");
                        System.out.println();
                    }
                }
            }catch(Exception e){
                    System.out.println();

                    System.out.println("Ups! ingreso un caracter invalido");
                    System.out.println();
                    //Debo limpiar el buffer sino se crea un ciclo infinito.
                    input.nextLine();
                }
    }while (!exit);
    }
}
