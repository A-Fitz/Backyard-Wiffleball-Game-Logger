package database.tables;

import java.util.Objects;

public class Team {
    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "team_name";

    private Integer id;
    private String team_name;

    public Team() {
    }

    public Team(Integer id, String team_name) {
        this.id = id;
        this.team_name = team_name;
    }

    public Team(String team_name) {
        this.team_name = team_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) &&
                team_name.equals(team.team_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team_name);
    }

    @Override
    public String toString() {
        return "team{" +
                "id=" + id +
                ", name='" + team_name + '\'' +
                '}';
    }
}
