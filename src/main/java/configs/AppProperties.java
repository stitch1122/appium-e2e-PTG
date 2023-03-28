package configs;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import static java.nio.file.Files.newInputStream;

public class AppProperties {
    private static final Properties properties = new Properties();
    private static InputStream input;

    private void loadPropertyFile () {
        try {
            input = newInputStream(Paths.get("src/main/java/resources/.properties"));
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getProperty (String propertyKey) {
        loadPropertyFile ();
        return properties.getProperty(propertyKey);
    }
}
