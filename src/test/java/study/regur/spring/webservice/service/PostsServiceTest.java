package study.regur.spring.webservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.regur.spring.webservice.domain.posts.Posts;
import study.regur.spring.webservice.domain.posts.PostsRepository;
import study.regur.spring.webservice.domain.dto.PostsSaveRequestDto;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void Dto데이터가_posts테이블에_저장된다 () {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀")
                .content("테스트")
                .author("regur@naver.,com")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }

}
