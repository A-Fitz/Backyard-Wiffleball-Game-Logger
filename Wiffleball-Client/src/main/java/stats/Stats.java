package stats;

public class Stats {
    private int totalPlateAppearances = 0;
    private int totalAtBats = 0;
    private int totalRuns = 0;
    private int totalInningsBatted = 0;
    private int totalHits = 0;
    private int totalSingles = 0;
    private int totalDoubles = 0;
    private int totalTriples = 0;
    private int totalHomeruns = 0;
    private int totalWalks = 0;
    private int totalStrikeouts = 0;
    private int totalFieldouts = 0;
    private int totalGames = 0;
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private int totalShutouts = 0;
    private int totalSavedThirds = 0;
    private int totalBlownThirds = 0;
    private int totalNoHitters = 0;
    private int totalPerfectGames = 0;
    private int totalCycleGames = 0;
    private int totalCycleInnings = 0;

    private float winPercentage, lossPercentage, tiePercentage;
    private float battingAverage, onBasePercentage, slugging;
    private float plateAppearancesPerGame, atBatsPerGame, runsPerGame, hitsPerGame, singlesPerGame, doublesPerGame, triplesPerGame, homerunsPerGame, walksPerGame, strikeoutsPerGame, fieldoutsPerGame;

    public void calculateContinuousStats()
    {
        this.winPercentage = fDiv(getTotalWins(), getTotalGames());
        this.lossPercentage = fDiv(getTotalLosses(), getTotalGames());
        this.tiePercentage = fDiv(getTotalTies(), getTotalGames());

        this.battingAverage = fDiv(getTotalHits(), getTotalAtBats());
        this.onBasePercentage = fDiv((getTotalHits()+getTotalWalks()), getTotalPlateAppearances());
        this.slugging = fDiv((getTotalSingles() + (2*getTotalDoubles()) + (3*getTotalTriples()) + (4*getTotalHomeruns())), getTotalAtBats());

        this.plateAppearancesPerGame = fDiv(getTotalPlateAppearances(), getTotalGames());
        this.atBatsPerGame = fDiv(getTotalAtBats(), getTotalInningsBatted()) * 3;
        this.runsPerGame = fDiv(getTotalRuns(), getTotalInningsBatted()) * 3;
        this.hitsPerGame = fDiv(getTotalHits(), getTotalInningsBatted()) * 3;
        this.singlesPerGame = fDiv(getTotalSingles(), getTotalInningsBatted()) * 3;
        this.doublesPerGame = fDiv(getTotalDoubles(), getTotalInningsBatted()) * 3;
        this.triplesPerGame = fDiv(getTotalTriples(), getTotalInningsBatted()) * 3;
        this.homerunsPerGame = fDiv(getTotalHomeruns(), getTotalInningsBatted()) * 3;
        this.walksPerGame = fDiv(getTotalWalks(), getTotalInningsBatted()) * 3;
        this.strikeoutsPerGame = fDiv(getTotalStrikeouts(), getTotalInningsBatted()) * 3;
        this.fieldoutsPerGame = fDiv(getTotalFieldouts(), getTotalInningsBatted()) * 3;
    }

    private float fDiv(int a, int b)
    {
        return (float) a / (float) b;
    }

    public float getBattingAverage() {
        return battingAverage;
    }

    public float getOnBasePercentage() {
        return onBasePercentage;
    }

    public float getSlugging() {
        return slugging;
    }

    public int getTotalInningsBatted() {
        return totalInningsBatted;
    }

    public void setTotalInningsBatted(int totalInningsBatted) {
        this.totalInningsBatted = totalInningsBatted;
    }

    public float getPlateAppearancesPerGame() {
        return plateAppearancesPerGame;
    }

    public float getAtBatsPerGame() {
        return atBatsPerGame;
    }

    public float getRunsPerGame() {
        return runsPerGame;
    }

    public float getHitsPerGame() {
        return hitsPerGame;
    }

