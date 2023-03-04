package com.example.rollerShop.db.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UUID", nullable = false, length = 36, unique = true)
    @Convert(converter = UUIDConverter.class)
    private final UUID uuid = UUID.randomUUID();


    private static class UUIDConverter implements AttributeConverter<UUID, String> {
        @Override
        public String convertToDatabaseColumn(UUID attribute) {
            return attribute.toString();
        }

        @Override
        public UUID convertToEntityAttribute(String dbData) {
            return UUID.fromString(dbData);
        }
    }
}
