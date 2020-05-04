package borman.myfantasyleague.controllers;

import borman.myfantasyleague.models.leaguedata.LeagueRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MyFantasyLeagueService myFantasyLeagueService;

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping("/league-data")
    public ResponseEntity<LeagueRequest> getLeagueData() {
        return ResponseEntity.ok(myFantasyLeagueService.getLeagueData());
    }


    @GetMapping("/static-data")
    public ResponseEntity<LeagueRequest> staticData() throws IOException {


        //myFantasyLeagueService.getDraftPicks();

        Resource resource = resourceLoader.getResource("classpath:test-data.json");
        InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(new String(bdata, StandardCharsets.UTF_8), LeagueRequest.class);
        return ResponseEntity.ok(objectMapper.readValue(new String(bdata, StandardCharsets.UTF_8), LeagueRequest.class));
    }

//    @GetMapping("/login")
//    public ResponseEntity<Object> getLogin() {
//        return myFantasyLeagueService.getHeaders();
//    }

}