package database.tables;

import java.util.Objects;

public class Game_Stats {
    public static final String ID_COLUMN_NAME = "id";
    public static final String GAME_ID_COLUMN_NAME = "game_id";
    public static final String SEASON_ID_COLUMN_NAME = "season_id";
    public static final String TEAM_ID_COLUMN_NAME = "team_id";
    public static final String H_RUNS_COLUMN_NAME = "h_runs";
    public static final String H_STRIKEOUTS_COLUMN_NAME = "h_strikeouts";
    public static final String H_FIELDOUTS_COLUMN_NAME = "h_fieldouts";
    public static final String H_WALKS_COLUMN_NAME = "h_walks";
    public static final String H_SINGLES_COLUMN_NAME = "h_singles";
    public static final String H_DOUBLES_COLUMN_NAME = "h_doubles";
    public static final String H_TRIPLES_COLUMN_NAME = "h_triples";
    public static final String H_HOMERUNS_COLUMN_NAME = "h_homeruns";
    public static final String P_RUNS_COLUMN_NAME = "p_runs";
    public static final String P_STRIKEOUTS_COLUMN_NAME = "p_strikeouts";
    public static final String P_FIELDOUTS_COLUMN_NAME = "p_fieldouts";
    public static final String P_WALKS_COLUMN_NAME = "p_walks";
    public static final String P_SINGLES_COLUMN_NAME = "p_singles";
    public static final String P_DOUBLES_COLUMN_NAME = "p_doubles";
    public static final String P_TRIPLES_COLUMN_NAME = "p_triples";
    public static final String P_HOMERUNS_COLUMN_NAME = "p_homeruns";

    private Integer id;
    private Integer game_id;
    private Integer season_id;
    private Integer team_id;
    private Integer h_runs;
    private Integer h_strikeouts;
    private Integer h_fieldouts;
    private Integer h_walks;
    private Integer h_singles;
    private Integer h_doubles;
    private Integer h_triples;
    private Integer h_homeruns;
    private Integer p_runs;
    private Integer p_strikeouts;
    private Integer p_fieldouts;
    private Integer p_walks;
    private Integer p_singles;
    private Integer p_doubles;
    private Integer p_triples;
    private Integer p_homeruns;

    public Game_Stats() {
    }

    public Game_Stats(Integer id, Integer game_id, Integer season_id, Integer team_id, Integer h_runs, Integer h_strikeouts, Integer h_fieldouts, Integer h_walks, Integer h_singles, Integer h_doubles, Integer h_triples, Integer h_homeruns, Integer p_runs, Integer p_strikeouts, Integer p_fieldouts, Integer p_walks, Integer p_singles, Integer p_doubles, Integer p_triples, Integer p_homeruns) {
        this.id = id;
        this.game_id = game_id;
        this.season_id = season_id;
        this.team_id = team_id;
        this.h_runs = h_runs;
        this.h_strikeouts = h_strikeouts;
        this.h_fieldouts = h_fieldouts;
        this.h_walks = h_walks;
        this.h_singles = h_singles;
        this.h_doubles = h_doubles;
        this.h_triples = h_triples;
        this.h_homeruns = h_homeruns;
        this.p_runs = p_runs;
        this.p_strikeouts = p_strikeouts;
        this.p_fieldouts = p_fieldouts;
        this.p_walks = p_walks;
        this.p_singles = p_singles;
        this.p_doubles = p_doubles;
        this.p_triples = p_triples;
        this.p_homeruns = p_homeruns;
    }

