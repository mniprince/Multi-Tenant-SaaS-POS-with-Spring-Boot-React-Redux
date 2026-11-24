package com.mniprince.controller;

import com.mniprince.modal.Category;
import com.mniprince.payload.dto.CategoryDto;
import com.mniprince.payload.response.ApiResponse;
import com.mniprince.service.CategoryService;
import com.mniprince.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody CategoryDto categoryDto
            ) throws Exception {

        return ResponseEntity.ok(
                categoryService.createCategory(categoryDto)
        );
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByStoreId(
            @PathVariable Long storeId
    ) throws Exception {

        return ResponseEntity.ok(
                categoryService.getCategoriesByStore(storeId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Long id ) throws Exception {
        return ResponseEntity.ok(
                categoryService.updateCategory(
                        id ,categoryDto
                )
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Long id ) throws Exception {

        categoryService.deleteCategory(
                id
        );

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Category deleted successfully!");
        return ResponseEntity.ok(
                apiResponse

        );
    }


    


}
