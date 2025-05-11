package badminton_project.config.app;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final WebClientProperties webClientProperties;

    @Value("${spring.profiles.active}")
    private String profile;

    private String getBaseUrl(Map<String, String> profileMap) {
        return profileMap.get(profile);
    }

    @Bean(name = "emqClient")
    public WebClient emqClient() {
        Map<String, String> urls = Map.of(
                "local", webClientProperties.getEmq().get("base-url").getLocal(),
                "dev", webClientProperties.getEmq().get("base-url").getDev(),
                "prod", webClientProperties.getEmq().get("base-url").getProd()
        );
        return WebClient.builder()
                .baseUrl(getBaseUrl(urls))
                .build();
    }

    @Bean(name = "anotherClient")
    public WebClient anotherClient() {
        Map<String, String> urls = Map.of(
                "local", webClientProperties.getAnother().get("base-url").getLocal(),
                "dev", webClientProperties.getAnother().get("base-url").getDev(),
                "prod", webClientProperties.getAnother().get("base-url").getProd()
        );
        return WebClient.builder()
                .baseUrl(getBaseUrl(urls))
                .build();
    }
}
