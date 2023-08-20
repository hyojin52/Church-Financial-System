package com.book.dalant.web.rest;

import com.book.dalant.service.GroupsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "소그룹 관리")
@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupsController {
  
  private final GroupsService groupsService;
  
  @GetMapping("{churchId}")
  @Operation(
          summary = "소그룹 목록 조회",
          description = "소그룹의 목록을 조회한다. \n\n" +
                  "* offset 파라미터 : 몇 번째 page 인지 \n\n" +
                  "   * ex) 0 \n\n" +
                  "* pageSize 파라미터 : page 크기 \n\n" +
                  "   * ex) 10 \n\n" +
                  "* churchId 파라미터 : \n\n" +
                  "   * 소그룹이 속한 교회의 id \n\n" +
                  "* 기본 sorting : createdDt, DESC \n\n"
  )
  public Result getGroupList(
          @RequestParam(defaultValue = "0") int offset,
          @RequestParam(defaultValue = "10") int pageSize,
          @PathVariable String churchId
  ) {
    return Result.okWithPaging(groupsService.getGroupList(offset, pageSize, churchId));
  }
}
