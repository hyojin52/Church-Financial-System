package com.book.dalant.web.rest;

import com.book.dalant.config.Constants;
import com.book.dalant.service.UsersService;
import com.book.dalant.web.rest.vm.UsersVM;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 관리")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
  
  private final UsersService usersService;
  
  @GetMapping
  public Result getUserList() {
    return Result.ok();
  }
  
  @PostMapping
  public Result createUser(@RequestBody UsersVM.Create user) {
    return Result.withMessage(
            Constants.CommonCode.CREATED,
            "Creation of user succeeded.",
            usersService.createUser(user));
  }
}
