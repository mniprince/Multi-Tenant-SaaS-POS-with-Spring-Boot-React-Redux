package com.mniprince.payload.dto;

import com.mniprince.modal.Store;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Long id;

    private String name;

    private Long storeId;
}
