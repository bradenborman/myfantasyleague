package borman.myfantasyleague.controllers;

import borman.myfantasyleague.models.leaguedata.LeagueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
    Move to service folder once its done being dumb
 */
@Service
class MyFantasyLeagueService {

    @Autowired
    private RestTemplate restTemplate;

    ResponseEntity<LeagueData> getLeagueData() {
        return restTemplate.getForEntity(
                "https://www61.myfantasyleague.com/2020/export?TYPE=league&L=32291&APIKEY=borman-myfantasyleague&JSON=1",
                LeagueData.class
        );
    }

    ResponseEntity<Object> getLeagueData2() {
        return restTemplate.getForEntity(
                "https://www61.myfantasyleague.com/2020/export?TYPE=league&L=32291&APIKEY=borman-myfantasyleague&JSON=1",
                Object.class
        );
    }

}