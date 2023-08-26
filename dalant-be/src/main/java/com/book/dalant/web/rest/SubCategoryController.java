package com.book.dalant.web.rest;

import com.book.dalant.config.Constants;
import com.book.dalant.service.SubCategoryService;
import com.book.dalant.web.rest.vm.SubCategoryVM;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "하위 항목 관리")
@RestController
@RequestMapping("/api/v1/sub-category")
@RequiredArgsConstructor
public class SubCategoryController {
  
  private final SubCategoryService subCategoryService;
  
  @PostMapping("{categoryId}")
  @Operation(
          summary = "하위 항목 생성",
          description = "상위 항묵을 기준으로 하위 항목을 생성한다. \n\n"
  )
  public Result createSubCategory(
          @PathVariable String categoryId,
          @RequestBody SubCategoryVM.Create categoryVm) {
    return Result.withMessage(
            Constants.CommonCode.CREATED,
            "Creation of sub-category succeeded.",
            subCategoryService.createSubCategory(categoryId, categoryVm));
  }
  
  @GetMapping("{categoryId}")
  @Operation(
          summary = "하위 항목 목록 조회",
          description = "해당 상위 항목의 하위 항목 목록을 조회한다. \n\n"
  )
  public Result getSubCategoryList(
          @PathVariable String categoryId) {
    return Result.ok(subCategoryService.getSubCategoryList(categoryId));
  }
  
  @PutMapping("subCategoryId")
  @Operation(
          summary = "하위 항목 수정",
          description = "하위 항목을 수정한다. \n\n" +
                  "* 수정 가능한 항목 : subCategoryName, subCategoryDesc \n\n" +
                  "* 수정 불가능한 항목 : isUserType \n\n"
  )
  public Result updateSubCategory(
          @PathVariable String subCategoryId,
          @RequestBody SubCategoryVM.Update subCategoryVm) {
    return Result.ok(subCategoryService.updateSubCategory(subCategoryId, subCategoryVm));
  }
  
  @DeleteMapping("{subCategoryId}")
  @Operation(
          summary = "하위 항목 삭제",
          description = "하위 항목을 삭제한다. \n\n"
  )
  public Result deleteSubCategory(@PathVariable String subCategoryId) {
    return Result.ok(subCategoryService.deleteSubCategory(subCategoryId));
  }
}
