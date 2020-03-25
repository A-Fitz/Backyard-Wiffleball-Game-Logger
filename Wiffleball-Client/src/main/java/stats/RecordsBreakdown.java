package stats;

import database.DatabaseConnection;
import database.tables.Game_Stats;
import ui.Main;

import java.sql.SQLException;
import java.util.List;

public class RecordsBreakdown {
    private List<Game_Stats> game_statsList;

    private Records singleGameRecords;

    private int teamId;

    public RecordsBreakdown(int teamId) throws SQLException {
        DatabaseConnection databaseConnection = Main.databaseConnection;

        game_statsList = databaseConnection.getGameStatsList();

        singleGameRecords = new Records();

        this.teamId = teamId;
    }

    public Records getSingleGameRecords() {
        return singleGameRecords;
    }

    public void calculate()
    {
        for(Game_Stats game_stats : game_statsList) {
            if (game_stats.getTeam_id().equals(teamId)) {
                int gameId = game_stats.getGame_id();

                int totalPlateAppearances = game_stats.getH_strikeouts() + game_stats.getH_fieldouts() + game_stats.getH_walks() + game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                if (totalPlateAppearances == singleGameRecords.getMaxTotalPlateAppearances()) {
                    singleGameRecords.setCount_maxTotalPlateAppearances(singleGameRecords.getCount_maxTotalPlateAppearances() + 1);
                    singleGameRecords.addGame_IdList_maxTotalPlateAppearances(gameId);
                } else if (totalPlateAppearances > singleGameRecords.getMaxTotalPlateAppearances()) {
                    singleGameRecords.setMaxTotalPlateAppearances(totalPlateAppearances);
                    singleGameRecords.setCount_maxTotalPlateAppearances(1);
                    singleGameRecords.clearGame_IdList_maxTotalPlateAppearances();
                    singleGameRecords.addGame_IdList_maxTotalPlateAppearances(gameId);
                }
                if (totalPlateAppearances == singleGameRecords.getMinTotalPlateAppearances()) {
                    singleGameRecords.setCount_minTotalPlateAppearances(singleGameRecords.getCount_minTotalPlateAppearances() + 1);
                    singleGameRecords.addGame_IdList_minTotalPlateAppearances(gameId);
                } else if (totalPlateAppearances < singleGameRecords.getMinTotalPlateAppearances()) {
                    singleGameRecords.setMinTotalPlateAppearances(totalPlateAppearances);
                    singleGameRecords.setCount_minTotalPlateAppearances(1);
                    singleGameRecords.clearGame_IdList_minTotalPlateAppearances();
                    singleGameRecords.addGame_IdList_minTotalPlateAppearances(gameId);
                }

                int totalAtBats = game_stats.getH_strikeouts() + game_stats.getH_fieldouts() + game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                if (totalAtBats == singleGameRecords.getMaxTotalAtBats()) {
                    singleGameRecords.setCount_maxTotalAtBats(singleGameRecords.getCount_maxTotalAtBats() + 1);
                    singleGameRecords.addGame_IdList_maxTotalAtBats(gameId);
                } else if (totalAtBats > singleGameRecords.getMaxTotalAtBats()) {
                    singleGameRecords.setMaxTotalAtBats(totalAtBats);
                    singleGameRecords.setCount_maxTotalAtBats(1);
                    singleGameRecords.clearGame_IdList_maxTotalAtBats();
                    singleGameRecords.addGame_IdList_maxTotalAtBats(gameId);
                }
                if (totalAtBats == singleGameRecords.getMinTotalAtBats()) {
                    singleGameRecords.setCount_minTotalAtBats(singleGameRecords.getCount_minTotalAtBats() + 1);
                    singleGameRecords.addGame_IdList_minTotalAtBats(gameId);
                } else if (totalAtBats < singleGameRecords.getMinTotalAtBats()) {
                    singleGameRecords.setMinTotalAtBats(totalAtBats);
                    singleGameRecords.setCount_minTotalAtBats(1);
                    singleGameRecords.clearGame_IdList_minTotalAtBats();
                    singleGameRecords.addGame_IdList_minTotalAtBats(gameId);
                }

                int totalRuns = game_stats.getH_runs();
                if (totalRuns == singleGameRecords.getMaxTotalRuns()) {
                    singleGameRecords.setCount_maxTotalRuns(singleGameRecords.getCount_maxTotalRuns() + 1);
                    singleGameRecords.addGame_IdList_maxTotalRuns(gameId);
                } else if (totalRuns > singleGameRecords.getMaxTotalRuns()) {
                    singleGameRecords.setMaxTotalRuns(totalRuns);
                    singleGameRecords.setCount_maxTotalRuns(1);
                    singleGameRecords.clearGame_IdList_maxTotalRuns();
                    singleGameRecords.addGame_IdList_maxTotalRuns(gameId);
                }
                if (totalRuns == singleGameRecords.getMinTotalRuns()) {
                    singleGameRecords.setCount_minTotalRuns(singleGameRecords.getCount_minTotalRuns() + 1);
                    singleGameRecords.addGame_IdList_minTotalRuns(gameId);
                } else if (totalRuns < singleGameRecords.getMinTotalRuns()) {
                    singleGameRecords.setMinTotalRuns(totalRuns);
                    singleGameRecords.setCount_minTotalRuns(1);
                    singleGameRecords.clearGame_IdList_minTotalRuns();
                    singleGameRecords.addGame_IdList_minTotalRuns(gameId);
                }

                int totalHits = game_stats.getH_singles() + game_stats.getH_doubles() + game_stats.getH_triples() + game_stats.getH_homeruns();
                if (totalHits == singleGameRecords.getMaxTotalHits()) {
                    singleGameRecords.setCount_maxTotalHits(singleGameRecords.getCount_maxTotalHits() + 1);
                    singleGameRecords.addGame_IdList_maxTotalHits(gameId);
                } else if (totalHits > singleGameRecords.getMaxTotalHits()) {
                    singleGameRecords.setMaxTotalHits(totalHits);
                    singleGameRecords.setCount_maxTotalHits(1);
                    singleGameRecords.clearGame_IdList_maxTotalHits();
                    singleGameRecords.addGame_IdList_maxTotalHits(gameId);
                }
                if (totalHits == singleGameRecords.getMinTotalHits()) {
                    singleGameRecords.setCount_minTotalHits(singleGameRecords.getCount_minTotalHits() + 1);
                    singleGameRecords.addGame_IdList_minTotalHits(gameId);
                } else if (totalHits < singleGameRecords.getMinTotalHits()) {
                    singleGameRecords.setMinTotalHits(totalHits);
                    singleGameRecords.setCount_minTotalHits(1);
                    singleGameRecords.clearGame_IdList_minTotalHits();
                    singleGameRecords.addGame_IdList_minTotalHits(gameId);
                }

                int totalSingles = game_stats.getH_singles();
                if (totalSingles == singleGameRecords.getMaxTotalSingles()) {
                    singleGameRecords.setCount_maxTotalSingles(singleGameRecords.getCount_maxTotalSingles() + 1);
                    singleGameRecords.addGame_IdList_maxTotalSingles(gameId);
                } else if (totalSingles > singleGameRecords.getMaxTotalSingles()) {
                    singleGameRecords.setMaxTotalSingles(totalSingles);
                    singleGameRecords.setCount_maxTotalSingles(1);
                    singleGameRecords.clearGame_IdList_maxTotalSingles();
                    singleGameRecords.addGame_IdList_maxTotalSingles(gameId);
                }
                if (totalSingles == singleGameRecords.getMinTotalSingles()) {
                    singleGameRecords.setCount_minTotalSingles(singleGameRecords.getCount_minTotalSingles() + 1);
                    singleGameRecords.addGame_IdList_minTotalSingles(gameId);
                } else if (totalSingles < singleGameRecords.getMinTotalSingles()) {
                    singleGameRecords.setMinTotalSingles(totalSingles);
                    singleGameRecords.setCount_minTotalSingles(1);
                    singleGameRecords.clearGame_IdList_minTotalSingles();
                    singleGameRecords.addGame_IdList_minTotalSingles(gameId);
                }


                int totalDoubles = game_stats.getH_doubles();
                if (totalDoubles == singleGameRecords.getMaxTotalDoubles()) {
                    singleGameRecords.setCount_maxTotalDoubles(singleGameRecords.getCount_maxTotalDoubles() + 1);
                    singleGameRecords.addGame_IdList_maxTotalDoubles(gameId);
                } else if (totalDoubles > singleGameRecords.getMaxTotalDoubles()) {
                    singleGameRecords.setMaxTotalDoubles(totalDoubles);
                    singleGameRecords.setCount_maxTotalDoubles(1);
                    singleGameRecords.clearGame_IdList_maxTotalDoubles();
                    singleGameRecords.addGame_IdList_maxTotalDoubles(gameId);
                }
                if (totalDoubles == singleGameRecords.getMinTotalDoubles()) {
                    singleGameRecords.setCount_minTotalDoubles(singleGameRecords.getCount_minTotalDoubles() + 1);
                    singleGameRecords.addGame_IdList_minTotalDoubles(gameId);
                } else if (totalDoubles < singleGameRecords.getMinTotalDoubles()) {
                    singleGameRecords.setMinTotalDoubles(totalDoubles);
                    singleGameRecords.setCount_minTotalDoubles(1);
                    singleGameRecords.clearGame_IdList_minTotalDoubles();
                    singleGameRecords.addGame_IdList_minTotalDoubles(gameId);
                }

                int totalTriples = game_stats.getH_triples();
                if (totalTriples == singleGameRecords.getMaxTotalTriples()) {
                    singleGameRecords.setCount_maxTotalTriples(singleGameRecords.getCount_maxTotalTriples() + 1);
                    singleGameRecords.addGame_IdList_maxTotalTriples(gameId);
                } else if (totalTriples > singleGameRecords.getMaxTotalTriples()) {
                    singleGameRecords.setMaxTotalTriples(totalTriples);
                    singleGameRecords.setCount_maxTotalTriples(1);
                    singleGameRecords.clearGame_IdList_maxTotalTriples();
                    singleGameRecords.addGame_IdList_maxTotalTriples(gameId);
                }
                if (totalTriples == singleGameRecords.getMinTotalTriples()) {
                    singleGameRecords.setCount_minTotalTriples(singleGameRecords.getCount_minTotalTriples() + 1);
                    singleGameRecords.addGame_IdList_minTotalTriples(gameId);
                } else if (totalTriples < singleGameRecords.getMinTotalTriples()) {
                    singleGameRecords.setMinTotalTriples(totalTriples);
                    singleGameRecords.setCount_minTotalTriples(1);
                    singleGameRecords.clearGame_IdList_minTotalTriples();
                    singleGameRecords.addGame_IdList_minTotalTriples(gameId);
                }

                int totalHomeruns = game_stats.getH_homeruns();
                if (totalHomeruns == singleGameRecords.getMaxTotalHomeruns()) {
                    singleGameRecords.setCount_maxTotalHomeruns(singleGameRecords.getCount_maxTotalHomeruns() + 1);
                    singleGameRecords.addGame_IdList_maxTotalHomeruns(gameId);
                } else if (totalHomeruns > singleGameRecords.getMaxTotalHomeruns()) {
                    singleGameRecords.setMaxTotalHomeruns(totalHomeruns);
                    singleGameRecords.setCount_maxTotalHomeruns(1);
                    singleGameRecords.clearGame_IdList_maxTotalHomeruns();
                    singleGameRecords.addGame_IdList_maxTotalHomeruns(gameId);
                }
                if (totalHomeruns == singleGameRecords.getMinTotalHomeruns()) {
                    singleGameRecords.setCount_minTotalHomeruns(singleGameRecords.getCount_minTotalHomeruns() + 1);
                    singleGameRecords.addGame_IdList_minTotalHomeruns(gameId);
                } else if (totalHomeruns < singleGameRecords.getMinTotalHomeruns()) {
                    singleGameRecords.setMinTotalHomeruns(totalHomeruns);
                    singleGameRecords.setCount_minTotalHomeruns(1);
                    singleGameRecords.clearGame_IdList_minTotalHomeruns();
                    singleGameRecords.addGame_IdList_minTotalHomeruns(gameId);
                }

                int totalWalks = game_stats.getH_walks();
                if (totalWalks == singleGameRecords.getMaxTotalWalks()) {
                    singleGameRecords.setCount_maxTotalWalks(singleGameRecords.getCount_maxTotalWalks() + 1);
                    singleGameRecords.addGame_IdList_maxTotalWalks(gameId);
                } else if (totalWalks > singleGameRecords.getMaxTotalWalks()) {
                    singleGameRecords.setMaxTotalWalks(totalWalks);
                    singleGameRecords.setCount_maxTotalWalks(1);
                    singleGameRecords.clearGame_IdList_maxTotalWalks();
                    singleGameRecords.addGame_IdList_maxTotalWalks(gameId);
                }
                if (totalWalks == singleGameRecords.getMinTotalWalks()) {
                    singleGameRecords.setCount_minTotalWalks(singleGameRecords.getCount_minTotalWalks() + 1);
                    singleGameRecords.addGame_IdList_minTotalWalks(gameId);
                } else if (totalWalks < singleGameRecords.getMinTotalWalks()) {
                    singleGameRecords.setMinTotalWalks(totalWalks);
                    singleGameRecords.setCount_minTotalWalks(1);
                    singleGameRecords.clearGame_IdList_minTotalWalks();
                    singleGameRecords.addGame_IdList_minTotalWalks(gameId);
                }

                int totalStrikeouts = game_stats.getH_strikeouts();
                if (totalStrikeouts == singleGameRecords.getMaxTotalStrikeouts()) {
                    singleGameRecords.setCount_maxTotalStrikeouts(singleGameRecords.getCount_maxTotalStrikeouts() + 1);
                    singleGameRecords.addGame_IdList_maxTotalStrikeouts(gameId);
                } else if (totalStrikeouts > singleGameRecords.getMaxTotalStrikeouts()) {
                    singleGameRecords.setMaxTotalStrikeouts(totalStrikeouts);
                    singleGameRecords.setCount_maxTotalStrikeouts(1);
                    singleGameRecords.clearGame_IdList_maxTotalStrikeouts();
                    singleGameRecords.addGame_IdList_maxTotalStrikeouts(gameId);
                }
                if (totalStrikeouts == singleGameRecords.getMinTotalStrikeouts()) {
                    singleGameRecords.setCount_minTotalStrikeouts(singleGameRecords.getCount_minTotalStrikeouts() + 1);
                    singleGameRecords.addGame_IdList_minTotalStrikeouts(gameId);
                } else if (totalStrikeouts < singleGameRecords.getMinTotalStrikeouts()) {
                    singleGameRecords.setMinTotalStrikeouts(totalStrikeouts);
                    singleGameRecords.setCount_minTotalStrikeouts(1);
                    singleGameRecords.clearGame_IdList_minTotalStrikeouts();
                    singleGameRecords.addGame_IdList_minTotalStrikeouts(gameId);
                }

                int totalFieldouts = game_stats.getH_fieldouts();
                if (totalFieldouts == singleGameRecords.getMaxTotalFieldouts()) {
                    singleGameRecords.setCount_maxTotalFieldouts(singleGameRecords.getCount_maxTotalFieldouts() + 1);
                    singleGameRecords.addGame_IdList_maxTotalFieldouts(gameId);
                } else if (totalFieldouts > singleGameRecords.getMaxTotalFieldouts()) {
                    singleGameRecords.setMaxTotalFieldouts(totalFieldouts);
                    singleGameRecords.setCount_maxTotalFieldouts(1);
                    singleGameRecords.clearGame_IdList_maxTotalFieldouts();
                    singleGameRecords.addGame_IdList_maxTotalFieldouts(gameId);
                }
                if (totalFieldouts == singleGameRecords.getMinTotalFieldouts()) {
                    singleGameRecords.setCount_minTotalFieldouts(singleGameRecords.getCount_minTotalFieldouts() + 1);
                    singleGameRecords.addGame_IdList_minTotalFieldouts(gameId);
                } else if (totalFieldouts < singleGameRecords.getMinTotalFieldouts()) {
                    singleGameRecords.setMinTotalFieldouts(totalFieldouts);
                    singleGameRecords.setCount_minTotalFieldouts(1);
                    singleGameRecords.clearGame_IdList_minTotalFieldouts();
                    singleGameRecords.addGame_IdList_minTotalFieldouts(gameId);
                }
            }
        }
    }
}
