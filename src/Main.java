import Cinema.Cinema;
import Film.Film;
import Salle.SalleCinema;
import Seance.Seance;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        try {
            Cinema cinema = new Cinema("UGC");
            Film film = new Film("Avatar");
            Film film2 = new Film("Jurassic Park");
            cinema.addFilm(film);
            SalleCinema salle = new SalleCinema(1, 20);
            SalleCinema salle2 = new SalleCinema(2, 10);
            cinema.addSalle(salle);
            cinema.addSalle(salle2);
            Seance s = new Seance(4, film, new GregorianCalendar(1990, 3, 10,12,38), salle);
            Seance s2 = new Seance(5, film2, new GregorianCalendar(1990, 3, 10,13,20), salle2);
            cinema.addSeance(s);
            cinema.reserver(s);
            System.out.println("taux" + cinema.tauxRemplissage());
            System.out.println(cinema.chiffreAffaire());
            cinema.reserver(s);
            cinema.addSeance(s2);
            cinema.reserver(s2);
            System.out.println("taux" + cinema.tauxRemplissage());
            System.out.println(cinema.chiffreAffaire());
            cinema.decommander(s2);
            System.out.println("taux" + cinema.tauxRemplissage());
            System.out.println(cinema.chiffreAffaire());
        }catch (NullPointerException | IllegalStateException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
