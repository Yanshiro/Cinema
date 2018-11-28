package Salle;

import Film.Film;

import java.util.Objects;

public class SalleCinema {
    private final int numero;
    private Film film;
    private final int capacite;
    private int nbPlacesDisponibles;


    public SalleCinema(int numero, int capacite) throws NullPointerException {
        Objects.requireNonNull(capacite);
        Objects.requireNonNull(numero);
        this.numero=numero;
        this.capacite = capacite;
        nbPlacesDisponibles=capacite;
    }

    public void acheter() throws IllegalStateException{
        if(!estPleine()) {
            this.nbPlacesDisponibles--;
        }
        else{
            throw new IllegalStateException("Salle pleine");
        }

    }
    public int getCapacite(){
        return capacite;
    }

    public int getNbPlacesDisponibles(){
        return nbPlacesDisponibles;
    }

    public void setNbPlacesDisponibles(int a){
        nbPlacesDisponibles+=a;
    }
    public boolean estPleine(){
        if(nbPlacesDisponibles==0){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SalleCinema\n");
        sb.append("numero ").append(this.numero);
        sb.append("nombres de places :").append(this.capacite).append('\n');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalleCinema that = (SalleCinema) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    public static void main(String[] args) {
        SalleCinema s = new SalleCinema(1,40);
        System.out.println(s.toString());
    }
}
