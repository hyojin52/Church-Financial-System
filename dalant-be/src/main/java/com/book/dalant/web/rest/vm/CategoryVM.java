package com.book.dalant.web.rest.vm;

import com.book.dalant.constants.CategoryConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryVM {
    
    @Data
    @NoArgsConstructor
    public static class Create {
        private String categoryName;
        private CategoryConstant.CategoryType categoryType;
    }
    
    @Data
    @NoArgsConstructor
    public static class Update {
        private String categoryName;
    }

    public static class Filter {
        private String key;
        private String value;

    }
}
