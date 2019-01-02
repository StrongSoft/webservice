package study.regur.spring.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/hi")
    public String hi(){
        return "Hi Webservice";
    }
}
