package com.book.dalant.service;

import com.book.dalant.constants.FamilyUsersConstant;
import com.book.dalant.domain.FamilyUsersEntity;
import com.book.dalant.domain.UsersEntity;
import com.book.dalant.repository.FamilyUsersRepository;
import com.book.dalant.service.specification.FamilyUsersSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FamilyUsersService {
  
  private final FamilyUsersRepository familyUsersRepository;
  
  public void createFamilyUsers(
          UsersEntity parentUser,
          UsersEntity childUser,
          FamilyUsersConstant.Relationship relationship) {
    
    // parent(parentUser) - child(childUser) 추가
    FamilyUsersEntity p2cFamilyUser = new FamilyUsersEntity();
    p2cFamilyUser.setUser(parentUser);
    p2cFamilyUser.setFamilyUser(childUser);
    p2cFamilyUser.setFamilyRelationship(relationship);
    familyUsersRepository.save(p2cFamilyUser);
    
    // parent(childUser) - child(parentUser) 존재 여부 체크
    // 존재한다면 pass, 존재하지 않는다면 추가
    FamilyUsersConstant.Relationship c2pRelationship = FamilyUsersConstant.Relationship.valueOf(relationship.getChangeName());
    Specification<FamilyUsersEntity> c2PFamilyUserSpec = FamilyUsersSpecification.findC2PFamilyUser(childUser, parentUser, c2pRelationship);
    Optional<FamilyUsersEntity> c2pFamilyUserOptional = familyUsersRepository.findOne(c2PFamilyUserSpec);
    if(c2pFamilyUserOptional.isEmpty()) {
      FamilyUsersEntity c2pFamilyUser = new FamilyUsersEntity();
      c2pFamilyUser.setUser(childUser);
      c2pFamilyUser.setFamilyUser(parentUser);
      c2pFamilyUser.setFamilyRelationship(c2pRelationship);
      familyUsersRepository.save(c2pFamilyUser);
    }

  }
}
