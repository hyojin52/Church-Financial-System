package com.book.dalant.web.rest.vm;

import lombok.Data;
import lombok.NoArgsConstructor;

public class SubCategoryVM {
  @Data
  @NoArgsConstructor
  public static class Create {
    private String subCategoryName;
    private boolean isUserType;
    private String subCategoryDesc;
  }
  
  @Data
  @NoArgsConstructor
  public static class Update {
    private String subCategoryName;
    private String subCategoryDesc;
  }
}
