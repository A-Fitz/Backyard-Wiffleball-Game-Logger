package database.tables;

import java.util.Objects;

public class Plate_Appearance {
    public static final String ID_COLUMN_NAME = "id";
    public static final String INNING_ID_COLUMN_NAME = "inning_id";
    public static final String GAME_ID_COLUMN_NAME = "game_id";
    public static final String SEASON_ID_COLUMN_NAME = "season_id";
    public static final String PITCHER_ID_COLUMN_NAME = "pitcher_id";
    public static final String BATTER_ID_COLUMN_NAME = "batter_id";
    public static final String RESULT_ID_COLUMN_NAME = "result_id";

    private Integer id;
    private Integer inning_id;
    private Integer game_id;
    private Integer season_id;
    private Integer pitcher_id;
    private Integer batter_id;
    private Integer result_id;

    public Plate_Appearance() {

    }

    public Plate_Appearance(Integer id, Integer inning_id, Integer game_id, Integer season_id, Integer pitcher_id, Integer batter_id, Integer result_id) {
        this.id = id;
        this.inning_id = inning_id;
        this.game_id = game_id;
        this.season_id = season_id;
        this.pitcher_id = pitcher_id;
        this.batter_id = batter_id;
        this.result_id = result_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInning_id() {
        return inning_id;
    }

    public void setInning_id(Integer inning_id) {
        this.inning_id = inning_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Integer getSeason_id() {
        return season_id;
    }

    public void setSeason_id(Integer season_id) {
        this.season_id = season_id;
    }

    public Integer getPitcher_id() {
        return pitcher_id;
    }

    public void setPitcher_id(Integer pitcher_id) {
        this.pitcher_id = pitcher_id;
    }

    public Integer getBatter_id() {
        return batter_id;
    }

    public void setBatter_id(Integer batter_id) {
        this.batter_id = batter_id;
    }

    public Integer getResult_id() {
        return result_id;
    }

    public void setResult_id(Integer result_id) {
        this.result_id = result_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate_Appearance plateAppearance = (Plate_Appearance) o;
        return id.equals(plateAppearance.id) &&
                inning_id.equals(plateAppearance.inning_id) &&
                game_id.equals(plateAppearance.game_id) &&
                season_id.equals(plateAppearance.season_id) &&
                pitcher_id.equals(plateAppearance.pitcher_id) &&
                batter_id.equals(plateAppearance.batter_id) &&
                result_id.equals(plateAppearance.result_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inning_id, game_id, season_id, pitcher_id, batter_id, result_id);
    }

    @Override
    public String toString() {
        return "database.tables.at_bat{" +
                "id=" + id +
                "inning_id=" + inning_id +
                ", game_id=" + game_id +
                ", season_id=" + season_id +
                ", pitcher_id=" + pitcher_id +
                ", batter_id=" + batter_id +
                ", result_id=" + result_id +
                '}';
    }
}
