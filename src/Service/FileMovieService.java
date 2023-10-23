package Service;

import domain.Movie;

import java.io.*;

//Creo una clase para manejar el guardado de archivos
public class FileMovieService implements IMovieService{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    FileWriter fileTxt;
    PrintWriter txt;
    File file;
    FileMovieService(){
        file = new File(NOMBRE_ARCHIVO);
        try {
         //Si ya existe el archivo, NO  se crea
         if (file.exists()){
             System.out.println("El archivo ya existe!");
         } else {
             //Si no existe se crea el archivo vacio.
             fileTxt = new FileWriter(file);
             txt = new PrintWriter(fileTxt);
             txt.close(); //cierro para guardar el archivo
             System.out.println("Archivo creado exitosamente!");
         }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "+e.getMessage());
        }
    }
    @Override
    public void showMovieList() {

        //Vuelvo a abrir el archivo
    file = new File(NOMBRE_ARCHIVO);

    try {
        System.out.println("Listado de Peliculas");

        //Abro el archivo para leer las peliculas guardadas
        BufferedReader read = new BufferedReader(new FileReader(file));

        //Leo linea a linea el archivo
        String line;
        line = read.readLine();

        //Leo todas las lineas del archivo
        while (line != null){
            var movie = new Movie(line);
            System.out.println(movie);

            //Antes de terminar el ciclo vuelvo a leer el archivo
            line = read.readLine();
        }
        //Cierro el archivo
        read.close();
    }catch(Exception e){
        System.out.println("Ocurrio un error al leer el archivo: "+ e.getMessage());
    }
    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void movieSearch(Movie movie) {

    }
}
