package study.regur.spring.webservice.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.regur.spring.webservice.domain.posts.PostRepository;
import study.regur.spring.webservice.domain.posts.Posts;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @After
    public void cleaup(){
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다  repository 전체를 비우는 코드
         **/
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        postRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("regur@naver.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }
}
