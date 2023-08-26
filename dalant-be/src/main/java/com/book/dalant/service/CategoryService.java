package com.book.dalant.service;

import com.book.dalant.config.Constants;
import com.book.dalant.config.OffsetPageRequest;
import com.book.dalant.constants.CategoryConstant;
import com.book.dalant.domain.CategoryEntity;
import com.book.dalant.exception.BusinessException;
import com.book.dalant.repository.CategoryRepository;
import com.book.dalant.repository.SubCategoryRepository;
import com.book.dalant.service.dto.CategoryDTO;
import com.book.dalant.service.specification.CategorySpecification;
import com.book.dalant.web.rest.vm.CategoryVM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    public Page<CategoryDTO.Category> getCategory(
            int offset,
            int pageSize,
            CategoryConstant.CategoryType categoryType
    ) {
        Pageable pageable = OffsetPageRequest.of(
            offset,
            pageSize,
            Sort.by(Sort.Direction.ASC, "categoryName")
        );
        
        return (categoryType == null ?
                categoryRepository.findAll(pageable)
                : categoryRepository.findAll(CategorySpecification.filterCategoryType(categoryType), pageable))
                    .map(CategoryDTO.Category::new);
    }
    
    public boolean createCategory(CategoryVM.Create categoryVm) {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryVm.getCategoryName());
        category.setCategoryType(categoryVm.getCategoryType());
        categoryRepository.save(category);
        return true;
    }
    
    public CategoryDTO.Category updateCategory(String categoryId, CategoryVM.Update categoryVm) {
        CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
        category.setCategoryName(categoryVm.getCategoryName());
        category = categoryRepository.save(category);
        return new CategoryDTO.Category(category);
    }
    
    public boolean deleteCategory(String categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
        boolean isExistSubCategory = subCategoryRepository.existsByCategory(category);
        if(isExistSubCategory) {
            throw new BusinessException(Constants.CommonCode.SUB_CATEGORY_EXISTS);
        }
        categoryRepository.delete(category);
        return true;
    }
    
}
