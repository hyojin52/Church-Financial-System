package com.book.dalant.domain;

import com.book.dalant.converter.YesNoConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SUB_CATEGORY")
@Getter
@Setter
public class SubCategoryEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "SUB_CATEGORY_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
    private String subCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    @Column(name = "SUB_CATEGORY_NAME", length = 100, nullable = false)
    private String subCategoryName;

    @Convert(converter = YesNoConverter.class)
    @Column(name = "USER_TYPE_YN", length = 1, nullable = false)
    private boolean userTypeYn;

    @Column(name = "SUB_CATEGORY_DESC", length = 500)
    private String subCategoryDesc;

}
