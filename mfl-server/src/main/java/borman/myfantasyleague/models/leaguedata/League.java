package borman.myfantasyleague.models.leaguedata;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class League {

    private FranchiseData franchises;
    private String name;
    private String baseURL;

    public FranchiseData getFranchises() {
        return franchises;
    }

    public void setFranchises(FranchiseData franchises) {
        this.franchises = franchises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Override
    public String toString() {
        return "League{" +
                "franchises=" + franchises +
                ", name='" + name + '\'' +
                ", baseURL='" + baseURL + '\'' +
                '}';
    }
}