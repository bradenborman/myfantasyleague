package borman.myfantasyleague.models.rosterdata;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Player {

    private String id;
    private String salary;
    private String position;
    private String name;
    private String team;
    private boolean isOnTradingBlock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        if(name.contains(",")){
           String[] x = name.split(",");
           return x[1] + " " + x[0];
        }

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isOnTradingBlock() {
        return isOnTradingBlock;
    }

    public void setOnTradingBlock(boolean onTradingBlock) {
        isOnTradingBlock = onTradingBlock;
    }
}