package com.mniprince.service;

import com.mniprince.domain.StoreStatus;
import com.mniprince.exceptions.UserException;
import com.mniprince.modal.Store;
import com.mniprince.modal.User;
import com.mniprince.payload.dto.StoreDto;

import java.util.List;

public interface StoreService {


    StoreDto createStore(StoreDto storeDto, User user);
    StoreDto getStoreById(Long id) throws Exception;
    List<StoreDto> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDto updateStore(Long id, StoreDto storeDto) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDto getStoreByEmployee() throws UserException;

    StoreDto moderateStore(Long id, StoreStatus status) throws Exception;


}
