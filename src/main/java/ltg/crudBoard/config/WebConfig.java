package ltg.crudBoard.config;

import lombok.RequiredArgsConstructor;
import ltg.crudBoard.auth.LoginUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


//LoginUserArgumentResolver가 스프링에서 인식될 수 있도록 WebMvcConfigurer에 추가하기
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer
{
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    /* HandlerMethodArgumentResolver는 항상 addArgumentResolvers()를 통해 추가해야 함 */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}