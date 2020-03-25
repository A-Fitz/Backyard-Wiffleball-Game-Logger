package database.tables;

import java.util.Objects;

public class Season {
    public static final String ID_COLUMN_NAME = "id";

    private Integer id;

    public Season(){
    }

    public Season(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return id.equals(season.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "season{" +
                "id=" + id +
                '}';
    }
}
