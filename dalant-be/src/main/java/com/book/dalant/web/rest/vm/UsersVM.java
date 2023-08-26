package com.book.dalant.web.rest.vm;

import com.book.dalant.constants.FamilyUsersConstant;
import com.book.dalant.constants.UsersConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class UsersVM {
  
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Create {
    private String userName;
    private String mobileNumber;
    private String birthDate;
    private UsersConstant.Position position;
    private boolean isUserActive;
    private String groupId;
    private List<Family> familyList;
  }
  
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Family {
    private String familyUserId;
    private FamilyUsersConstant.Relationship relationship;
  }
}
