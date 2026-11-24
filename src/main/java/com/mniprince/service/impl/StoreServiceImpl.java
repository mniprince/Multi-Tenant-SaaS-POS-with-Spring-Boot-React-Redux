package com.mniprince.service.impl;

import com.mniprince.domain.StoreStatus;
import com.mniprince.exceptions.UserException;
import com.mniprince.mapper.StoreMapper;
import com.mniprince.modal.Store;
import com.mniprince.modal.StoreContact;
import com.mniprince.modal.User;
import com.mniprince.payload.dto.StoreDto;
import com.mniprince.service.repository.StoreRepository;
import com.mniprince.service.StoreService;
import com.mniprince.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public StoreDto createStore(StoreDto storeDto, User user) {
        Store store = StoreMapper.toEntity(storeDto, user);
        return StoreMapper.toDTO(storeRepository.save(store));
    }

    @Override
    public StoreDto getStoreById(Long id) throws Exception {
        Store store = storeRepository.findById(id).orElseThrow(
                ()->new Exception("Store Not Found")
        );
        return StoreMapper.toDTO(store);
    }

    @Override
    public List<StoreDto> getAllStores() {

        List<Store> dtos = storeRepository.findAll();
        
      return  dtos.stream().map(StoreMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Store getStoreByAdmin() throws UserException {
        User admin = userService.getCurrentUser();
        return storeRepository.findByStoreAdminId(admin.getId());
    }

    @Override
    public StoreDto updateStore(Long id, StoreDto storeDto) throws Exception {
        User currentUser = userService.getCurrentUser();
        Store existing = storeRepository.findByStoreAdminId(currentUser.getId());
        if (existing == null) {
            throw new Exception("Store Not Found");
        }

        existing.setBrand(storeDto.getBrand());
        existing.setDescription(storeDto.getDescription());
        if (storeDto.getStoreType() != null) {
            existing.setStoreType(storeDto.getStoreType());
        }
        if (storeDto.getContact() != null) {
            StoreContact contact = StoreContact.builder()
                    .address(storeDto.getContact().getAddress())
                    .phone(storeDto.getContact().getPhone())
                    .email(storeDto.getContact().getEmail())
                    .build();
            existing.setContact(contact);
        }
        Store updateStore = storeRepository.save(existing);
        return StoreMapper.toDTO(updateStore);
    }

    @Override
    public void deleteStore(Long id) throws UserException {
        Store store = getStoreByAdmin();

        storeRepository.delete(store);
    }

    @Override
    public StoreDto getStoreByEmployee() throws UserException {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new UserException("You don't have permission to access this STORE");
        }
        return StoreMapper.toDTO(currentUser.getStore());
    }

    @Override
    public StoreDto moderateStore(Long id, StoreStatus status) throws Exception {
        Store store = storeRepository.findById(id).orElseThrow(
                ()->new Exception("Store Not Found")
        );
        store.setStatus(status);
        Store updateStore = storeRepository.save(store);
        return StoreMapper.toDTO(updateStore);
    }



}
