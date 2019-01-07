package study.regur.spring.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.regur.spring.webservice.domain.dto.PostsSaveRequestDto;
import study.regur.spring.webservice.service.PostsService;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private Environment env;

    @GetMapping("/hi")
    public String hi(){
        return "Hi Webservice";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @GetMapping("profile")
    public String getProfile(){
        return Arrays.stream(env.getActiveProfiles()).findFirst().orElse("");
    }
}
