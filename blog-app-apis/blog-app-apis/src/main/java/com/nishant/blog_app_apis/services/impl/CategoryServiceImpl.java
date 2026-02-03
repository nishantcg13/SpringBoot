package com.nishant.blog_app_apis.services.impl;

import com.nishant.blog_app_apis.entites.Category;
import com.nishant.blog_app_apis.exceptions.ResourceNotFoundException;
import com.nishant.blog_app_apis.payloads.CategoryDto;
import com.nishant.blog_app_apis.repositories.CategoryRepository;
import com.nishant.blog_app_apis.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = this.dtoToCategory(categoryDto);

        Category category1 =  this.categoryRepository.save(category);

        return this.categoryToDto(category1);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "CategoryId" , categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = this.categoryRepository.save(category);
        return this.categoryToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "CategoryId" , categoryId));

        this.categoryRepository.delete(category);

    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDto getCategoryById(Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "CategoryId" , categoryId));
        return this.categoryToDto(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = this.categoryRepository.findAll();

        List<CategoryDto> categoryDtoList = categories.stream().map(category -> this.categoryToDto(category)).toList();

        return categoryDtoList;
    }


    // MODEL MAPPER METHODS
    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto = this.modelMapper.map(category , CategoryDto.class);
        return categoryDto;
    }

    public Category dtoToCategory(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto , Category.class);
        return category;
    }
}
