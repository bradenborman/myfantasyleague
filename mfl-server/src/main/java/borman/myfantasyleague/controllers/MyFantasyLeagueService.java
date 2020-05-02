package borman.myfantasyleague.controllers;

import borman.myfantasyleague.config.MyFantasyLeagueProperties;
import borman.myfantasyleague.models.leaguedata.LeagueRequest;
import borman.myfantasyleague.models.playerdata.PlayerDataRequest;
import borman.myfantasyleague.models.rosterdata.Player;
import borman.myfantasyleague.models.rosterdata.RosterRequest;
import borman.myfantasyleague.models.tradedata.TradeBait;
import borman.myfantasyleague.models.tradedata.TradeBlockRequest;
import borman.myfantasyleague.utilities.CrossRefPlayerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
class MyFantasyLeagueService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyFantasyLeagueProperties myFantasyLeagueProperties;

    LeagueRequest getLeagueData() {
        LeagueRequest leagueRequest = restTemplate.getForEntity(
                myFantasyLeagueProperties.getApiRoutes().getLeagueInfo(),
                LeagueRequest.class
        ).getBody();


        leagueRequest.getLeague().getFranchises().getFranchise().forEach(franchise -> {
            franchise.setPlayer(getPlayerList(franchise.getId()));
        });

        PlayerDataRequest allPlayers = getAllPlayers();


        CrossRefPlayerData.process(leagueRequest, allPlayers);
        CrossRefPlayerData.updateTradingBlock(leagueRequest, getTradeBaitData());

        return leagueRequest;
    }

    private List<Player> getPlayerList(String rosterId) {

         URI url = UriComponentsBuilder
                .fromUriString(myFantasyLeagueProperties.getApiRoutes().getRosterInfo())
                .queryParam("FRANCHISE", rosterId)
                 .build()
                 .toUri();

        RosterRequest rosterRequest = restTemplate.getForEntity(
                url.toString(),
                RosterRequest.class
        ).getBody();

        List<Player> playersOnTeam = rosterRequest.getRosters().getFranchise()
                .getPlayer();

        return playersOnTeam;
    }


    //TODO make cachable
    private PlayerDataRequest getAllPlayers() {
        return restTemplate.getForEntity(
                myFantasyLeagueProperties.getApiRoutes().getPlayerInfo(),
                PlayerDataRequest.class
        ).getBody();
    }


    private List<TradeBait> getTradeBaitData() {
        return restTemplate.getForEntity(
                myFantasyLeagueProperties.getApiRoutes().getTradeBlock(),
                TradeBlockRequest.class
        ).getBody().getTradeBaits().getTradeBait();
    }
}