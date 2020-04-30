package borman.myfantasyleague.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return new ObjectMapper().setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE);
    }

}