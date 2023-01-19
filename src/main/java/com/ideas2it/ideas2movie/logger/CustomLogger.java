package com.ideas2it.ideas2movie.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <h2>
 *     CustomLogger
 * </h2>
 * <p>
 *     Contains the logger  level
 *     to log the information and exception.
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 05/01/2023
 */
public class CustomLogger {
    private final Logger logger;

    public CustomLogger(Class<?> className) {
        logger = LogManager.getLogger(className);
    }

    /**
     * <h1>
     *     INFO
     * </h1>
     * <p>
     *     Logs the information message.
     * </p>
     *
     * @param message - Holds the info message
     */
    public void info(String message){
        logger.info(message);
    }

    /**
     * <h1>
     *     WARN
     * </h1>
     * <p>
     *     Logs the warning message.
     * </p>
     *
     * @param message - Holds the warning message
     */
    public void warn(String message){
        logger.warn(message);
    }

    /**
     * <h1>
     *     ERROR
     * </h1>
     * <p>
     *     Logs the error message.
     * </p>
     *
     * @param message - Holds the error message
     */
    public void error(String message){
        logger.error(message);
    }

    /**
     * <h1>
     *     DEBUG
     * </h1>
     * <p>
     *     Logs the debug message.
     * </p>
     *
     * @param message - Holds the debug message
     */
    public void debug(String message){
        logger.debug(message);
    }
}