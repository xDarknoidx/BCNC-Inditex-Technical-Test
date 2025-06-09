package bcnc.inditex.infrastructure.client.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import(ApplicationTestConfig.class)
public class ApplicationTestConfig {
}
