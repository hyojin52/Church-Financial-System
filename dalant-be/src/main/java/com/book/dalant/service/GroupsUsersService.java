package com.book.dalant.service;

import com.book.dalant.domain.GroupsEntity;
import com.book.dalant.domain.GroupsUsersEntity;
import com.book.dalant.domain.UsersEntity;
import com.book.dalant.repository.GroupsRepository;
import com.book.dalant.repository.GroupsUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GroupsUsersService {
  
  private final GroupsRepository groupsRepository;
  private final GroupsUsersRepository groupsUsersRepository;
  
  public void createGroupsUsers(UsersEntity user, String groupId) {
    GroupsEntity group = groupsRepository.findById(groupId).orElseThrow(NoSuchElementException::new);
    
    GroupsUsersEntity groupUser = new GroupsUsersEntity();
    groupUser.setGroup(group);
    groupUser.setUser(user);
    groupsUsersRepository.save(groupUser);
  }
  
}
