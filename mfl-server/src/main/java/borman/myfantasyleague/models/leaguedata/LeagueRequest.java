package borman.myfantasyleague.models.leaguedata;

public class LeagueRequest {

    private String version;
    private League league;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "LeagueData{" +
                "version='" + version + '\'' +
                ", league=" + league +
                '}';
    }
}