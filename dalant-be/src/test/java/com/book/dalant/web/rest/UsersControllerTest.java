package com.book.dalant.web.rest;

import com.book.dalant.constants.FamilyUsersConstant;
import com.book.dalant.constants.UsersConstant;
import com.book.dalant.web.rest.vm.UsersVM;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UsersControllerTest {
  
  @Autowired
  ObjectMapper mapper;
  
  @Autowired
  MockMvc mockMvc;
  
  private static final String URL = "/api/v1/users";
  
  @Test
  @DisplayName(value = "user 생성 api" +
          "- family user 가 존재하지 않는 경우, 404 예상")
  void createUserTestWithNoFamilyUser() throws Exception {
    // given
    UsersVM.Create userVM = new UsersVM.Create();
    userVM.setUserName("김딸");
    userVM.setPosition(UsersConstant.Position.LAY_MAN);
    userVM.setUserActive(true);
    userVM.setBirthDate("20230101");
    userVM.setMobileNumber("+821012341234");
    userVM.setGroupId("group-1");
    userVM.setFamilyList(Collections.singletonList(
            UsersVM.Family.builder()
                    .familyUserId("no-user")
                    .relationship(FamilyUsersConstant.Relationship.PARENT)
                    .build()));
    
    // when, then
    mockMvc.perform(post(URL)
                    .content(mapper.writeValueAsString(userVM))
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError());
  }
  
  @Test
  @DisplayName(value = "user 생성 api" +
          "- group id 가 존재하지 않는 경우, 404 예상")
  void createUserTestWithNoGroup() throws Exception {
    // given
    UsersVM.Create userVM = new UsersVM.Create();
    userVM.setUserName("김딸");
    userVM.setPosition(UsersConstant.Position.LAY_MAN);
    userVM.setUserActive(true);
    userVM.setBirthDate("20230101");
    userVM.setMobileNumber("+821012341234");
    userVM.setGroupId("no-group");
    userVM.setFamilyList(Collections.singletonList(
            UsersVM.Family.builder()
                    .familyUserId("user-1")
                    .relationship(FamilyUsersConstant.Relationship.PARENT)
                    .build()));
    
    // when, then
    mockMvc.perform(post(URL)
            .content(mapper.writeValueAsString(userVM))
            .contentType(MediaType.APPLICATION_JSON));
  }
  
  @Test
  @DisplayName(value = "user 생성 api" +
          "- 201 예상")
  void createUserTest() throws Exception {
    // given
    UsersVM.Create userVM = new UsersVM.Create();
    userVM.setUserName("김딸");
    userVM.setPosition(UsersConstant.Position.LAY_MAN);
    userVM.setUserActive(true);
    userVM.setBirthDate("20230101");
    userVM.setMobileNumber("+821012341234");
    userVM.setGroupId("group-1");
    userVM.setFamilyList(Collections.singletonList(
            UsersVM.Family.builder()
                    .familyUserId("user-1")
                    .relationship(FamilyUsersConstant.Relationship.PARENT)
                    .build()));
    
    // when, then
    mockMvc.perform(post(URL)
            .content(mapper.writeValueAsString(userVM))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful());
  }
  
  @Test
  @DisplayName(value = "유저 목록 조회 api" +
          "- 200 예상")
  void getUserList() {
  }
  
}