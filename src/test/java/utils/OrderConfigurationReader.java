package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class OrderConfigurationReader {

    private static final Logger log = LogManager.getLogger(OrderConfigurationReader.class);

    public static JsonNode getOrderData(String data) {
        try {
            log.info("📄 Reading menu configuration JSON...");

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(
                    new File("src/test/java/resources/orderConfiguration.json")
            );

            log.info("✅ Menu configuration loaded successfully");

            JsonNode orderData = root.get(data);

            log.debug("🔍 Extracted order data from JSON");

            return orderData;

        } catch (Exception e) {
            log.error("❌ Failed to read menu configuration JSON", e);
            throw new RuntimeException("❌ Failed to read JSON", e);
        }
    }

}