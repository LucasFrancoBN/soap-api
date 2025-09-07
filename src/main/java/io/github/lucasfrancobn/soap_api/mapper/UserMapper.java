package io.github.lucasfrancobn.soap_api.mapper;

import com.example.soap.address.Address;
import com.example.soap.users.CreateUser;
import com.example.soap.users.User;
import io.github.lucasfrancobn.soap_api.model.AddressModel;
import io.github.lucasfrancobn.soap_api.model.UserModel;

public final class UserMapper {
    public static User toXml(UserModel userModel, Address address) {
        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setEmail(userModel.getEmail());
        user.setAddress(address);

        return user;
    }

    public static UserModel toModel(CreateUser request, AddressModel addressModel) {
        UserModel userModel = new UserModel();
        userModel.setName(request.getName());
        userModel.setEmail(request.getEmail());
        userModel.setAddress(addressModel);

        return userModel;
    }
}
