package com.sample.AcademicProjectManagementSystem.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    ADMIN(1),
    HOD(2),
    INTERNAL_GUIDE(3),
    PROJECT_IN_CHARGE(4),
    STUDENT(5);

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static UserRole fromValue(int value) {
        for (UserRole role : UserRole.values()) {
            if (role.getValue() == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole value: " + value);
    }

}
