package com.sursindmitry.commonmodels.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sursindmitry.commonmodels.exception.JsonParseException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Парсинг json-файлов.
 */
public class JsonParserUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(
        new JavaTimeModule()
    );
    private final Logger logger = Logger.getLogger(JsonParserUtil.class.getName());

    /**
     * Парсинг json'а из файла.
     *
     * @param filepath путь до файла
     * @param clazz конечный класс парсинга
     * @param <T> любой объект для парсинга
     * @return объект парсинга
     */
    public <T> T getObjectFromJson(String filepath, Class<T> clazz) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filepath)) {
            return OBJECT_MAPPER.readValue(inputStream, clazz);
        } catch (IOException e) {
            logger.log(
                Level.SEVERE,
                MessageFormat.format("Error parsing JSON from file {0} in class {1}",
                    filepath,
                    clazz.getSimpleName()
                )
            );
            throw new JsonParseException(e.getMessage());
        }
    }
}
