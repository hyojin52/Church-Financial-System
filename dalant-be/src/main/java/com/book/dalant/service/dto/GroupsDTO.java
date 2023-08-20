package com.book.dalant.service.dto;

import com.book.dalant.domain.GroupsEntity;
import lombok.Data;

public class GroupsDTO {
  
  @Data
  public static class Group extends AbstractAuditingDTO.Default {
    private String groupId;
    private String groupName;
    
    public Group(GroupsEntity groupEntity) {
      this.groupId = groupEntity.getGroupId();
      this.groupName = groupEntity.getGroupName();
      this.createdBy = groupEntity.getCreatedBy();
      this.createdDt = groupEntity.getCreatedDt();
      this.updatedBy = groupEntity.getUpdatedBy();
      this.updatedDt = groupEntity.getUpdatedDt();
    }
  }
}
