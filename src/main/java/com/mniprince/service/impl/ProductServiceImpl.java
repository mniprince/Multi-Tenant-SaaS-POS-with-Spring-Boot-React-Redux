package com.mniprince.service.impl;

import com.mniprince.mapper.ProductMapper;
import com.mniprince.modal.Category;
import com.mniprince.modal.Product;
import com.mniprince.modal.Store;
import com.mniprince.modal.User;
import com.mniprince.payload.dto.ProductDTO;
import com.mniprince.service.repository.CategoryRepository;
import com.mniprince.service.repository.StoreRepository;
import com.mniprince.service.ProductService;
import com.mniprince.service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {
        Store store = storeRepository.findById(
                productDTO.getStoreId()
        ).orElseThrow(
                ()->new Exception("Store not found")
        );

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                ()->new Exception("Category not found")
        );

        Product product = ProductMapper.toEntity(productDTO, store, category);
        Product saveProduct = productRepository.save(product);

        return ProductMapper.toDo(saveProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                ()->new Exception("Product Not Found")
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setMrp(productDTO.getMrp());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setBrand(productDTO.getBrand());

        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                    ()->new Exception("Category not found")
            );

            product.setCategory(category);
        }

        Product saveProduct = productRepository.save(product);


        return ProductMapper.toDo(saveProduct);
    }

    @Override
    public void deleteProduct(Long id, User user) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new Exception("No Product Found..!")
        );
        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> getProductsByStoreId(Long storeId) {
        List<Product> products = productRepository.findByStoreId(storeId);
        return products.stream()
                .map(ProductMapper::toDo)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
        List<Product> products = productRepository.searchByKeyword(storeId, keyword);
        return products.stream()
                .map(ProductMapper::toDo)
                .collect(Collectors.toList());
    }
}
