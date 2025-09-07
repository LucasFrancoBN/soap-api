package io.github.lucasfrancobn.soap_api.services;



import com.example.soap.address.Address;
import com.example.soap.address.AddressResponse;
import io.github.lucasfrancobn.soap_api.dto.ViaCepResponse;
import io.github.lucasfrancobn.soap_api.feign.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final ViaCepClient feign;

    public AddressService(ViaCepClient feign) {
        this.feign = feign;
    }

    public AddressResponse findCep(String request) {
        ViaCepResponse viaCepResponse = feign.buscarEnderecoPorCep(request);

        return generateAddressResponse(viaCepResponse);
    }

    private AddressResponse generateAddressResponse(ViaCepResponse viaCepResponse) {
        AddressResponse response = new AddressResponse();
        Address address = new Address();
        address.setCep(viaCepResponse.getCep());
        address.setStreet(viaCepResponse.getLogradouro());
        address.setComplement(viaCepResponse.getComplemento());
        address.setUnit(viaCepResponse.getUnidade());
        address.setDistrict(viaCepResponse.getBairro());
        address.setCity(viaCepResponse.getLocalidade());
        address.setStateCode(viaCepResponse.getUf());
        address.setState(viaCepResponse.getEstado());
        response.setAddress(address);

        return response;
    }
}
