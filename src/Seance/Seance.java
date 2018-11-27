package Seance;

import Film.Film;
import Salle.SalleCinema;

import java.util.Calendar;
import java.util.Objects;

public final class Seance {
    private double prix;
    private Film film;
    private Calendar date;
    private SalleCinema salle;

    public Seance(double prix, Film film, Calendar date, SalleCinema salle)throws NullPointerException {
        Objects.requireNonNull(prix);
        Objects.requireNonNull(film);
        Objects.requireNonNull(date);
        Objects.requireNonNull(salle);
        this.prix = prix;
        this.film = film;
        this.date = date;
        this.salle = salle;
    }

    public double chiffreAffaire(){
        return prix*(salle.getCapacite()-salle.getNbPlacesDisponibles());
    }

    public SalleCinema getSalle(){
        return salle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(date, seance.date) &&
                Objects.equals(salle, seance.salle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, salle);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Seance{");
        sb.append("prix=").append(prix);
        sb.append(", film=").append(film);
        sb.append(", date=").append(date);
        sb.append(", salle=").append(salle);
        sb.append('}');
        return sb.toString();
    }
}
