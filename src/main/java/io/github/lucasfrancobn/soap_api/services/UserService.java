package io.github.lucasfrancobn.soap_api.services;

import com.example.soap.address.Address;
import com.example.soap.address.AddressResponse;
import com.example.soap.users.*;
import io.github.lucasfrancobn.soap_api.mapper.AddressMapper;
import io.github.lucasfrancobn.soap_api.mapper.UserMapper;
import io.github.lucasfrancobn.soap_api.model.AddressModel;
import io.github.lucasfrancobn.soap_api.model.UserModel;
import io.github.lucasfrancobn.soap_api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final String USER_NOT_FOUND = "Usuário não encontrado";
    private final UserRepository repository;
    private final AddressService addressService;

    public UserService(UserRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    @Transactional
    public UserResponse createUser(CreateUser request) {
        AddressResponse addressResponse = addressService.findCep(request.getCep());
        AddressModel addressModel = AddressMapper.toModel(addressResponse.getAddress());
        UserModel userModel = UserMapper.toModel(request, addressModel);

        UserModel savedUser = repository.save(userModel);

        Address address = AddressMapper.toXml(savedUser.getAddress());
        User user = UserMapper.toXml(savedUser, address);

        return generateUserResponse(user);
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        UserModel userModel = repository.findById(id).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        Address address = AddressMapper.toXml(userModel.getAddress());
        User user = UserMapper.toXml(userModel, address);

        return generateUserResponse(user);
    }

    @Transactional
    public DeleteUserResponse deleteUser(Long id) {
        UserModel userModel = repository.findById(id).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        repository.delete(userModel);

        DeleteUserResponse response = new DeleteUserResponse();
        response.setDeletedUser(true);
        return response;
    }

    @Transactional
    public UserResponse updateUser(UpdateUser request) {
        UserModel userModel = repository.findById(request.getId()).orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
        userModel.setName(request.getName());
        userModel.setEmail(request.getEmail());

        UserModel savedUser = repository.save(userModel);

        Address address = AddressMapper.toXml(savedUser.getAddress());
        User user = UserMapper.toXml(savedUser, address);

        return generateUserResponse(user);
    }

    private UserResponse generateUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);

        return userResponse;
    }
}
