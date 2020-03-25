package stats;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private int maxTotalPlateAppearances;
    private int count_maxTotalPlateAppearances;
    private List<Integer> gameIdList_maxTotalPlateAppearances;
    private int maxTotalAtBats;
    private int count_maxTotalAtBats;
    private List<Integer> gameIdList_maxTotalAtBats;
    private int maxTotalRuns;
    private int count_maxTotalRuns;
    private List<Integer> gameIdList_maxTotalRuns;
    private int maxTotalHits;
    private int count_maxTotalHits;
    private List<Integer> gameIdList_maxTotalHits;
    private int maxTotalSingles;
    private int count_maxTotalSingles;
    private List<Integer> gameIdList_maxTotalSingles;
    private int maxTotalDoubles;
    private int count_maxTotalDoubles;
    private List<Integer> gameIdList_maxTotalDoubles;
    private int maxTotalTriples;
    private int count_maxTotalTriples;
    private List<Integer> gameIdList_maxTotalTriples;
    private int maxTotalHomeruns;
    private int count_maxTotalHomeruns;
    private List<Integer> gameIdList_maxTotalHomeruns;
    private int maxTotalWalks;
    private int count_maxTotalWalks;
    private List<Integer> gameIdList_maxTotalWalks;
    private int maxTotalStrikeouts;
    private int count_maxTotalStrikeouts;
    private List<Integer> gameIdList_maxTotalStrikeouts;
    private int maxTotalFieldouts;
    private int count_maxTotalFieldouts;
    private List<Integer> gameIdList_maxTotalFieldouts;

    private int minTotalPlateAppearances;
    private int count_minTotalPlateAppearances;
    private List<Integer> gameIdList_minTotalPlateAppearances;
    private int minTotalAtBats;
    private int count_minTotalAtBats;
    private List<Integer> gameIdList_minTotalAtBats;
    private int minTotalRuns;
    private int count_minTotalRuns;
    private List<Integer> gameIdList_minTotalRuns;
    private int minTotalHits;
    private int count_minTotalHits;
    private List<Integer> gameIdList_minTotalHits;
    private int minTotalSingles;
    private int count_minTotalSingles;
    private List<Integer> gameIdList_minTotalSingles;
    private int minTotalDoubles;
    private int count_minTotalDoubles;
    private List<Integer> gameIdList_minTotalDoubles;
    private int minTotalTriples;
    private int count_minTotalTriples;
    private List<Integer> gameIdList_minTotalTriples;
    private int minTotalHomeruns;
    private int count_minTotalHomeruns;
    private List<Integer> gameIdList_minTotalHomeruns;
    private int minTotalWalks;
    private int count_minTotalWalks;
    private List<Integer> gameIdList_minTotalWalks;
    private int minTotalStrikeouts;
    private int count_minTotalStrikeouts;
    private List<Integer> gameIdList_minTotalStrikeouts;
    private int minTotalFieldouts;
    private int count_minTotalFieldouts;
    private List<Integer> gameIdList_minTotalFieldouts;

    public Records() {
        initializeVariables();
    }

    private void initializeVariables() {
        setMaxTotalPlateAppearances(0);
        setCount_maxTotalPlateAppearances(0);
        setMaxTotalAtBats(0);
        setCount_maxTotalAtBats(0);
        setMaxTotalRuns(0);
        setCount_maxTotalRuns(0);
        setMaxTotalHits(0);
        setCount_maxTotalHits(0);
        setMaxTotalSingles(0);
        setCount_maxTotalSingles(0);
        setMaxTotalDoubles(0);
        setCount_maxTotalDoubles(0);
        setMaxTotalTriples(0);
        setCount_maxTotalTriples(0);
        setMaxTotalHomeruns(0);
        setCount_maxTotalHomeruns(0);
        setMaxTotalWalks(0);
        setCount_maxTotalWalks(0);
        setMaxTotalStrikeouts(0);
        setCount_maxTotalStrikeouts(0);
        setMaxTotalFieldouts(0);
        setCount_maxTotalFieldouts(0);

        gameIdList_maxTotalPlateAppearances = new ArrayList<>();
        gameIdList_maxTotalAtBats = new ArrayList<>();
        gameIdList_maxTotalRuns = new ArrayList<>();
        gameIdList_maxTotalHits = new ArrayList<>();
        gameIdList_maxTotalSingles = new ArrayList<>();
        gameIdList_maxTotalDoubles = new ArrayList<>();
        gameIdList_maxTotalTriples = new ArrayList<>();
        gameIdList_maxTotalHomeruns = new ArrayList<>();
        gameIdList_maxTotalWalks = new ArrayList<>();
        gameIdList_maxTotalStrikeouts = new ArrayList<>();
        gameIdList_maxTotalFieldouts = new ArrayList<>();

        setMinTotalPlateAppearances(Integer.MAX_VALUE);
        setCount_minTotalPlateAppearances(Integer.MAX_VALUE);
        setMinTotalAtBats(Integer.MAX_VALUE);
        setCount_minTotalAtBats(Integer.MAX_VALUE);
        setMinTotalRuns(Integer.MAX_VALUE);
        setCount_minTotalRuns(Integer.MAX_VALUE);
        setMinTotalHits(Integer.MAX_VALUE);
        setCount_minTotalHits(Integer.MAX_VALUE);
        setMinTotalSingles(Integer.MAX_VALUE);
        setCount_minTotalSingles(Integer.MAX_VALUE);
        setMinTotalDoubles(Integer.MAX_VALUE);
        setCount_minTotalDoubles(Integer.MAX_VALUE);
        setMinTotalTriples(Integer.MAX_VALUE);
        setCount_minTotalTriples(Integer.MAX_VALUE);
        setMinTotalHomeruns(Integer.MAX_VALUE);
        setCount_minTotalHomeruns(Integer.MAX_VALUE);
        setMinTotalWalks(Integer.MAX_VALUE);
        setCount_minTotalWalks(Integer.MAX_VALUE);
        setMinTotalStrikeouts(Integer.MAX_VALUE);
        setCount_minTotalStrikeouts(Integer.MAX_VALUE);
        setMinTotalFieldouts(Integer.MAX_VALUE);
        setCount_minTotalFieldouts(Integer.MAX_VALUE);

        gameIdList_minTotalPlateAppearances = new ArrayList<>();
        gameIdList_minTotalAtBats = new ArrayList<>();
        gameIdList_minTotalRuns = new ArrayList<>();
        gameIdList_minTotalHits = new ArrayList<>();
        gameIdList_minTotalSingles = new ArrayList<>();
        gameIdList_minTotalDoubles = new ArrayList<>();
        gameIdList_minTotalTriples = new ArrayList<>();
        gameIdList_minTotalHomeruns = new ArrayList<>();
        gameIdList_minTotalWalks = new ArrayList<>();
        gameIdList_minTotalStrikeouts = new ArrayList<>();
        gameIdList_minTotalFieldouts = new ArrayList<>();
    }
    
    public int getMaxTotalPlateAppearances() {
        return maxTotalPlateAppearances;
    }

    public void setMaxTotalPlateAppearances(int maxTotalPlateAppearances) {
        this.maxTotalPlateAppearances = maxTotalPlateAppearances;
    }

    public int getCount_maxTotalPlateAppearances() {
        return count_maxTotalPlateAppearances;
    }

    public void setCount_maxTotalPlateAppearances(int count_maxTotalPlateAppearances) {
        this.count_maxTotalPlateAppearances = count_maxTotalPlateAppearances;
    }

    public int getMaxTotalAtBats() {
        return maxTotalAtBats;
    }

    public void setMaxTotalAtBats(int maxTotalAtBats) {
        this.maxTotalAtBats = maxTotalAtBats;
    }

    public int getCount_maxTotalAtBats() {
        return count_maxTotalAtBats;
    }

    public void setCount_maxTotalAtBats(int count_maxTotalAtBats) {
        this.count_maxTotalAtBats = count_maxTotalAtBats;
    }

    public int getMaxTotalRuns() {
        return maxTotalRuns;
    }

    public void setMaxTotalRuns(int maxTotalRuns) {
        this.maxTotalRuns = maxTotalRuns;
    }

    public int getCount_maxTotalRuns() {
        return count_maxTotalRuns;
    }

    public void setCount_maxTotalRuns(int count_maxTotalRuns) {
        this.count_maxTotalRuns = count_maxTotalRuns;
    }

    public int getMaxTotalHits() {
        return maxTotalHits;
    }

    public void setMaxTotalHits(int maxTotalHits) {
        this.maxTotalHits = maxTotalHits;
    }

    public int getCount_maxTotalHits() {
        return count_maxTotalHits;
    }

    public void setCount_maxTotalHits(int count_maxTotalHits) {
        this.count_maxTotalHits = count_maxTotalHits;
    }

    public int getMaxTotalSingles() {
        return maxTotalSingles;
    }

    public void setMaxTotalSingles(int maxTotalSingles) {
        this.maxTotalSingles = maxTotalSingles;
    }

    public int getCount_maxTotalSingles() {
        return count_maxTotalSingles;
    }

    public void setCount_maxTotalSingles(int count_maxTotalSingles) {
        this.count_maxTotalSingles = count_maxTotalSingles;
    }

    public int getMaxTotalDoubles() {
        return maxTotalDoubles;
    }

    public void setMaxTotalDoubles(int maxTotalDoubles) {
        this.maxTotalDoubles = maxTotalDoubles;
    }

    public int getCount_maxTotalDoubles() {
        return count_maxTotalDoubles;
    }

    public void setCount_maxTotalDoubles(int count_maxTotalDoubles) {
        this.count_maxTotalDoubles = count_maxTotalDoubles;
    }

    public int getMaxTotalTriples() {
        return maxTotalTriples;
    }

    public void setMaxTotalTriples(int maxTotalTriples) {
        this.maxTotalTriples = maxTotalTriples;
    }

    public int getCount_maxTotalTriples() {
        return count_maxTotalTriples;
    }

    public void setCount_maxTotalTriples(int count_maxTotalTriples) {
        this.count_maxTotalTriples = count_maxTotalTriples;
    }

    public int getMaxTotalHomeruns() {
        return maxTotalHomeruns;
    }

    public void setMaxTotalHomeruns(int maxTotalHomeruns) {
        this.maxTotalHomeruns = maxTotalHomeruns;
    }

    public int getCount_maxTotalHomeruns() {
        return count_maxTotalHomeruns;
    }

    public void setCount_maxTotalHomeruns(int count_maxTotalHomeruns) {
        this.count_maxTotalHomeruns = count_maxTotalHomeruns;
    }

    public int getMaxTotalWalks() {
        return maxTotalWalks;
    }

    public void setMaxTotalWalks(int maxTotalWalks) {
        this.maxTotalWalks = maxTotalWalks;
    }

    public int getCount_maxTotalWalks() {
        return count_maxTotalWalks;
    }

    public void setCount_maxTotalWalks(int count_maxTotalWalks) {
        this.count_maxTotalWalks = count_maxTotalWalks;
    }

    public int getMaxTotalStrikeouts() {
        return maxTotalStrikeouts;
    }

    public void setMaxTotalStrikeouts(int maxTotalStrikeouts) {
        this.maxTotalStrikeouts = maxTotalStrikeouts;
    }

    public int getCount_maxTotalStrikeouts() {
        return count_maxTotalStrikeouts;
    }

    public void setCount_maxTotalStrikeouts(int count_maxTotalStrikeouts) {
        this.count_maxTotalStrikeouts = count_maxTotalStrikeouts;
    }

    public int getMaxTotalFieldouts() {
        return maxTotalFieldouts;
    }

    public void setMaxTotalFieldouts(int maxTotalFieldouts) {
        this.maxTotalFieldouts = maxTotalFieldouts;
    }

    public int getCount_maxTotalFieldouts() {
        return count_maxTotalFieldouts;
    }

    public void setCount_maxTotalFieldouts(int count_maxTotalFieldouts) {
        this.count_maxTotalFieldouts = count_maxTotalFieldouts;
    }


    public void addGame_IdList_maxTotalPlateAppearances(Integer gameId) {
        this.gameIdList_maxTotalPlateAppearances.add(gameId);
    }

    public void clearGame_IdList_maxTotalPlateAppearances() {
        this.gameIdList_maxTotalPlateAppearances.clear();
    }

    public void addGame_IdList_maxTotalAtBats(Integer gameId) {
        this.gameIdList_maxTotalAtBats.add(gameId);
    }

    public void clearGame_IdList_maxTotalAtBats() {
        this.gameIdList_maxTotalAtBats.clear();
    }

    public void addGame_IdList_maxTotalRuns(Integer gameId) {
        this.gameIdList_maxTotalRuns.add(gameId);
    }

    public void clearGame_IdList_maxTotalRuns() {
        this.gameIdList_maxTotalRuns.clear();
    }

    public void addGame_IdList_maxTotalHits(Integer gameId) {
        this.gameIdList_maxTotalHits.add(gameId);
    }

    public void clearGame_IdList_maxTotalHits() {
        this.gameIdList_maxTotalHits.clear();
    }

    public void addGame_IdList_maxTotalSingles(Integer gameId) {
        this.gameIdList_maxTotalSingles.add(gameId);
    }

    public void clearGame_IdList_maxTotalSingles() {
        this.gameIdList_maxTotalSingles.clear();
    }

    public void addGame_IdList_maxTotalDoubles(Integer gameId) {
        this.gameIdList_maxTotalDoubles.add(gameId);
    }

    public void clearGame_IdList_maxTotalDoubles() {
        this.gameIdList_maxTotalDoubles.clear();
    }

    public void addGame_IdList_maxTotalTriples(Integer gameId) {
        this.gameIdList_maxTotalTriples.add(gameId);
    }

    public void clearGame_IdList_maxTotalTriples() {
        this.gameIdList_maxTotalTriples.clear();
    }

    public void addGame_IdList_maxTotalHomeruns(Integer gameId) {
        this.gameIdList_maxTotalHomeruns.add(gameId);
    }

    public void clearGame_IdList_maxTotalHomeruns() {
        this.gameIdList_maxTotalHomeruns.clear();
    }

    public void addGame_IdList_maxTotalWalks(Integer gameId) {
        this.gameIdList_maxTotalWalks.add(gameId);
    }

    public void clearGame_IdList_maxTotalWalks() {
        this.gameIdList_maxTotalWalks.clear();
    }

    public void addGame_IdList_maxTotalStrikeouts(Integer gameId) {
        this.gameIdList_maxTotalStrikeouts.add(gameId);
    }

    public void clearGame_IdList_maxTotalStrikeouts() {
        this.gameIdList_maxTotalStrikeouts.clear();
    }

    public void addGame_IdList_maxTotalFieldouts(Integer gameId) {
        this.gameIdList_maxTotalFieldouts.add(gameId);
    }

    public void clearGame_IdList_maxTotalFieldouts() {
        this.gameIdList_maxTotalFieldouts.clear();
    }

    public List<Integer> getGameIdList_maxTotalPlateAppearances() {
        return gameIdList_maxTotalPlateAppearances;
    }

    public List<Integer> getGameIdList_maxTotalAtBats() {
        return gameIdList_maxTotalAtBats;
    }

    public List<Integer> getGameIdList_maxTotalRuns() {
        return gameIdList_maxTotalRuns;
    }

    public List<Integer> getGameIdList_maxTotalHits() {
        return gameIdList_maxTotalHits;
    }

    public List<Integer> getGameIdList_maxTotalSingles() {
        return gameIdList_maxTotalSingles;
    }

    public List<Integer> getGameIdList_maxTotalDoubles() {
        return gameIdList_maxTotalDoubles;
    }

    public List<Integer> getGameIdList_maxTotalTriples() {
        return gameIdList_maxTotalTriples;
    }

    public List<Integer> getGameIdList_maxTotalHomeruns() {
        return gameIdList_maxTotalHomeruns;
    }

    public List<Integer> getGameIdList_maxTotalWalks() {
        return gameIdList_maxTotalWalks;
    }

    public List<Integer> getGameIdList_maxTotalStrikeouts() {
        return gameIdList_maxTotalStrikeouts;
    }

    public List<Integer> getGameIdList_maxTotalFieldouts() {
        return gameIdList_maxTotalFieldouts;
    }

    public int getMinTotalPlateAppearances() {
        return minTotalPlateAppearances;
    }

    public void setMinTotalPlateAppearances(int minTotalPlateAppearances) {
        this.minTotalPlateAppearances = minTotalPlateAppearances;
    }

    public int getCount_minTotalPlateAppearances() {
        return count_minTotalPlateAppearances;
    }

    public void setCount_minTotalPlateAppearances(int count_minTotalPlateAppearances) {
        this.count_minTotalPlateAppearances = count_minTotalPlateAppearances;
    }

    public int getMinTotalAtBats() {
        return minTotalAtBats;
    }

    public void setMinTotalAtBats(int minTotalAtBats) {
        this.minTotalAtBats = minTotalAtBats;
    }

    public int getCount_minTotalAtBats() {
        return count_minTotalAtBats;
    }

    public void setCount_minTotalAtBats(int count_minTotalAtBats) {
        this.count_minTotalAtBats = count_minTotalAtBats;
    }

    public int getMinTotalRuns() {
        return minTotalRuns;
    }

    public void setMinTotalRuns(int minTotalRuns) {
        this.minTotalRuns = minTotalRuns;
    }

    public int getCount_minTotalRuns() {
        return count_minTotalRuns;
    }

    public void setCount_minTotalRuns(int count_minTotalRuns) {
        this.count_minTotalRuns = count_minTotalRuns;
    }

    public int getMinTotalHits() {
        return minTotalHits;
    }

    public void setMinTotalHits(int minTotalHits) {
        this.minTotalHits = minTotalHits;
    }

    public int getCount_minTotalHits() {
        return count_minTotalHits;
    }

    public void setCount_minTotalHits(int count_minTotalHits) {
        this.count_minTotalHits = count_minTotalHits;
    }

    public int getMinTotalSingles() {
        return minTotalSingles;
    }

    public void setMinTotalSingles(int minTotalSingles) {
        this.minTotalSingles = minTotalSingles;
    }

    public int getCount_minTotalSingles() {
        return count_minTotalSingles;
    }

    public void setCount_minTotalSingles(int count_minTotalSingles) {
        this.count_minTotalSingles = count_minTotalSingles;
    }

    public int getMinTotalDoubles() {
        return minTotalDoubles;
    }

    public void setMinTotalDoubles(int minTotalDoubles) {
        this.minTotalDoubles = minTotalDoubles;
    }

    public int getCount_minTotalDoubles() {
        return count_minTotalDoubles;
    }

    public void setCount_minTotalDoubles(int count_minTotalDoubles) {
        this.count_minTotalDoubles = count_minTotalDoubles;
    }

    public int getMinTotalTriples() {
        return minTotalTriples;
    }

    public void setMinTotalTriples(int minTotalTriples) {
        this.minTotalTriples = minTotalTriples;
    }

    public int getCount_minTotalTriples() {
        return count_minTotalTriples;
    }

    public void setCount_minTotalTriples(int count_minTotalTriples) {
        this.count_minTotalTriples = count_minTotalTriples;
    }

    public int getMinTotalHomeruns() {
        return minTotalHomeruns;
    }

    public void setMinTotalHomeruns(int minTotalHomeruns) {
        this.minTotalHomeruns = minTotalHomeruns;
    }

    public int getCount_minTotalHomeruns() {
        return count_minTotalHomeruns;
    }

    public void setCount_minTotalHomeruns(int count_minTotalHomeruns) {
        this.count_minTotalHomeruns = count_minTotalHomeruns;
    }

    public int getMinTotalWalks() {
        return minTotalWalks;
    }

    public void setMinTotalWalks(int minTotalWalks) {
        this.minTotalWalks = minTotalWalks;
    }

    public int getCount_minTotalWalks() {
        return count_minTotalWalks;
    }

    public void setCount_minTotalWalks(int count_minTotalWalks) {
        this.count_minTotalWalks = count_minTotalWalks;
    }

    public int getMinTotalStrikeouts() {
        return minTotalStrikeouts;
    }

    public void setMinTotalStrikeouts(int minTotalStrikeouts) {
        this.minTotalStrikeouts = minTotalStrikeouts;
    }

    public int getCount_minTotalStrikeouts() {
        return count_minTotalStrikeouts;
    }

    public void setCount_minTotalStrikeouts(int count_minTotalStrikeouts) {
        this.count_minTotalStrikeouts = count_minTotalStrikeouts;
    }

    public int getMinTotalFieldouts() {
        return minTotalFieldouts;
    }

    public void setMinTotalFieldouts(int minTotalFieldouts) {
        this.minTotalFieldouts = minTotalFieldouts;
    }

    public int getCount_minTotalFieldouts() {
        return count_minTotalFieldouts;
    }

    public void setCount_minTotalFieldouts(int count_minTotalFieldouts) {
        this.count_minTotalFieldouts = count_minTotalFieldouts;
    }


    public void addGame_IdList_minTotalPlateAppearances(Integer gameId) {
        this.gameIdList_minTotalPlateAppearances.add(gameId);
    }

    public void clearGame_IdList_minTotalPlateAppearances() {
        this.gameIdList_minTotalPlateAppearances.clear();
    }

    public void addGame_IdList_minTotalAtBats(Integer gameId) {
        this.gameIdList_minTotalAtBats.add(gameId);
    }

    public void clearGame_IdList_minTotalAtBats() {
        this.gameIdList_minTotalAtBats.clear();
    }

    public void addGame_IdList_minTotalRuns(Integer gameId) {
        this.gameIdList_minTotalRuns.add(gameId);
    }

    public void clearGame_IdList_minTotalRuns() {
        this.gameIdList_minTotalRuns.clear();
    }

    public void addGame_IdList_minTotalHits(Integer gameId) {
        this.gameIdList_minTotalHits.add(gameId);
    }

    public void clearGame_IdList_minTotalHits() {
        this.gameIdList_minTotalHits.clear();
    }

    public void addGame_IdList_minTotalSingles(Integer gameId) {
        this.gameIdList_minTotalSingles.add(gameId);
    }

    public void clearGame_IdList_minTotalSingles() {
        this.gameIdList_minTotalSingles.clear();
    }

    public void addGame_IdList_minTotalDoubles(Integer gameId) {
        this.gameIdList_minTotalDoubles.add(gameId);
    }

    public void clearGame_IdList_minTotalDoubles() {
        this.gameIdList_minTotalDoubles.clear();
    }

    public void addGame_IdList_minTotalTriples(Integer gameId) {
        this.gameIdList_minTotalTriples.add(gameId);
    }

    public void clearGame_IdList_minTotalTriples() {
        this.gameIdList_minTotalTriples.clear();
    }

    public void addGame_IdList_minTotalHomeruns(Integer gameId) {
        this.gameIdList_minTotalHomeruns.add(gameId);
    }

    public void clearGame_IdList_minTotalHomeruns() {
        this.gameIdList_minTotalHomeruns.clear();
    }

    public void addGame_IdList_minTotalWalks(Integer gameId) {
        this.gameIdList_minTotalWalks.add(gameId);
    }

    public void clearGame_IdList_minTotalWalks() {
        this.gameIdList_minTotalWalks.clear();
    }

    public void addGame_IdList_minTotalStrikeouts(Integer gameId) {
        this.gameIdList_minTotalStrikeouts.add(gameId);
    }

    public void clearGame_IdList_minTotalStrikeouts() {
        this.gameIdList_minTotalStrikeouts.clear();
    }

    public void addGame_IdList_minTotalFieldouts(Integer gameId) {
        this.gameIdList_minTotalFieldouts.add(gameId);
    }

    public void clearGame_IdList_minTotalFieldouts() {
        this.gameIdList_minTotalFieldouts.clear();
    }

    public List<Integer> getGameIdList_minTotalPlateAppearances() {
        return gameIdList_minTotalPlateAppearances;
    }

    public List<Integer> getGameIdList_minTotalAtBats() {
        return gameIdList_minTotalAtBats;
    }

    public List<Integer> getGameIdList_minTotalRuns() {
        return gameIdList_minTotalRuns;
    }

    public List<Integer> getGameIdList_minTotalHits() {
        return gameIdList_minTotalHits;
    }

    public List<Integer> getGameIdList_minTotalSingles() {
        return gameIdList_minTotalSingles;
    }

    public List<Integer> getGameIdList_minTotalDoubles() {
        return gameIdList_minTotalDoubles;
    }

    public List<Integer> getGameIdList_minTotalTriples() {
        return gameIdList_minTotalTriples;
    }

    public List<Integer> getGameIdList_minTotalHomeruns() {
        return gameIdList_minTotalHomeruns;
    }

    public List<Integer> getGameIdList_minTotalWalks() {
        return gameIdList_minTotalWalks;
    }

    public List<Integer> getGameIdList_minTotalStrikeouts() {
        return gameIdList_minTotalStrikeouts;
    }

    public List<Integer> getGameIdList_minTotalFieldouts() {
        return gameIdList_minTotalFieldouts;
    }
}
