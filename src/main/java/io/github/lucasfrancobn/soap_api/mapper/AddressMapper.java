package io.github.lucasfrancobn.soap_api.mapper;

import com.example.soap.address.Address;
import com.example.soap.address.AddressResponse;
import io.github.lucasfrancobn.soap_api.model.AddressModel;

public final class AddressMapper {
    public static AddressModel toModel(Address address) {
        AddressModel addressModel = new AddressModel();
        addressModel.setCep(address.getCep());
        addressModel.setStreet(address.getStreet());
        addressModel.setComplement(address.getComplement());
        addressModel.setUnit(address.getUnit());
        addressModel.setDistrict(address.getDistrict());
        addressModel.setCity(address.getCity());
        addressModel.setStateCode(address.getStateCode());
        addressModel.setState(address.getState());

        return addressModel;
    }

    public static Address toXml(AddressModel model) {
        Address address = new Address();
        address.setId(model.getId());
        address.setCep(model.getCep());
        address.setStreet(model.getStreet());
        address.setComplement(model.getComplement());
        address.setUnit(model.getUnit());
        address.setDistrict(model.getDistrict());
        address.setCity(model.getCity());
        address.setStateCode(model.getStateCode());
        address.setState(model.getState());

        return address;
    }
}
