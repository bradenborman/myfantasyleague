package borman.myfantasyleague.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ViewController {

    @GetMapping({
            "/",
            "/rosters"
    })
    public String getView() {
        return "index";
    }

}