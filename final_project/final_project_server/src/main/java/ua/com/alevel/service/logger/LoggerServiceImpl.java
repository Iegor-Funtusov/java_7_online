package ua.com.alevel.service.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger(LoggingLevel.INFO.getLevel());
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(LoggingLevel.ERROR.getLevel());

    @Override
    public void log(LoggingLevel level, String message) {
        switch (level) {
            case INFO -> LOGGER_INFO.info(message);
            case ERROR -> LOGGER_ERROR.error(message);
        }
    }
}
