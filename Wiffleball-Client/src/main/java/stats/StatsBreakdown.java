package stats;

import database.PlateAppearanceResultEnums;
import database.DatabaseConnection;
import database.tables.Plate_Appearance;
import database.tables.Game_Stats;
import database.tables.Inning;
import database.tables.Season_Stats;
import ui.Launcher;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Different object for each team
 */
public class StatsBreakdown {
    private List<Season_Stats> season_statsList;
    private List<Game_Stats> game_statsList;
    private List<Inning> inningList;
    private List<Plate_Appearance> plateAppearanceList;

    private Map<Integer, Stats> seasonStatsMap;
    private Stats statsAllTime;

    private int teamId;

    public StatsBreakdown(int teamId) throws SQLException {
        DatabaseConnection databaseConnection = Launcher.databaseConnection;

        season_statsList = databaseConnection.getSeasonStatsList();
        game_statsList = databaseConnection.getGameStatsList();
        inningList = databaseConnection.getInningList();
        plateAppearanceList = databaseConnection.getPlateAppearanceList();

        seasonStatsMap = new HashMap<>();
        statsAllTime = new Stats();

        this.teamId = teamId;

        calculate();
    }

    public Map<Integer, Stats> getSeasonStatsMap() {
        return seasonStatsMap;
    }

    public Stats getStatsAllTime() {
        return statsAllTime;
    }

    private void calculate()
    {
        calculateStatsPerSeason();
        calculateAllTimeStats();
    }

    private void calculateAllTimeStats()
    {
        for(Stats statsPerSeason : seasonStatsMap.values())
        {
            statsAllTime.setTotalPlateAppearances(statsAllTime.getTotalPlateAppearances() + statsPerSeason.getTotalPlateAppearances());
            statsAllTime.setTotalAtBats(statsAllTime.getTotalAtBats() + statsPerSeason.getTotalAtBats());
            statsAllTime.setTotalRuns(statsAllTime.getTotalRuns() + statsPerSeason.getTotalRuns());
            statsAllTime.setTotalInningsBatted(statsAllTime.getTotalInningsBatted() + statsPerSeason.getTotalInningsBatted());
            statsAllTime.setTotalHits(statsAllTime.getTotalHits() + statsPerSeason.getTotalHits());
            statsAllTime.setTotalSingles(statsAllTime.getTotalSingles() + statsPerSeason.getTotalSingles());
            statsAllTime.setTotalDoubles(statsAllTime.getTotalDoubles() + statsPerSeason.getTotalDoubles());
            statsAllTime.setTotalTriples(statsAllTime.getTotalTriples() + statsPerSeason.getTotalTriples());
            statsAllTime.setTotalHomeruns(statsAllTime.getTotalHomeruns() + statsPerSeason.getTotalHomeruns());
            statsAllTime.setTotalWalks(statsAllTime.getTotalWalks() + statsPerSeason.getTotalWalks());
            statsAllTime.setTotalStrikeouts(statsAllTime.getTotalStrikeouts() + statsPerSeason.getTotalStrikeouts());
            statsAllTime.setTotalFieldouts(statsAllTime.getTotalFieldouts() + statsPerSeason.getTotalFieldouts());
            statsAllTime.setTotalGames(statsAllTime.getTotalGames() + statsPerSeason.getTotalGames());
            statsAllTime.setTotalWins(statsAllTime.getTotalWins() + statsPerSeason.getTotalWins());
            statsAllTime.setTotalLosses(statsAllTime.getTotalLosses() + statsPerSeason.getTotalLosses());
            statsAllTime.setTotalTies(statsAllTime.getTotalTies() + statsPerSeason.getTotalTies());
            statsAllTime.setTotalShutouts(statsAllTime.getTotalShutouts() + statsPerSeason.getTotalShutouts());
            statsAllTime.setTotalSavedThirds(statsAllTime.getTotalSavedThirds() + statsPerSeason.getTotalSavedThirds());
            statsAllTime.setTotalBlownThirds(statsAllTime.getTotalBlownThirds() + statsPerSeason.getTotalBlownThirds());
            statsAllTime.setTotalNoHitters(statsAllTime.getTotalNoHitters() + statsPerSeason.getTotalNoHitters());
            statsAllTime.setTotalPerfectGames(statsAllTime.getTotalPerfectGames() + statsPerSeason.getTotalPerfectGames());
            statsAllTime.setTotalCycleGames(statsAllTime.getTotalCycleGames() + statsPerSeason.getTotalCycleGames());
            statsAllTime.setTotalCycleInnings(statsAllTime.getTotalCycleInnings() + statsPerSeason.getTotalCycleInnings());
        }
        statsAllTime.calculateContinuousStats();
    }

