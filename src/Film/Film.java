package Film;

import java.util.Objects;

public final class Film {
    private String titre;

    public Film(String titre)throws NullPointerException{
        Objects.requireNonNull(titre);
        this.titre=titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(titre, film.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("titre='").append(titre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
