package borman.myfantasyleague.controllers;

import borman.myfantasyleague.config.MyFantasyLeagueProperties;
import borman.myfantasyleague.models.leaguedata.LeagueRequest;
import borman.myfantasyleague.models.playerdata.PlayerDataRequest;
import borman.myfantasyleague.models.rosterdata.Player;
import borman.myfantasyleague.models.rosterdata.RosterRequest;
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


        CrossRefPlayerData.Process(leagueRequest, allPlayers);

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

//        playersOnTeam.forEach(this::populatePlayerDetails);
        return playersOnTeam;
    }


    //TODO make cachable
    private PlayerDataRequest getAllPlayers() {
        return restTemplate.getForEntity(
                myFantasyLeagueProperties.getApiRoutes().getPlayerInfo(),
                PlayerDataRequest.class
        ).getBody();
    }

// restTemplate.getForEntity(url.toString(),Object.class).getBody();

//    ResponseEntity<Object> getHeaders() {
//        HttpHeaders headers = restTemplate.headForHeaders(
//                "https://api.myfantasyleague.com/2020/login?USERNAME=bradenborman@hotmail.com&PASSWORD=Borm0000$&XML=1"
//        );
//
//        List<String> x = headers.get("Set-Cookie");
//
//        String userId = x.get(0);
////                .replace("MFL_USER_ID=", "");
//
//        String password = x.get(1);
////                .replace("MFL_PW_SEQ=", "");
//
//        HttpHeaders headersNew = new HttpHeaders();
//        headersNew.add("Set-Cookie",userId);
//        headersNew.add("Set-Cookie",password);
//
//        return ResponseEntity.status(HttpStatus.OK).headers(headersNew).body("Ehh");
//
//    }
//
//    @Deprecated
//    private void populatePlayerDetails(Player player) {
//        URI url = UriComponentsBuilder
//                .fromUriString(myFantasyLeagueProperties.getApiRoutes().getPlayerInfo())
//                .queryParam("PLAYERS", player.getId())
//                .build()
//                .toUri();
//
//        Player detailedPlayer = restTemplate.getForEntity(
//                url.toString(),
//                PlayerDataRequest.class
//        ).getBody().getPlayers().getPlayer();
//
//        player.setName(detailedPlayer.getName());
//        player.setTeam(detailedPlayer.getTeam());
//        player.setPosition(detailedPlayer.getPosition());
//
//    }

}