    private void calculateStatsPerSeason()
    {
        for(Season_Stats season_stats : season_statsList) {
            if (season_stats.getTeam_id().equals(teamId)) {
                Stats statsForSeason = new Stats();
                statsForSeason.setTotalPlateAppearances(season_stats.getH_strikeouts() + season_stats.getH_fieldouts() + season_stats.getH_walks() + season_stats.getH_singles() + season_stats.getH_doubles() + season_stats.getH_triples() + season_stats.getH_homeruns());
                statsForSeason.setTotalAtBats(season_stats.getH_strikeouts() + season_stats.getH_fieldouts() + season_stats.getH_singles() + season_stats.getH_doubles() + season_stats.getH_triples() + season_stats.getH_homeruns());
                statsForSeason.setTotalRuns(season_stats.getH_runs());
                statsForSeason.setTotalHits(season_stats.getH_singles() + season_stats.getH_doubles() + season_stats.getH_triples() + season_stats.getH_homeruns());
                statsForSeason.setTotalSingles(season_stats.getH_singles());
                statsForSeason.setTotalDoubles(season_stats.getH_doubles());
                statsForSeason.setTotalTriples(season_stats.getH_triples());
                statsForSeason.setTotalHomeruns(season_stats.getH_homeruns());
                statsForSeason.setTotalWalks(season_stats.getH_walks());
                statsForSeason.setTotalStrikeouts(season_stats.getH_strikeouts());
                statsForSeason.setTotalFieldouts(season_stats.getH_fieldouts());

                statsForSeason.setTotalGames(season_stats.getWins() + season_stats.getLosses() + season_stats.getTies());
                statsForSeason.setTotalWins(season_stats.getWins());
                statsForSeason.setTotalLosses(season_stats.getLosses());
                statsForSeason.setTotalTies(season_stats.getTies());

                statsForSeason.setTotalInningsBatted(0);
                statsForSeason.setTotalShutouts(0);
                statsForSeason.setTotalSavedThirds(0);
                statsForSeason.setTotalBlownThirds(0);
                statsForSeason.setTotalNoHitters(0);
                statsForSeason.setTotalPerfectGames(0);
                statsForSeason.setTotalCycleGames(0);
                statsForSeason.setTotalCycleInnings(0);

                for (Game_Stats game_stats : game_statsList) {
                    if (game_stats.getSeason_id().equals(season_stats.getSeason_id()) && game_stats.getTeam_id().equals(teamId)) {
                        if (game_stats.getP_runs().equals(0))
                            statsForSeason.setTotalShutouts(statsForSeason.getTotalShutouts() + 1);

                        // for totalLastedThirds: if were leading after second inning and won
                        // for totalBlownThirds: if were leading after second inning and lost or tied
                        int teamScoreAfter2 = 0;
                        int otherScoreAfter2 = 0;
                        for (Inning inning : inningList) {
                            if (inning.getGame_id().equals(game_stats.getGame_id()) &&
                                    (inning.getTeam1_id().equals(teamId) || inning.getTeam2_id().equals(teamId))) {
                                if (inning.getTeam1_id().equals(teamId) && inning.getInning_number() < 3) {
                                    teamScoreAfter2 += inning.getTeam1_runs();
                                    otherScoreAfter2 += inning.getTeam2_runs();
                                }
                                if (inning.getTeam2_id().equals(teamId) && inning.getInning_number() < 3) {
                                    teamScoreAfter2 += inning.getTeam2_runs();
                                    otherScoreAfter2 += inning.getTeam1_runs();
                                }
                                if (inning.getInning_number() == 3)
                                    break;
                            }
                        }
                        if (teamScoreAfter2 - otherScoreAfter2 > 0) {
                            if (game_stats.getH_runs() > game_stats.getP_runs())
                                statsForSeason.setTotalSavedThirds(statsForSeason.getTotalSavedThirds() + 1);
                            else if (game_stats.getH_runs() <= game_stats.getP_runs())
                                statsForSeason.setTotalBlownThirds(statsForSeason.getTotalBlownThirds() + 1);
                        }

                        if ((game_stats.getP_singles() + game_stats.getP_doubles() + game_stats.getP_triples() + game_stats.getP_homeruns()) == 0)
                            statsForSeason.setTotalNoHitters(statsForSeason.getTotalNoHitters() + 1);
                        if ((game_stats.getP_walks() + game_stats.getP_singles() + game_stats.getP_doubles() + game_stats.getP_triples() + game_stats.getP_homeruns()) == 0)
                            statsForSeason.setTotalPerfectGames(statsForSeason.getTotalPerfectGames() + 1);
                        if(game_stats.getH_singles() >= 1 && game_stats.getH_doubles() >= 1 && game_stats.getH_triples() >= 1 && game_stats.getH_homeruns() >= 1)
                            statsForSeason.setTotalCycleGames(statsForSeason.getTotalCycleGames() + 1);
                        for(Inning inning : inningList)
                        {
                            int numSingles = 0;
                            int numDoubles = 0;
                            int numTriples = 0;
                            int numHomeruns = 0;
                            boolean inningBattedAccountedFor = false;
                            if((inning.getTeam1_id().equals(teamId) || inning.getTeam2_id().equals(teamId)) && inning.getGame_id().equals(game_stats.getGame_id()))
                            {
                                for(Plate_Appearance plateAppearance : plateAppearanceList)
                                {
                                    if(plateAppearance.getBatter_id().equals(teamId) && plateAppearance.getInning_id().equals(inning.getId()))
                                    {
                                        if(!inningBattedAccountedFor) {
                                            statsForSeason.setTotalInningsBatted(statsForSeason.getTotalInningsBatted() + 1);
                                            inningBattedAccountedFor = true;
                                        }
                                        switch (PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plateAppearance.getResult_id())) {
                                            case PlateAppearanceResultEnums.SINGLE:
                                                numSingles++;
                                                break;
                                            case PlateAppearanceResultEnums.DOUBLE:
                                                numDoubles++;
                                                break;
                                            case PlateAppearanceResultEnums.TRIPLE:
                                                numTriples++;
                                                break;
                                            case PlateAppearanceResultEnums.HOMERUN:
                                                numHomeruns++;
                                                break;
                                        }
                                    }
                                    if(numSingles >= 1 && numDoubles >= 1 && numTriples >= 1 && numHomeruns >= 1) {
                                        statsForSeason.setTotalCycleInnings(statsForSeason.getTotalCycleInnings() + 1);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                statsForSeason.calculateContinuousStats();
                seasonStatsMap.put(season_stats.getId(), statsForSeason);
            }
        }
    }
}
