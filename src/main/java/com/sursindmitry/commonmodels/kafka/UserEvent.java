package com.sursindmitry.commonmodels.kafka;

import com.sursindmitry.commonmodels.kafka.enums.UserEventStatus;
import java.util.UUID;

/**
 * Kafka UserEvent.
 * <p>
 * Объект который отправляется в кафку при создании/обновлении/удалении пользователя
 * </p>
 */
public record UserEvent(
    UUID id,
    UUID userId,
    String name,
    String lastName,
    String email,
    UserEventStatus status
) {
}
