package com.example.nutrient.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Combination {
    @Column(name = "id", columnDefinition = "varbinary(16)")
    @Id
    private UUID id;

    @Embedded
    private CombinationTitle title;

    @Embedded
    private CombinationContent content;

    @Enumerated(EnumType.STRING)
    private Gender recommendedGender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "health_condition_id",
            columnDefinition = "varbinary(16)",
            foreignKey = @ForeignKey(name = "fk_combination_to_health_condition")
    )
    private HealthCondition healthCondition;

    @Embedded
    private CombinationLineItems combinationLineItems;

    public UUID getId() {
        return id;
    }

    public CombinationTitle getTitle() {
        return title;
    }

    public CombinationContent getContent() {
        return content;
    }

    public Gender getRecommendedGender() {
        return recommendedGender;
    }

    public HealthCondition getHealthCondition() {
        return healthCondition;
    }

    public List<CombinationLineItem> getCombinationLineItems() {
        return combinationLineItems.getCombinationLineItems();
    }
}