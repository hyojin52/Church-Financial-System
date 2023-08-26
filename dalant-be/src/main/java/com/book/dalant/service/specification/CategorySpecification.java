package com.book.dalant.service.specification;

import com.book.dalant.constants.CategoryConstant;
import com.book.dalant.domain.CategoryEntity;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecification {

    public static Specification<CategoryEntity> filterCategoryType(CategoryConstant.CategoryType categoryType) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("categoryType"), categoryType);
        });
    }
}