    public float getSinglesPerGame() {
        return singlesPerGame;
    }

    public float getDoublesPerGame() {
        return doublesPerGame;
    }

    public float getTriplesPerGame() {
        return triplesPerGame;
    }

    public float getHomerunsPerGame() {
        return homerunsPerGame;
    }

    public float getWalksPerGame() {
        return walksPerGame;
    }

    public float getStrikeoutsPerGame() {
        return strikeoutsPerGame;
    }

    public float getFieldoutsPerGame() {
        return fieldoutsPerGame;
    }

    public float getWinPercentage() {
        return winPercentage;
    }

    public float getLossPercentage() {
        return lossPercentage;
    }

    public float getTiePercentage() {
        return tiePercentage;
    }

    public int getTotalPlateAppearances() {
        return totalPlateAppearances;
    }

    public void setTotalPlateAppearances(int totalPlateAppearances) {
        this.totalPlateAppearances = totalPlateAppearances;
    }

    public int getTotalAtBats() {
        return totalAtBats;
    }

    public void setTotalAtBats(int totalAtBats) {
        this.totalAtBats = totalAtBats;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotalSingles() {
        return totalSingles;
    }

    public void setTotalSingles(int totalSingles) {
        this.totalSingles = totalSingles;
    }

    public int getTotalDoubles() {
        return totalDoubles;
    }

    public void setTotalDoubles(int totalDoubles) {
        this.totalDoubles = totalDoubles;
    }

    public int getTotalTriples() {
        return totalTriples;
    }

    public void setTotalTriples(int totalTriples) {
        this.totalTriples = totalTriples;
    }

    public int getTotalHomeruns() {
        return totalHomeruns;
    }

    public void setTotalHomeruns(int totalHomeruns) {
        this.totalHomeruns = totalHomeruns;
    }

    public int getTotalWalks() {
        return totalWalks;
    }

    public void setTotalWalks(int totalWalks) {
        this.totalWalks = totalWalks;
    }

    public int getTotalStrikeouts() {
        return totalStrikeouts;
    }

    public void setTotalStrikeouts(int totalStrikeouts) {
        this.totalStrikeouts = totalStrikeouts;
    }

    public int getTotalFieldouts() {
        return totalFieldouts;
    }

    public void setTotalFieldouts(int totalFieldouts) {
        this.totalFieldouts = totalFieldouts;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public int getTotalTies() {
        return totalTies;
    }

    public void setTotalTies(int totalTies) {
        this.totalTies = totalTies;
    }

    public int getTotalShutouts() {
        return totalShutouts;
    }

    public void setTotalShutouts(int totalShutouts) {
        this.totalShutouts = totalShutouts;
    }

    public int getTotalSavedThirds() {
        return totalSavedThirds;
    }

    public void setTotalSavedThirds(int totalSavedThirds) {
        this.totalSavedThirds = totalSavedThirds;
    }

    public int getTotalBlownThirds() {
        return totalBlownThirds;
    }

    public void setTotalBlownThirds(int totalBlownThirds) {
        this.totalBlownThirds = totalBlownThirds;
    }

    public int getTotalNoHitters() {
        return totalNoHitters;
    }

    public void setTotalNoHitters(int totalNoHitters) {
        this.totalNoHitters = totalNoHitters;
    }

    public int getTotalPerfectGames() {
        return totalPerfectGames;
    }

    public void setTotalPerfectGames(int totalPerfectGames) {
        this.totalPerfectGames = totalPerfectGames;
    }

    public int getTotalCycleGames() {
        return totalCycleGames;
    }

    public void setTotalCycleGames(int totalCycleGames) {
        this.totalCycleGames = totalCycleGames;
    }

    public int getTotalCycleInnings() {
        return totalCycleInnings;
    }

    public void setTotalCycleInnings(int totalCycleInnings) {
        this.totalCycleInnings = totalCycleInnings;
    }
}
