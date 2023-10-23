package Service;

import domain.Movie;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

//Creo una clase para manejar el guardado de archivos
public class FileMovieService implements IMovieService{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";
    private FileMovieService(){
        File file = new File(NOMBRE_ARCHIVO);
        try {
         //Si ya existe el archivo, NO  se crea
         if (file.exists()){
             System.out.println("El archivo ya existe!");
         } else {
             //Si no existe se crea el archivo vacio.
             FileWriter fileTxt = new FileWriter(file);
             PrintWriter txt = new PrintWriter(fileTxt);
             txt.close(); //cierro para guardar el archivo
             System.out.println("Archivo creado exitosamente!");
         }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "+e.getMessage());
        }
    }
    @Override
    public void showMovieList() {

    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void movieSearch(Movie movie) {

    }
}
