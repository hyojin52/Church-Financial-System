package com.book.dalant.domain;

import com.book.dalant.constants.FamilyUsersConstant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FAMILY_USERS")
@Getter
@Setter
public class FamilyUsersEntity extends AbstractAuditingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "FAMILY_USER_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
  private String familyUserId;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PARENT_USER_ID")
  private UsersEntity user;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CHILD_USER_ID")
  private UsersEntity familyUser;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "FAMILY_RELATIONSHIP", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
  private FamilyUsersConstant.Relationship familyRelationship;
  
}
