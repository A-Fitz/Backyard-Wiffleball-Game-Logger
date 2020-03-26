package stats;

import database.DatabaseConnection;
import database.PlateAppearanceResultEnums;
import database.tables.Game_Stats;
import database.tables.Inning;
import database.tables.Plate_Appearance;
import ui.Launcher;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class RecordsBreakdown {
    private List<Game_Stats> game_statsList;
    private List<Inning> inningList;
    private List<Plate_Appearance> plate_appearanceList;

    private Records singleGameRecords;
    private Records singleInningRecords;

    private int teamId;

    public RecordsBreakdown(int teamId) throws SQLException {
        DatabaseConnection databaseConnection = Launcher.databaseConnection;
        game_statsList = databaseConnection.getGameStatsList();
        inningList = databaseConnection.getInningList();
        plate_appearanceList = databaseConnection.getPlateAppearanceList();
        singleGameRecords = new Records();
        singleInningRecords = new Records();
        this.teamId = teamId;
    }

    public Records getSingleGameRecords() {
        return singleGameRecords;
    }

    public Records getSingleInningRecords()
    {
        return singleInningRecords;
    }

    public void calculate()
    {
        calculateSingleGameRecords();
        calculateSingleInningRecords();
    }

    private void calculateSingleInningRecords()
    {
        for(Inning inning : inningList)
        {
            if (inning.getTeam1_id().equals(teamId) || inning.getTeam2_id().equals(teamId))
            {
                int gameId = inning.getGame_id();
                int totalPlateAppearances = 0;
                int totalAtBats = 0;
                int totalRuns = 0;
                int totalHits = 0;
                int totalSingles = 0;
                int totalDoubles = 0;
                int totalTriples = 0;
                int totalHomeruns = 0;
                int totalWalks = 0;
                int totalStrikeouts = 0;
                int totalFieldouts = 0;

                if (inning.getTeam1_id().equals(teamId))
                    totalRuns = inning.getTeam1_runs();
                else if (inning.getTeam2_id().equals(teamId))
                    totalRuns = inning.getTeam2_runs();

                // iterator loop so we can remove plate appearances that will never be used
                for (Iterator<Plate_Appearance> iterator = plate_appearanceList.iterator(); iterator.hasNext(); ) {
                    Plate_Appearance plate_appearance = iterator.next();
                    if(plate_appearance.getInning_id().equals(inning.getId())) {
                        if (plate_appearance.getBatter_id().equals(teamId)) {
                            totalPlateAppearances++;
                            String plateAppearanceResult = PlateAppearanceResultEnums.RESULT_ID_TO_RESULT_TYPE_MAP.get(plate_appearance.getResult_id());

                            if (plateAppearanceResult.equals(PlateAppearanceResultEnums.STRIKEOUT)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.FIELDOUT)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.SINGLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.DOUBLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.TRIPLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.HOMERUN))
                                totalAtBats++;

                            if (plateAppearanceResult.equals(PlateAppearanceResultEnums.SINGLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.DOUBLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.TRIPLE)
                                    || plateAppearanceResult.equals(PlateAppearanceResultEnums.HOMERUN))
                                totalHits++;

                            switch (plateAppearanceResult) {
                                case PlateAppearanceResultEnums.SINGLE:
                                    totalSingles++;
                                    break;
                                case PlateAppearanceResultEnums.DOUBLE:
                                    totalDoubles++;
                                    break;
                                case PlateAppearanceResultEnums.TRIPLE:
                                    totalTriples++;
                                    break;
                                case PlateAppearanceResultEnums.HOMERUN:
                                    totalHomeruns++;
                                    break;
                                case PlateAppearanceResultEnums.WALK:
                                    totalWalks++;
                                    break;
                                case PlateAppearanceResultEnums.STRIKEOUT:
                                    totalStrikeouts++;
                                    break;
                                case PlateAppearanceResultEnums.FIELDOUT:
                                    totalFieldouts++;
                                    break;
                            }
                        } else
                            iterator.remove();
                    }
                }

                if (totalPlateAppearances == singleInningRecords.getMaxTotalPlateAppearances()) {
                    singleInningRecords.setCount_maxTotalPlateAppearances(singleInningRecords.getCount_maxTotalPlateAppearances() + 1);
                    singleInningRecords.addGame_IdList_maxTotalPlateAppearances(gameId);
                } else if (totalPlateAppearances > singleInningRecords.getMaxTotalPlateAppearances()) {
                    singleInningRecords.setMaxTotalPlateAppearances(totalPlateAppearances);
                    singleInningRecords.setCount_maxTotalPlateAppearances(1);
                    singleInningRecords.clearGame_IdList_maxTotalPlateAppearances();
                    singleInningRecords.addGame_IdList_maxTotalPlateAppearances(gameId);
                }
                if (totalPlateAppearances == singleInningRecords.getMinTotalPlateAppearances()) {
                    singleInningRecords.setCount_minTotalPlateAppearances(singleInningRecords.getCount_minTotalPlateAppearances() + 1);
                    singleInningRecords.addGame_IdList_minTotalPlateAppearances(gameId);
                } else if (totalPlateAppearances < singleInningRecords.getMinTotalPlateAppearances()) {
                    singleInningRecords.setMinTotalPlateAppearances(totalPlateAppearances);
                    singleInningRecords.setCount_minTotalPlateAppearances(1);
                    singleInningRecords.clearGame_IdList_minTotalPlateAppearances();
                    singleInningRecords.addGame_IdList_minTotalPlateAppearances(gameId);
                }

                if (totalAtBats == singleInningRecords.getMaxTotalAtBats()) {
                    singleInningRecords.setCount_maxTotalAtBats(singleInningRecords.getCount_maxTotalAtBats() + 1);
                    singleInningRecords.addGame_IdList_maxTotalAtBats(gameId);
                } else if (totalAtBats > singleInningRecords.getMaxTotalAtBats()) {
                    singleInningRecords.setMaxTotalAtBats(totalAtBats);
                    singleInningRecords.setCount_maxTotalAtBats(1);
                    singleInningRecords.clearGame_IdList_maxTotalAtBats();
                    singleInningRecords.addGame_IdList_maxTotalAtBats(gameId);
                }
                if (totalAtBats == singleInningRecords.getMinTotalAtBats()) {
                    singleInningRecords.setCount_minTotalAtBats(singleInningRecords.getCount_minTotalAtBats() + 1);
                    singleInningRecords.addGame_IdList_minTotalAtBats(gameId);
                } else if (totalAtBats < singleInningRecords.getMinTotalAtBats()) {
                    singleInningRecords.setMinTotalAtBats(totalAtBats);
                    singleInningRecords.setCount_minTotalAtBats(1);
                    singleInningRecords.clearGame_IdList_minTotalAtBats();
                    singleInningRecords.addGame_IdList_minTotalAtBats(gameId);
                }

                if (totalRuns == singleInningRecords.getMaxTotalRuns()) {
                    singleInningRecords.setCount_maxTotalRuns(singleInningRecords.getCount_maxTotalRuns() + 1);
                    singleInningRecords.addGame_IdList_maxTotalRuns(gameId);
                } else if (totalRuns > singleInningRecords.getMaxTotalRuns()) {
                    singleInningRecords.setMaxTotalRuns(totalRuns);
                    singleInningRecords.setCount_maxTotalRuns(1);
                    singleInningRecords.clearGame_IdList_maxTotalRuns();
                    singleInningRecords.addGame_IdList_maxTotalRuns(gameId);
                }
                if (totalRuns == singleInningRecords.getMinTotalRuns()) {
                    singleInningRecords.setCount_minTotalRuns(singleInningRecords.getCount_minTotalRuns() + 1);
                    singleInningRecords.addGame_IdList_minTotalRuns(gameId);
                } else if (totalRuns < singleInningRecords.getMinTotalRuns()) {
                    singleInningRecords.setMinTotalRuns(totalRuns);
                    singleInningRecords.setCount_minTotalRuns(1);
                    singleInningRecords.clearGame_IdList_minTotalRuns();
                    singleInningRecords.addGame_IdList_minTotalRuns(gameId);
                }

                if (totalHits == singleInningRecords.getMaxTotalHits()) {
                    singleInningRecords.setCount_maxTotalHits(singleInningRecords.getCount_maxTotalHits() + 1);
                    singleInningRecords.addGame_IdList_maxTotalHits(gameId);
                } else if (totalHits > singleInningRecords.getMaxTotalHits()) {
                    singleInningRecords.setMaxTotalHits(totalHits);
                    singleInningRecords.setCount_maxTotalHits(1);
                    singleInningRecords.clearGame_IdList_maxTotalHits();
                    singleInningRecords.addGame_IdList_maxTotalHits(gameId);
                }
                if (totalHits == singleInningRecords.getMinTotalHits()) {
                    singleInningRecords.setCount_minTotalHits(singleInningRecords.getCount_minTotalHits() + 1);
                    singleInningRecords.addGame_IdList_minTotalHits(gameId);
                } else if (totalHits < singleInningRecords.getMinTotalHits()) {
                    singleInningRecords.setMinTotalHits(totalHits);
                    singleInningRecords.setCount_minTotalHits(1);
                    singleInningRecords.clearGame_IdList_minTotalHits();
                    singleInningRecords.addGame_IdList_minTotalHits(gameId);
                }

                if (totalSingles == singleInningRecords.getMaxTotalSingles()) {
                    singleInningRecords.setCount_maxTotalSingles(singleInningRecords.getCount_maxTotalSingles() + 1);
                    singleInningRecords.addGame_IdList_maxTotalSingles(gameId);
                } else if (totalSingles > singleInningRecords.getMaxTotalSingles()) {
                    singleInningRecords.setMaxTotalSingles(totalSingles);
                    singleInningRecords.setCount_maxTotalSingles(1);
                    singleInningRecords.clearGame_IdList_maxTotalSingles();
                    singleInningRecords.addGame_IdList_maxTotalSingles(gameId);
                }
                if (totalSingles == singleInningRecords.getMinTotalSingles()) {
                    singleInningRecords.setCount_minTotalSingles(singleInningRecords.getCount_minTotalSingles() + 1);
                    singleInningRecords.addGame_IdList_minTotalSingles(gameId);
                } else if (totalSingles < singleInningRecords.getMinTotalSingles()) {
                    singleInningRecords.setMinTotalSingles(totalSingles);
                    singleInningRecords.setCount_minTotalSingles(1);
                    singleInningRecords.clearGame_IdList_minTotalSingles();
                    singleInningRecords.addGame_IdList_minTotalSingles(gameId);
                }


                if (totalDoubles == singleInningRecords.getMaxTotalDoubles()) {
                    singleInningRecords.setCount_maxTotalDoubles(singleInningRecords.getCount_maxTotalDoubles() + 1);
                    singleInningRecords.addGame_IdList_maxTotalDoubles(gameId);
                } else if (totalDoubles > singleInningRecords.getMaxTotalDoubles()) {
                    singleInningRecords.setMaxTotalDoubles(totalDoubles);
                    singleInningRecords.setCount_maxTotalDoubles(1);
                    singleInningRecords.clearGame_IdList_maxTotalDoubles();
                    singleInningRecords.addGame_IdList_maxTotalDoubles(gameId);
                }
                if (totalDoubles == singleInningRecords.getMinTotalDoubles()) {
                    singleInningRecords.setCount_minTotalDoubles(singleInningRecords.getCount_minTotalDoubles() + 1);
                    singleInningRecords.addGame_IdList_minTotalDoubles(gameId);
                } else if (totalDoubles < singleInningRecords.getMinTotalDoubles()) {
                    singleInningRecords.setMinTotalDoubles(totalDoubles);
                    singleInningRecords.setCount_minTotalDoubles(1);
                    singleInningRecords.clearGame_IdList_minTotalDoubles();
                    singleInningRecords.addGame_IdList_minTotalDoubles(gameId);
                }

                if (totalTriples == singleInningRecords.getMaxTotalTriples()) {
                    singleInningRecords.setCount_maxTotalTriples(singleInningRecords.getCount_maxTotalTriples() + 1);
                    singleInningRecords.addGame_IdList_maxTotalTriples(gameId);
                } else if (totalTriples > singleInningRecords.getMaxTotalTriples()) {
                    singleInningRecords.setMaxTotalTriples(totalTriples);
                    singleInningRecords.setCount_maxTotalTriples(1);
                    singleInningRecords.clearGame_IdList_maxTotalTriples();
                    singleInningRecords.addGame_IdList_maxTotalTriples(gameId);
                }
                if (totalTriples == singleInningRecords.getMinTotalTriples()) {
                    singleInningRecords.setCount_minTotalTriples(singleInningRecords.getCount_minTotalTriples() + 1);
                    singleInningRecords.addGame_IdList_minTotalTriples(gameId);
                } else if (totalTriples < singleInningRecords.getMinTotalTriples()) {
                    singleInningRecords.setMinTotalTriples(totalTriples);
                    singleInningRecords.setCount_minTotalTriples(1);
                    singleInningRecords.clearGame_IdList_minTotalTriples();
                    singleInningRecords.addGame_IdList_minTotalTriples(gameId);
                }

                if (totalHomeruns == singleInningRecords.getMaxTotalHomeruns()) {
                    singleInningRecords.setCount_maxTotalHomeruns(singleInningRecords.getCount_maxTotalHomeruns() + 1);
                    singleInningRecords.addGame_IdList_maxTotalHomeruns(gameId);
                } else if (totalHomeruns > singleInningRecords.getMaxTotalHomeruns()) {
                    singleInningRecords.setMaxTotalHomeruns(totalHomeruns);
                    singleInningRecords.setCount_maxTotalHomeruns(1);
                    singleInningRecords.clearGame_IdList_maxTotalHomeruns();
                    singleInningRecords.addGame_IdList_maxTotalHomeruns(gameId);
                }
                if (totalHomeruns == singleInningRecords.getMinTotalHomeruns()) {
                    singleInningRecords.setCount_minTotalHomeruns(singleInningRecords.getCount_minTotalHomeruns() + 1);
                    singleInningRecords.addGame_IdList_minTotalHomeruns(gameId);
                } else if (totalHomeruns < singleInningRecords.getMinTotalHomeruns()) {
                    singleInningRecords.setMinTotalHomeruns(totalHomeruns);
                    singleInningRecords.setCount_minTotalHomeruns(1);
                    singleInningRecords.clearGame_IdList_minTotalHomeruns();
                    singleInningRecords.addGame_IdList_minTotalHomeruns(gameId);
                }

                if (totalWalks == singleInningRecords.getMaxTotalWalks()) {
                    singleInningRecords.setCount_maxTotalWalks(singleInningRecords.getCount_maxTotalWalks() + 1);
                    singleInningRecords.addGame_IdList_maxTotalWalks(gameId);
                } else if (totalWalks > singleInningRecords.getMaxTotalWalks()) {
                    singleInningRecords.setMaxTotalWalks(totalWalks);
                    singleInningRecords.setCount_maxTotalWalks(1);
                    singleInningRecords.clearGame_IdList_maxTotalWalks();
                    singleInningRecords.addGame_IdList_maxTotalWalks(gameId);
                }
                if (totalWalks == singleInningRecords.getMinTotalWalks()) {
                    singleInningRecords.setCount_minTotalWalks(singleInningRecords.getCount_minTotalWalks() + 1);
                    singleInningRecords.addGame_IdList_minTotalWalks(gameId);
                } else if (totalWalks < singleInningRecords.getMinTotalWalks()) {
                    singleInningRecords.setMinTotalWalks(totalWalks);
                    singleInningRecords.setCount_minTotalWalks(1);
                    singleInningRecords.clearGame_IdList_minTotalWalks();
                    singleInningRecords.addGame_IdList_minTotalWalks(gameId);
                }

                if (totalStrikeouts == singleInningRecords.getMaxTotalStrikeouts()) {
                    singleInningRecords.setCount_maxTotalStrikeouts(singleInningRecords.getCount_maxTotalStrikeouts() + 1);
                    singleInningRecords.addGame_IdList_maxTotalStrikeouts(gameId);
                } else if (totalStrikeouts > singleInningRecords.getMaxTotalStrikeouts()) {
                    singleInningRecords.setMaxTotalStrikeouts(totalStrikeouts);
                    singleInningRecords.setCount_maxTotalStrikeouts(1);
                    singleInningRecords.clearGame_IdList_maxTotalStrikeouts();
                    singleInningRecords.addGame_IdList_maxTotalStrikeouts(gameId);
                }
                if (totalStrikeouts == singleInningRecords.getMinTotalStrikeouts()) {
                    singleInningRecords.setCount_minTotalStrikeouts(singleInningRecords.getCount_minTotalStrikeouts() + 1);
                    singleInningRecords.addGame_IdList_minTotalStrikeouts(gameId);
                } else if (totalStrikeouts < singleInningRecords.getMinTotalStrikeouts()) {
                    singleInningRecords.setMinTotalStrikeouts(totalStrikeouts);
                    singleInningRecords.setCount_minTotalStrikeouts(1);
                    singleInningRecords.clearGame_IdList_minTotalStrikeouts();
                    singleInningRecords.addGame_IdList_minTotalStrikeouts(gameId);
                }

                if (totalFieldouts == singleInningRecords.getMaxTotalFieldouts()) {
                    singleInningRecords.setCount_maxTotalFieldouts(singleInningRecords.getCount_maxTotalFieldouts() + 1);
                    singleInningRecords.addGame_IdList_maxTotalFieldouts(gameId);
                } else if (totalFieldouts > singleInningRecords.getMaxTotalFieldouts()) {
                    singleInningRecords.setMaxTotalFieldouts(totalFieldouts);
                    singleInningRecords.setCount_maxTotalFieldouts(1);
                    singleInningRecords.clearGame_IdList_maxTotalFieldouts();
                    singleInningRecords.addGame_IdList_maxTotalFieldouts(gameId);
                }
                if (totalFieldouts == singleInningRecords.getMinTotalFieldouts()) {
                    singleInningRecords.setCount_minTotalFieldouts(singleInningRecords.getCount_minTotalFieldouts() + 1);
                    singleInningRecords.addGame_IdList_minTotalFieldouts(gameId);
                } else if (totalFieldouts < singleInningRecords.getMinTotalFieldouts()) {
                    singleInningRecords.setMinTotalFieldouts(totalFieldouts);
                    singleInningRecords.setCount_minTotalFieldouts(1);
                    singleInningRecords.clearGame_IdList_minTotalFieldouts();
                    singleInningRecords.addGame_IdList_minTotalFieldouts(gameId);
                }
            }
        }
    }

    private void calculateSingleGameRecords()
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
