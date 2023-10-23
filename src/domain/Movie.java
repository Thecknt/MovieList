package domain;

import java.util.Objects;

public class Movie {

    private String name;
    private int duration;
    private String gender;
    private String director;
    private String princActors;

    public Movie() {
    }

    public Movie(String name, int duration, String gender, String director, String princActors) {
        this.name = name;
        this.duration = duration;
        this.gender = gender;
        this.director = director;
        this.princActors = princActors;
    }

    public Movie(String line) {
    ???
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPrincActors() {
        return princActors;
    }

    public void setPrincActors(String princActors) {
        this.princActors = princActors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return duration == movie.duration && Objects.equals(name, movie.name) && Objects.equals(gender, movie.gender) && Objects.equals(director, movie.director) && Objects.equals(princActors, movie.princActors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, gender, director, princActors);
    }

    @Override
    public String toString() {
        return "*********************************************" +
                "\n* Datos de la Pelicula: " +
                "\n* Titulo: " + name  +
                "\n* Duracion: " + duration  +
                "\n* Genero: " + gender  +
                "\n* Director: " + director  +
                "\n* Actores Principales: " + princActors  +
                "\n*********************************************";
    }
}
