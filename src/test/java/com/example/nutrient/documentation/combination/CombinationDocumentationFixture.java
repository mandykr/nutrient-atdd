package com.example.nutrient.documentation.combination;

import com.example.nutrient.application.dto.combination.*;
import com.example.nutrient.domain.Gender;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CombinationDocumentationFixture {
    public static final List<UUID> SUPPLEMENT_IDS;
    public static final HealthStatusResponse HEALTH_STATUS_RESPONSE;
    public static final CombinationCreateRequest CREATE_REQUEST;
    public static final CombinationCreateResponse CREATE_RESPONSE;
    public static final CombinationUpdateRequest UPDATE_REQUEST;
    public static final CombinationUpdateResponse UPDATE_RESPONSE;

    static {
        SUPPLEMENT_IDS = Arrays.asList(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID()
        );

        HEALTH_STATUS_RESPONSE = new HealthStatusResponse(
                UUID.randomUUID(),
                "무기력증"
        );

        CREATE_REQUEST = new CombinationCreateRequest(
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                SUPPLEMENT_IDS,
                Gender.MALE,
                UUID.randomUUID()
        );

        CREATE_RESPONSE = new CombinationCreateResponse(
                UUID.randomUUID(),
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                Collections.EMPTY_LIST,
                Gender.MALE,
                HEALTH_STATUS_RESPONSE
        );

        UPDATE_REQUEST = new CombinationUpdateRequest(
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                SUPPLEMENT_IDS,
                Gender.MALE,
                UUID.randomUUID()
        );

        UPDATE_RESPONSE = new CombinationUpdateResponse(
                UUID.randomUUID(),
                "무기력증에 추천",
                "<p>일상이 무기력할 때 추천하는 영양제 조합입니다.<p>",
                Collections.EMPTY_LIST,
                Gender.MALE,
                HEALTH_STATUS_RESPONSE
        );
    }
}
