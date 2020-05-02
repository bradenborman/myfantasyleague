package borman.myfantasyleague.controllers;

import borman.myfantasyleague.models.leaguedata.LeagueRequest;
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
    public ResponseEntity<LeagueRequest> getLeagueData() {
        return ResponseEntity.ok(myFantasyLeagueService.getLeagueData());
    }


//    @GetMapping("/login")
//    public ResponseEntity<Object> getLogin() {
//        return myFantasyLeagueService.getHeaders();
//    }

}