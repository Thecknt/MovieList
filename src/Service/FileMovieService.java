package Service;

import domain.Movie;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

//Creo una clase para manejar el guardado de archivos
public class FileMovieService implements IMovieService{

    Scanner input = new Scanner(System.in).useDelimiter("\n");
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    //FileWriter fileTxt;
    PrintWriter txt;
    File file;

    public FileMovieService(){
        file = new File(NOMBRE_ARCHIVO);
        try {
            //Si ya existe el archivo, NO  se crea
            if (file.exists()){
                System.out.println("El archivo ya existe!");
            } else {
                //Si no existe se crea el archivo vacio.
                txt = new PrintWriter(new FileWriter(file));
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
            var read = new BufferedReader(new FileReader(file));

            //Leo linea a linea el archivo
            String line;
            line = read.readLine();
            //Leo todas las lineas del archivo
            while (line != null){
                System.out.println(line);
                //Antes de terminar el ciclo vuelvo a leer el archivo
                line = read.readLine();
            }
            System.out.println();

            //Cierro el archivo
            read.close();
        }catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void addMovie(Movie movie) {
        boolean writeData = false;
        file = new File(NOMBRE_ARCHIVO);
        try {
            //compruebo si existe el archivo
            writeData = file.exists();
            //Si existe lo comienzo a escribir
            var finalFile = new PrintWriter(new FileWriter(file, writeData));
            //Agrego la Pelicula (toString)
            finalFile.println(movie);
            finalFile.close();
            System.out.println();
            System.out.println("Se agrego la Pelicula " + movie.getName() +" al Archivo peliculas.txt");
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar la pelicula " + e.getMessage());
        }
    }

    @Override
    public void movieSearch(Movie movie) {
file = new File(NOMBRE_ARCHIVO);
try {
    //abrimos el archivo para lectura linea a linea.
   var readData = new BufferedReader(new FileReader(file));
    System.out.println("Ingrese el nombre de la Pelicula a buscar");
    var movieToFound = input.next();
   String txtFile;
   txtFile = readData.readLine();
   int index = 1;
   boolean found = false;

   while (txtFile != null){
       //Buscamos si hay coincidencia en el archivo.
       if(txtFile.equals("* Titulo: "+movieToFound)){
           found = true;
           break;
       }
       txtFile = readData.readLine();
       index++;
   }
   //Imprimo el resultado:
    if (found){
        System.out.println("La Pelicula " + movieToFound + " fue encontrada en la linea: " + index);
    } else {
        System.out.println("La Pelicula no fue encontrada en el archivo. ");
    }
    readData.close();
}catch(Exception e){
    System.out.println("Ocurrio un error al buscar en el archivo. " + e.getMessage());
}
    }

}
