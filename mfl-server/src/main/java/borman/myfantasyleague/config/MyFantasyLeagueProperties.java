package borman.myfantasyleague.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mfl")
public class MyFantasyLeagueProperties {

    private String leagueId;
    private String apiKey;
    private MflApiRoutes apiRoutes;

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public MflApiRoutes getApiRoutes() {
        return apiRoutes;
    }

    public void setApiRoutes(MflApiRoutes apiRoutes) {
        this.apiRoutes = apiRoutes;
    }
}