package com.book.dalant.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "GROUPS")
@Getter
@Setter
public class GroupsEntity extends AbstractAuditingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "GROUP_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
  private String groupId;
  
  @ManyToOne
  @JoinColumn(name = "CHURCH_ID")
  private ChurchEntity church;
  
  @Column(name = "GROUP_NAME", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
  private String groupName;
  
}
