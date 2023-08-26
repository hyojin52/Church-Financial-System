package com.book.dalant.service;

import com.book.dalant.domain.CategoryEntity;
import com.book.dalant.domain.SubCategoryEntity;
import com.book.dalant.repository.CategoryRepository;
import com.book.dalant.repository.SubCategoryRepository;
import com.book.dalant.service.dto.CategoryDTO;
import com.book.dalant.web.rest.vm.CategoryVM;
import com.book.dalant.web.rest.vm.SubCategoryVM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoryService {
  
  private final CategoryRepository categoryRepository;
  private final SubCategoryRepository subCategoryRepository;
  
  public boolean createSubCategory(
          String categoryId,
          SubCategoryVM.Create subCategoryVm) {
    CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
    SubCategoryEntity subCategory = new SubCategoryEntity();
    subCategory.setCategory(category);
    subCategory.setSubCategoryName(subCategoryVm.getSubCategoryName());
    subCategory.setUserTypeYn(subCategoryVm.isUserType());
    subCategory.setSubCategoryDesc(subCategoryVm.getSubCategoryDesc());
    subCategoryRepository.save(subCategory);
    return true;
  }
  
  public List<CategoryDTO.SubCategory> getSubCategoryList(String categoryId) {
    CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
    return subCategoryRepository.findAllByCategory(category).stream()
            .map(CategoryDTO.SubCategory::new)
            .collect(Collectors.toList());
  }
  
  public CategoryDTO.SubCategory updateSubCategory(
          String subCategoryId,
          SubCategoryVM.Update subCategoryVm) {
    SubCategoryEntity subCategory = subCategoryRepository.findById(subCategoryId).orElseThrow(NoSuchElementException::new);
    subCategory.setSubCategoryName(subCategoryVm.getSubCategoryName());
    subCategory.setSubCategoryDesc(subCategoryVm.getSubCategoryDesc());
    subCategory = subCategoryRepository.save(subCategory);
    return new CategoryDTO.SubCategory(subCategory);
  }
  
  public boolean deleteSubCategory(String subCategoryId) {
    SubCategoryEntity subCategory = subCategoryRepository.findById(subCategoryId).orElseThrow(NoSuchElementException::new);
    // TODO income or spending 테이블의 dependency 확인 후 삭제
    subCategoryRepository.delete(subCategory);
    return true;
  }
  
}
