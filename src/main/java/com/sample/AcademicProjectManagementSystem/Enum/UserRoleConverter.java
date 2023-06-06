package com.sample.AcademicProjectManagementSystem.Enum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRole role) {
        return role.getValue();
    }

    @Override
    public UserRole convertToEntityAttribute(Integer value) {
        return UserRole.fromValue(value);
    }
}

