package borman.myfantasyleague.models.leaguedata;

import java.util.List;

public class FranchiseData {

    private String count;
    private List<Franchise> franchise;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Franchise> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<Franchise> franchise) {
        this.franchise = franchise;
    }

    @Override
    public String toString() {
        return "FranchiseData{" +
                "count='" + count + '\'' +
                ", franchise=" + franchise +
                '}';
    }
}