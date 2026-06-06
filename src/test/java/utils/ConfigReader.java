package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Logger log = LogManager.getLogger(ConfigReader.class);

    private static Properties prop;

    static {
        try {
            log.info("📄 Loading configuration file...");

            prop = new Properties();

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/java/resources/config.properties"
            );

            prop.load(fis);

            log.info("✅ Configuration file loaded successfully");

        } catch (IOException e) {
            log.error("❌ Failed to load config file", e);
            throw new RuntimeException("❌ Failed to load config file", e);
        }
    }

    public static String get(String key) {
        log.debug("🔍 Fetching config value for key: {}", key);
        return prop.getProperty(key);
    }
}