package com.mniprince.controller;


import com.mniprince.modal.Product;
import com.mniprince.modal.User;
import com.mniprince.payload.dto.ProductDTO;
import com.mniprince.payload.response.ApiResponse;
import com.mniprince.service.ProductService;
import com.mniprince.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO,
                                             @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(
         productService.createProduct(
                 productDTO, user
         )
        );
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<ProductDTO>> getByStoreId(
            @PathVariable Long storeId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.getProductsByStoreId(
                        storeId
                )
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> update(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(
                productService.updateProduct(
                        id, productDTO, user
                )
        );
    }

    @GetMapping("/store/{storeId}/search")
    public ResponseEntity<List<ProductDTO>> getByKeyword(
            @PathVariable Long storeId,
            @RequestParam String keyword,
            @RequestHeader("Authorization") String jwt) throws Exception {

        return ResponseEntity.ok(
                productService.searchByKeyword(
                        storeId, keyword
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> dalete(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.getUserFromJwtToken(jwt);

        productService.deleteProduct(
                id,  user
        );
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Product deleted successfully");
        return ResponseEntity.ok(
        apiResponse
        );
    }


}
