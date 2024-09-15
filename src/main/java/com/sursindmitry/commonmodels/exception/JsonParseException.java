package com.sursindmitry.commonmodels.exception;

/**
 * Ошибка парсинга json-объекта.
 */
public class JsonParseException extends RuntimeException {
    public JsonParseException(String message) {
        super(message);
    }
}
