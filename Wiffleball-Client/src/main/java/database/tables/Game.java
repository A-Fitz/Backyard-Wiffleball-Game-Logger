package database.tables;

import java.sql.Date;
import java.util.Objects;

public class Game {
    public static final String ID_COLUMN_NAME = "id";
    public static final String SEASON_ID_COLUMN_NAME = "season_id";
    public static final String DATE_OF_GAME_COLUMN_NAME = "date_of_game";

    private Integer id;
    private Integer season_id;
    private Date date_of_game;

    public Game()
    {

    }

    public Game(Integer id, Integer season_id, Date date_of_game) {
        this.id = id;
        this.season_id = season_id;
        this.date_of_game = date_of_game;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeason_id() {
        return season_id;
    }

    public void setSeason_id(Integer season_id) {
        this.season_id = season_id;
    }

    public Date getDate_of_game() {
        return date_of_game;
    }

    public void setDate_of_game(Date date_of_game) {
        this.date_of_game = date_of_game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id.equals(game.id) &&
                season_id.equals(game.season_id) &&
                date_of_game.equals(game.date_of_game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, season_id, date_of_game);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", season_id=" + season_id +
                ", date_of_game=" + date_of_game +
                '}';
    }
}
