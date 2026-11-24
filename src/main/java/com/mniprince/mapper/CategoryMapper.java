package com.mniprince.mapper;

import com.mniprince.modal.Category;
import com.mniprince.payload.dto.CategoryDto;

public class CategoryMapper {

    public static CategoryDto toDTO(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .storeId(category.getStore()!=null?category.getStore().getId():null)
                .build();
    }
}
