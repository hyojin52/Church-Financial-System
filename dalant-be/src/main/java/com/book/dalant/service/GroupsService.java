package com.book.dalant.service;


import com.book.dalant.config.OffsetPageRequest;
import com.book.dalant.domain.ChurchEntity;
import com.book.dalant.domain.GroupsEntity;
import com.book.dalant.repository.ChurchRepository;
import com.book.dalant.repository.GroupsRepository;
import com.book.dalant.service.dto.GroupsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GroupsService {
  
  private final ChurchRepository churchRepository;
  private final GroupsRepository groupsRepository;
  
  public Page<GroupsDTO.Group> getGroupList(
          int offset,
          int pageSize,
          String churchId) {
    
    Pageable pageable = OffsetPageRequest.of(
            offset,
            pageSize,
            Sort.by(Sort.Direction.DESC, "createdDt")
    );
    
    ChurchEntity church = churchRepository.findById(churchId).orElseThrow(NoSuchElementException::new);
    return groupsRepository.findByChurch(church, pageable)
            .map(GroupsDTO.Group::new);
    
  }
}
