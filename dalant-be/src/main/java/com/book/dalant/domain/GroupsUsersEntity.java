package com.book.dalant.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GROUPS_USERS")
@Getter
@Setter
public class GroupsUsersEntity extends AbstractAuditingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "GROUP_USER_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
  private String groupUserId;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private UsersEntity user;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GROUP_ID")
  private GroupsEntity group;
  
}
