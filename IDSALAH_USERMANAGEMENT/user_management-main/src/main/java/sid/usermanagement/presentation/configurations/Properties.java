package sid.usermanagement.presentation.configurations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@ConfigurationProperties(prefix = "swagger.ui")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Properties {
    String title = "Users App";
    String description = "User management";
    String version = "1.0";
    String contactName = "Mohamed IDSALAH";
    String contactUrl = "www.google.com";
    String contactEmail = "idsalah.mohammed@gmail.com";
}
