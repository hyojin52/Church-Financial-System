package com.book.dalant.constants;

import lombok.Getter;

public class FamilyUsersConstant {
  
  public enum Relationship {
    PARENT("PARENT", "CHILDREN"),
    SISTER("SISTER", "SISTER"), BROTHER("BROTHER", "BROTHER"),
    SPOUSE("SPOUSE", "SPOUSE"), // (배우자)
    CHILDREN("CHILDREN", "PARENT");// (자녀)
    
    @Getter
    private String name;
    @Getter
    private String changeName;
    
    Relationship(String name, String changeName) {
      this.name = name;
      this.changeName = changeName;
    }
    
    
  }
}
