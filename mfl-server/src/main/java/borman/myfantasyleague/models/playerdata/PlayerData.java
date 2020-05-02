package borman.myfantasyleague.models.playerdata;

import borman.myfantasyleague.models.rosterdata.Player;

import java.util.List;

public class PlayerData {

    private List<Player> player;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}