    public Game_Stats(Integer game_id, Integer season_id, Integer team_id, Integer h_runs, Integer h_strikeouts, Integer h_fieldouts, Integer h_walks, Integer h_singles, Integer h_doubles, Integer h_triples, Integer h_homeruns, Integer p_runs, Integer p_strikeouts, Integer p_fieldouts, Integer p_walks, Integer p_singles, Integer p_doubles, Integer p_triples, Integer p_homeruns) {
        this.game_id = game_id;
        this.season_id = season_id;
        this.team_id = team_id;
        this.h_runs = h_runs;
        this.h_strikeouts = h_strikeouts;
        this.h_fieldouts = h_fieldouts;
        this.h_walks = h_walks;
        this.h_singles = h_singles;
        this.h_doubles = h_doubles;
        this.h_triples = h_triples;
        this.h_homeruns = h_homeruns;
        this.p_runs = p_runs;
        this.p_strikeouts = p_strikeouts;
        this.p_fieldouts = p_fieldouts;
        this.p_walks = p_walks;
        this.p_singles = p_singles;
        this.p_doubles = p_doubles;
        this.p_triples = p_triples;
        this.p_homeruns = p_homeruns;
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

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getH_runs() {
        return h_runs;
    }

    public void setH_runs(Integer h_runs) {
        this.h_runs = h_runs;
    }

    public Integer getH_strikeouts() {
        return h_strikeouts;
    }

    public void setH_strikeouts(Integer h_strikeouts) {
        this.h_strikeouts = h_strikeouts;
    }

    public Integer getH_fieldouts() {
        return h_fieldouts;
    }

    public void setH_fieldouts(Integer h_fieldouts) {
        this.h_fieldouts = h_fieldouts;
    }

    public Integer getH_walks() {
        return h_walks;
    }

    public void setH_walks(Integer h_walks) {
        this.h_walks = h_walks;
    }

    public Integer getH_singles() {
        return h_singles;
    }

    public void setH_singles(Integer h_singles) {
        this.h_singles = h_singles;
    }

    public Integer getH_doubles() {
        return h_doubles;
    }

    public void setH_doubles(Integer h_doubles) {
        this.h_doubles = h_doubles;
    }

    public Integer getH_triples() {
        return h_triples;
    }

    public void setH_triples(Integer h_triples) {
        this.h_triples = h_triples;
    }

    public Integer getH_homeruns() {
        return h_homeruns;
    }

    public void setH_homeruns(Integer h_homeruns) {
        this.h_homeruns = h_homeruns;
    }

    public Integer getP_runs() {
        return p_runs;
    }

    public void setP_runs(Integer p_runs) {
        this.p_runs = p_runs;
    }

    public Integer getP_strikeouts() {
        return p_strikeouts;
    }

    public void setP_strikeouts(Integer p_strikeouts) {
        this.p_strikeouts = p_strikeouts;
    }

    public Integer getP_fieldouts() {
        return p_fieldouts;
    }

    public void setP_fieldouts(Integer p_fieldouts) {
        this.p_fieldouts = p_fieldouts;
    }

    public Integer getP_walks() {
        return p_walks;
    }

    public void setP_walks(Integer p_walks) {
        this.p_walks = p_walks;
    }

    public Integer getP_singles() {
        return p_singles;
    }

    public void setP_singles(Integer p_singles) {
        this.p_singles = p_singles;
    }

    public Integer getP_doubles() {
        return p_doubles;
    }

    public void setP_doubles(Integer p_doubles) {
        this.p_doubles = p_doubles;
    }

    public Integer getP_triples() {
        return p_triples;
    }

    public void setP_triples(Integer p_triples) {
        this.p_triples = p_triples;
    }

    public Integer getP_homeruns() {
        return p_homeruns;
    }

    public void setP_homeruns(Integer p_homeruns) {
        this.p_homeruns = p_homeruns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game_Stats that = (Game_Stats) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(game_id, that.game_id) &&
                Objects.equals(season_id, that.season_id) &&
                Objects.equals(team_id, that.team_id) &&
                Objects.equals(h_runs, that.h_runs) &&
                Objects.equals(h_strikeouts, that.h_strikeouts) &&
                Objects.equals(h_fieldouts, that.h_fieldouts) &&
                Objects.equals(h_walks, that.h_walks) &&
                Objects.equals(h_singles, that.h_singles) &&
                Objects.equals(h_doubles, that.h_doubles) &&
                Objects.equals(h_triples, that.h_triples) &&
                Objects.equals(h_homeruns, that.h_homeruns) &&
                Objects.equals(p_runs, that.p_runs) &&
                Objects.equals(p_strikeouts, that.p_strikeouts) &&
                Objects.equals(p_fieldouts, that.p_fieldouts) &&
                Objects.equals(p_walks, that.p_walks) &&
                Objects.equals(p_singles, that.p_singles) &&
                Objects.equals(p_doubles, that.p_doubles) &&
                Objects.equals(p_triples, that.p_triples) &&
                Objects.equals(p_homeruns, that.p_homeruns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, game_id, season_id, team_id, h_runs, h_strikeouts, h_fieldouts, h_walks, h_singles, h_doubles, h_triples, h_homeruns, p_runs, p_strikeouts, p_fieldouts, p_walks, p_singles, p_doubles, p_triples, p_homeruns);
    }

    @Override
    public String toString() {
        return "Game_Stats{" +
                "id=" + id +
                ", game_id=" + game_id +
                ", season_id=" + season_id +
                ", team_id=" + team_id +
                ", h_runs=" + h_runs +
                ", h_strikeouts=" + h_strikeouts +
                ", h_fieldouts=" + h_fieldouts +
                ", h_walks=" + h_walks +
                ", h_singles=" + h_singles +
                ", h_doubles=" + h_doubles +
                ", h_triples=" + h_triples +
                ", h_homeruns=" + h_homeruns +
                ", p_runs=" + p_runs +
                ", p_strikeouts=" + p_strikeouts +
                ", p_fieldouts=" + p_fieldouts +
                ", p_walks=" + p_walks +
                ", p_singles=" + p_singles +
                ", p_doubles=" + p_doubles +
                ", p_triples=" + p_triples +
                ", p_homeruns=" + p_homeruns +
                '}';
    }
}
