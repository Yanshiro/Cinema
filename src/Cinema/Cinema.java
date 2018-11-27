package Cinema;

import Film.Film;
import Salle.SalleCinema;
import Seance.Seance;

import java.util.HashSet;
import java.util.Set;

public final class Cinema {
    private final String nom;
    private Set<SalleCinema> salles;
    private Set<Film> films;
    private Set<Seance> seances;

    public Cinema(String nom) {
        this.nom=nom;
        salles=new HashSet<>();
        films=new HashSet<Film>();
        seances=new HashSet<Seance>();
    }

    public boolean addSeance(Seance seance){
        return this.seances.add(seance);
    }
    public boolean addFilm(Film film){
        return this.films.add(film);
    }
    public boolean addSalle(SalleCinema salle){
        return this.salles.add(salle);
    }

    public void reserver(Seance s){
        if(seances.contains(s)){
            s.getSalle().acheter();
        }
        else{
            throw new IllegalArgumentException("Seance inexistante");
        }
    }

    public void decommander(Seance s){
        if(seances.contains(s)){
            s.getSalle().setNbPlacesDisponibles(1);
        }
        else{
            throw new IllegalArgumentException("Seance inexistante");
        }
    }
    public double chiffreAffaire(){
        double ca=0;
        for(Seance s : seances){
            ca+=s.chiffreAffaire();
        }
        return ca;
    }

    public double tauxRemplissage(){
        int nbplacesprises=0;
        int nbplacestotales=0;
        for(SalleCinema salle : salles){
            nbplacestotales+=salle.getCapacite();
            nbplacesprises+=salle.getCapacite()-salle.getNbPlacesDisponibles();
        }
       return (double)nbplacesprises/(double)nbplacestotales;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cinema{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", salles=").append(salles.toString());
        sb.append(", films=").append(films);
        sb.append(", seances=").append(seances);
        sb.append('}');
        return sb.toString();
    }
}
