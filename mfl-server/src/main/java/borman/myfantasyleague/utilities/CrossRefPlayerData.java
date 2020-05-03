package borman.myfantasyleague.utilities;

import borman.myfantasyleague.models.leaguedata.Franchise;
import borman.myfantasyleague.models.leaguedata.LeagueRequest;
import borman.myfantasyleague.models.playerdata.PlayerDataRequest;
import borman.myfantasyleague.models.rosterdata.Player;
import borman.myfantasyleague.models.tradedata.TradeBait;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CrossRefPlayerData {

    public static void process(LeagueRequest leagueRequest, PlayerDataRequest allPlayers) {
        leagueRequest.getLeague().getFranchises().getFranchise().forEach(franchise -> crossRefTeamAndPlayers(franchise, allPlayers));
    }

    public static void crossRefTeamAndPlayers(Franchise franchise, PlayerDataRequest allPlayers) {
        franchise.getPlayer().forEach(player -> {
            Optional<Player> detailedPlayer = allPlayers.getPlayers().getPlayer()
                    .stream()
                    .filter(player1 -> player.getId().equals(player1.getId()))
                    .findFirst();

            detailedPlayer.ifPresent(player1 -> {
                player.setPosition(player1.getPosition());
                player.setName(DisplayNameUtility.displayName(player1.getName()));
                player.setPosition(player1.getPosition());
                player.setTeam(player1.getTeam());
            });

        });
    }

    public static void updateTradingBlock(LeagueRequest leagueRequest, List<TradeBait> tradeBaitData) {
        tradeBaitData
                .forEach(tradeBait -> {
                    final Optional<Franchise> franchise = leagueRequest.getLeague().getFranchises().getFranchise().stream()
                            .filter(team -> team.getId().equals(tradeBait.getFranchise_id()))
                            .findFirst();
                    franchise.ifPresent(franchise1 -> {
                        List<String> playersOnBlock = Arrays.asList(tradeBait.getWillGiveUp().split(","));
                        playersOnBlock.forEach(playerOnBlock -> {
                            franchise1.getPlayer().forEach(playerToCheck -> {
                                if (playerToCheck.getId().equals(playerOnBlock))
                                    playerToCheck.setOnTradingBlock(true);
                            });

                        });
                    });
                });
    }


}