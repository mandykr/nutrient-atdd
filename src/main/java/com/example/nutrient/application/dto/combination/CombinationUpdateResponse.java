package com.example.nutrient.application.dto.combination;

import com.example.nutrient.domain.Combination;
import com.example.nutrient.domain.CombinationLineItem;
import com.example.nutrient.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CombinationUpdateResponse {
    private UUID id;
    private String title;
    private String content;
    private List<CombinationLineItem> combinationLineItems;
    private Gender recommendedGender;
    private HealthStatusResponse healthStatusResponse;

    public static CombinationUpdateResponse of(Combination combination) {
        return new CombinationUpdateResponse(
                combination.getId(),
                combination.getTitle(),
                combination.getContent(),
                combination.getCombinationLineItems(),
                combination.getRecommendedGender(),
                HealthStatusResponse.of(combination.getHealthStatus())
        );
    }
}
