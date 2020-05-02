package borman.myfantasyleague.utilities;

import borman.myfantasyleague.models.leaguedata.Franchise;
import borman.myfantasyleague.models.leaguedata.LeagueRequest;
import borman.myfantasyleague.models.playerdata.PlayerDataRequest;
import borman.myfantasyleague.models.rosterdata.Player;

import java.util.Optional;

public class CrossRefPlayerData {

    public static void Process(LeagueRequest leagueRequest, PlayerDataRequest allPlayers) {
        leagueRequest.getLeague().getFranchises().getFranchise().forEach( franchise -> crossRefTeamAndPlayers(franchise, allPlayers));
    }


    public static void crossRefTeamAndPlayers(Franchise franchise, PlayerDataRequest allPlayers) {
        franchise.getPlayer().forEach(player -> {
            Optional<Player> detailedPlayer = allPlayers.getPlayers().getPlayer()
                    .stream()
                    .filter(player1 -> player.getId().equals(player1.getId()))
                    .findFirst();

            detailedPlayer.ifPresent(player1 -> {
                player.setPosition(player1.getPosition());
                player.setName(player1.getName());
                player.setPosition(player1.getPosition());
                player.setTeam(player1.getTeam());
            });

        });
    }

}