package com.book.dalant.domain;

import com.book.dalant.constants.UsersConstant;
import com.book.dalant.converter.YesNoConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class UsersEntity extends AbstractAuditingEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "USER_ID", columnDefinition = "VARCHAR(100)", nullable = false, length = 100)
  private String userId;
  
  @Column(name = "USER_NAME", columnDefinition = "VARCHAR(50)", nullable = false, length = 50)
  private String userName;
  
  @Column(name = "MOBILE_NUMBER", columnDefinition = "VARCHAR(20)", length = 20)
  private String mobileNumber;
  
  @Column(name = "BIRTH_DATE", columnDefinition = "VARCHAR(10)", nullable = false, length = 10)
  private String birthDate;
  
  @Enumerated(EnumType.STRING)
  @Column(name = "POSITION", columnDefinition = "VARCHAR(100)", length = 100)
  private UsersConstant.Position position;
  
  @Convert(converter = YesNoConverter.class)
  @Column(name = "USER_ACTIVE_YN", length = 1, nullable = false)
  private boolean userActiveYn;
}
