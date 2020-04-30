package borman.myfantasyleague.controllers;

import borman.myfantasyleague.models.leaguedata.LeagueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MyFantasyLeagueService myFantasyLeagueService;

    @GetMapping("/league-data")
    public ResponseEntity<LeagueData> getLeagueData() {
        return myFantasyLeagueService.getLeagueData();
    }

    @GetMapping("/league-data-2")
    public ResponseEntity<Object> getLeagueData2() {
        return myFantasyLeagueService.getLeagueData2();
    }

}