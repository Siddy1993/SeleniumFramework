package utilities;

import java.io.IOException;
import java.util.logging.*;

public class LoggerManager {

    private static final Logger logger = Logger.getLogger(LoggerManager.class.getName());

    static {
        try {
            // Create file handler
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            // Create console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());

            // Add handlers to logger
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

            // Set log level to ALL
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    // Log info messages
    public static void info(String message) {
        logger.info(message);
    }

    // Log warning messages
    public static void warning(String message) {  // Fixed from warn() to warning()
        logger.warning(message);
    }

    // Log error messages
    public static void error(String message) {
        logger.severe(message);
    }

    public static void main(String[] args) {
        // Example usage
        LoggerManager.info("This is an INFO log.");
        LoggerManager.warning("This is a WARNING log.");
        LoggerManager.error("This is an ERROR log.");
    }
}
