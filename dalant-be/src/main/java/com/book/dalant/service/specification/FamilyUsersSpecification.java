package com.book.dalant.service.specification;

import com.book.dalant.constants.FamilyUsersConstant;
import com.book.dalant.domain.FamilyUsersEntity;
import com.book.dalant.domain.UsersEntity;
import org.springframework.data.jpa.domain.Specification;

public class FamilyUsersSpecification {
  
  public static Specification<FamilyUsersEntity> findC2PFamilyUser(
          UsersEntity parentUser,
          UsersEntity childUser,
          FamilyUsersConstant.Relationship relationship) {
    
    return ((root, query, criteriaBuilder) -> {
      return criteriaBuilder.and(
              criteriaBuilder.equal(root.get("user"), parentUser),
              criteriaBuilder.equal(root.get("familyUser"), childUser),
              criteriaBuilder.equal(root.get("familyRelationship"), relationship));
    });
  }
}
