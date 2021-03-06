package com.example.nutrient.domain;

import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class Supplement extends BaseTimeEntity implements Persistable {


    @Id
    @Column(name = "id", columnDefinition = "varbinary(16)")
    private UUID id;

    @Embedded
    private SupplementTitle title;

    @Embedded
    private SupplementContent content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
        name = "category_id",
        columnDefinition = "varbinary(16)",
        foreignKey = @ForeignKey(foreignKeyDefinition = "fk_category_id_to_supplement")
    )
    private Category category;

    @Override
    public boolean isNew() {
        return this.getCreatedAt() == null;
    }

    public void updateTitle(SupplementTitle supplementTitle) {
        this.title = supplementTitle;
    }

    public void updateContent(SupplementContent supplementContent) {
        this.content = supplementContent;
    }

    public void updateCategory(Category category) {
        if(this.category.getId() != category.getId()){
            this.category = category;
        }
    }

    public String getName(){
        return title.getName();
    }

    public String getSerialNumber() {
        return content.getSerialNumber();
    }

    public LocalDate getPermitDate() {
        return content.getPermitDate();
    }

    public String getExpirationDate() {
        return content.getExpirationDate();
    }

    public String getIntake() {
        return content.getIntake();
    }

    public String getMainFunctional() {
        return content.getMainFunctional();
    }

    public String getPrecautions() {
        return content.getPrecautions();
    }

    public String getStorageWay() {
        return content.getStorageWay();
    }
}
