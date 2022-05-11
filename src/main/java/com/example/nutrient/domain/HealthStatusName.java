package com.example.nutrient.domain;

import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class HealthStatusName {
    private static final String HEALTH_STATUS_NAME_MUST_NOT_BE_EMPTY = "건강 상태 이름은 비어있지 않아야 합니다.";
    private final String name;

    protected HealthStatusName() {
        this.name = null;
    }

    protected HealthStatusName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Strings.isEmpty(name)) {
            throw new IllegalArgumentException(HEALTH_STATUS_NAME_MUST_NOT_BE_EMPTY);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthStatusName that = (HealthStatusName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}