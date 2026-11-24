package com.mniprince.service.impl;

import com.mniprince.domain.UserRole;
import com.mniprince.exceptions.UserException;
import com.mniprince.mapper.CategoryMapper;
import com.mniprince.modal.Category;
import com.mniprince.modal.Store;
import com.mniprince.modal.User;
import com.mniprince.payload.dto.CategoryDto;
import com.mniprince.service.CategoryService;
import com.mniprince.service.UserService;
import com.mniprince.service.repository.CategoryRepository;
import com.mniprince.service.repository.StoreRepository;
import jakarta.el.ELException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
private final CategoryRepository categoryRepository;
private final UserService userService;
private final StoreRepository storeRepository;

    @Override
    public CategoryDto createCategory(CategoryDto dto) throws Exception {
        User user = userService.getCurrentUser();
        Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(
                ()-> new Exception("Store Not Found..!")
        );

        Category category = Category.builder()
                .store(store)
                .name(dto.getName())
                .build();

        checkAuthority(user, category.getStore());

        return CategoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDto> getCategoriesByStore(Long storeId) {
        List<Category> categories = categoryRepository.findByStoreId(storeId);
        return categories.stream()
                .map(
                        CategoryMapper::toDTO
                ).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto) throws Exception {

        Category category = categoryRepository.findById(id).orElseThrow(
                ()->new Exception("Category Not Found..!")
        );
        User user = userService.getCurrentUser();
        category.setName(dto.getName());

        checkAuthority(user, category.getStore());

        return CategoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()->new Exception("Category Not Found..!")
        );
        User user = userService.getCurrentUser();

        checkAuthority(user, category.getStore());
        categoryRepository.delete(category);
    }

    private void checkAuthority(User user,Store store) throws Exception {
        boolean isAdmin = user.getRole().equals(UserRole.ROLE_STORE_ADMIN);
        boolean isManager = user.getRole().equals(UserRole.ROLE_BRANCH_MANAGER);
        boolean isSameStore = user.equals(store.getStoreAdmin());

        if(!(isAdmin && isSameStore) && !isManager){
            throw new Exception("You are not permited to Manage this Category.");

        }
    }

}
