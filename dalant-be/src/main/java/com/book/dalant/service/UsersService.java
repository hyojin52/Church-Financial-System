package com.book.dalant.service;

import com.book.dalant.domain.UsersEntity;
import com.book.dalant.exception.BusinessException;
import com.book.dalant.repository.UsersRepository;
import com.book.dalant.web.rest.vm.UsersVM;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsersService {
  
  private final UsersRepository usersRepository;
  
  private final GroupsUsersService groupsUsersService;
  private final FamilyUsersService familyUsersService;
  
  @Transactional
  public boolean createUser(UsersVM.Create userVM) {
    try {
      // user table
      UsersEntity user = new UsersEntity();
      user.setUserName(userVM.getUserName());
      user.setMobileNumber(userVM.getMobileNumber());
      user.setBirthDate(userVM.getBirthDate());
      user.setPosition(userVM.getPosition());
      user.setUserActiveYn(userVM.isUserActive());
      usersRepository.save(user);
      
      // family-users table
      for (UsersVM.Family family : userVM.getFamilyList()) {
        UsersEntity familyUser = usersRepository.findById(family.getFamilyUserId()).orElseThrow(NoSuchElementException::new);
        familyUsersService.createFamilyUsers(user, familyUser, family.getRelationship());
      }
      
      // groups-users table
      groupsUsersService.createGroupsUsers(user, userVM.getGroupId());
      
    } catch (NoSuchElementException e) {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); // rollback
      throw e;
    }
    
    return true;
  }
}
