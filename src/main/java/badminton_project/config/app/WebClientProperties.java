package badminton_project.config.app;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "clients")
public class WebClientProperties {
    private Map<String, ClientBaseUrl> emq;
    private Map<String, ClientBaseUrl> another;

    @Data
    public static class ClientBaseUrl {
        private String local;
        private String dev;
        private String prod;
    }
}