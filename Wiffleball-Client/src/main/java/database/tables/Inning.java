package database.tables;

import java.util.Objects;

public class Inning {
    public static final String ID_COLUMN_NAME = "id";
    public static final String GAME_ID_COLUMN_NAME = "game_id";
    public static final String INNING_NUMBER_COLUMN_NAME = "inning_number";
    public static final String TEAM1_ID_COLUMN_NAME = "team1_id";
    public static final String TEAM2_ID_COLUMN_NAME = "team2_id";
    public static final String TEAM1_RUNS_COLUMN_NAME = "team1_runs";
    public static final String TEAM2_RUNS_COLUMN_NAME = "team2_runs";

    private Integer id;
    private Integer game_id;
    private Integer inning_number;
    private Integer team1_id;
    private Integer team2_id;
    private Integer team1_runs;
    private Integer team2_runs;

    public Inning() {
    }

    public Inning(Integer id, Integer game_id, Integer inning_number, Integer team1_id, Integer team2_id, Integer team1_runs, Integer team2_runs) {
        this.id = id;
        this.game_id = game_id;
        this.inning_number = inning_number;
        this.team1_id = team1_id;
        this.team2_id = team2_id;
        this.team1_runs = team1_runs;
        this.team2_runs = team2_runs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Integer getInning_number() {
        return inning_number;
    }

    public void setInning_number(Integer inning_number) {
        this.inning_number = inning_number;
    }

    public Integer getTeam1_id() {
        return team1_id;
    }

    public void setTeam1_id(Integer team1_id) {
        this.team1_id = team1_id;
    }

    public Integer getTeam2_id() {
        return team2_id;
    }

    public void setTeam2_id(Integer team2_id) {
        this.team2_id = team2_id;
    }

    public Integer getTeam1_runs() {
        return team1_runs;
    }

    public void setTeam1_runs(Integer team1_runs) {
        this.team1_runs = team1_runs;
    }

    public Integer getTeam2_runs() {
        return team2_runs;
    }

    public void setTeam2_runs(Integer team2_runs) {
        this.team2_runs = team2_runs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inning inning = (Inning) o;
        return id.equals(inning.id) &&
                game_id.equals(inning.game_id) &&
                inning_number.equals(inning.inning_number) &&
                team1_id.equals(inning.team1_id) &&
                team2_id.equals(inning.team2_id) &&
                team1_runs.equals(inning.team1_runs) &&
                team2_runs.equals(inning.team2_runs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game_id, inning_number, team1_id, team2_id, team1_runs, team2_runs);
    }

    @Override
    public String toString() {
        return "Inning{" +
                "id=" + id +
                ", game_id=" + game_id +
                ", inning_number=" + inning_number +
                ", team1_id=" + team1_id +
                ", team2_id=" + team2_id +
                ", team1_runs=" + team1_runs +
                ", team2_runs=" + team2_runs +
                '}';
    }
}
